package io.obswebsocket.community.generator;

import static javax.lang.model.element.Modifier.PUBLIC;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.generator.model.generated.Protocol;
import io.obswebsocket.community.generator.model.generated.Request;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Generates Request classes
 */
@Slf4j
@RequiredArgsConstructor
public class ResponseGenerator extends GeneratorBase {

  public static final File responseFolder = new File(GeneratorMain.target, "response");
  public static final String BASE_PACKAGE = "io.obswebsocket.community.client.message.response.";
  private final Protocol protocol;

  public void generate() {
    cleanOldMessages(responseFolder);
    protocol.getRequests().forEach(req -> {
      try (PrintStream out = determineTarget(req)) {
        generateRequestResponse(req, out);
      } catch (Exception e) {
        log.error("Unable to write {}", req, e);
      }
    });
  }

  private PrintStream determineTarget(Request req) throws FileNotFoundException {
    File target = new File(responseFolder,
        req.getCategory() + "/" + req.getRequestType() + "Response.java");
    log.trace("Created parent directory for {}: {}", target, target.getParentFile().mkdirs());
    return new PrintStream(target);
  }

  private void generateRequestResponse(Request request, PrintStream out) throws IOException {
    String pkg = BASE_PACKAGE + request.getCategory();
    String className = request.getRequestType() + "Response";

    TypeSpec specificData = buildSpecificData(request, request.getResponseFields(), true);

    TypeSpec.Builder classTypeBuilder = TypeSpec.classBuilder(className).addModifiers(PUBLIC)
        .addAnnotation(Getter.class).addAnnotation(
            AnnotationSpec.builder(ToString.class).addMember("callSuper", "$L", true).build())
        .addJavadoc(GeneratorMain.GENERATED_MSG);
    if (specificData != null) {
      classTypeBuilder.addType(specificData)
          .superclass(ParameterizedTypeName.get(
              ClassName.get(RequestResponse.class),
              ClassName.get("", className + ".SpecificData")))
      ;
    } else {
      classTypeBuilder.superclass(ParameterizedTypeName.get(
          ClassName.get(RequestResponse.class),
          ClassName.get("", "Void")));
    }
    TypeSpec classType = classTypeBuilder.build();

    JavaFile javaFile = JavaFile.builder(pkg, classType).build();
    javaFile.writeTo(out);
  }
}
