package io.obswebsocket.community.generator;

import static javax.lang.model.element.Modifier.PRIVATE;
import static javax.lang.model.element.Modifier.PUBLIC;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.generator.model.generated.Protocol;
import io.obswebsocket.community.generator.model.generated.Request;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Generates Request classes
 */
@Slf4j
@RequiredArgsConstructor
public class RequestGenerator extends GeneratorBase {

  public static final File requestFolder = new File(GeneratorMain.target, "request");
  public static final String BASE_PACKAGE = "io.obswebsocket.community.client.message.request.";
  private final Protocol protocol;

  public void generate() {
    cleanOldMessages(requestFolder);
    protocol.getRequests().forEach(req -> {
      try (PrintStream out = determineTarget(req)) {
        generateRequestResponse(req, out);
      } catch (Exception e) {
        log.error("Unable to write {}", req, e);
      }
    });
  }

  private PrintStream determineTarget(Request req) throws FileNotFoundException {
    File target = new File(requestFolder,
        req.getCategory() + "/" + req.getRequestType() + "Request.java");
    log.trace("Created parent directory for {}: {}", target, target.getParentFile().mkdirs());
    return new PrintStream(target);
  }

  private void generateRequestResponse(Request request, PrintStream out) throws IOException {
    String pkg = BASE_PACKAGE + request.getCategory();
    String className = request.getRequestType() + "Request";

    TypeSpec specificData = buildSpecificData(request.getRequestType(), request.getRequestFields(),
        false);

    MethodSpec constructor = buildConstructor(request, specificData);

    TypeSpec.Builder classTypeBuilder = TypeSpec.classBuilder(className).addModifiers(PUBLIC)
        .addAnnotation(Getter.class).addAnnotation(
            AnnotationSpec.builder(ToString.class).addMember("callSuper", "$L", true).build())
        .addJavadoc(GeneratorMain.GENERATED_MSG);
    if (specificData != null) {
      classTypeBuilder.addType(specificData)
          .superclass(ParameterizedTypeName.get(
              ClassName.get(io.obswebsocket.community.client.message.request.Request.class),
              ClassName.get("", className + ".SpecificData"))).addMethod(constructor);
    } else {
      classTypeBuilder.superclass(ParameterizedTypeName.get(
          ClassName.get(io.obswebsocket.community.client.message.request.Request.class),
          ClassName.get("", "Void"))).addMethod(constructor);
    }
    TypeSpec classType = classTypeBuilder.build();

    JavaFile javaFile = JavaFile.builder(pkg, classType).build();
    javaFile.writeTo(out);
  }


  private MethodSpec buildConstructor(Request request, TypeSpec specificData) {
    MethodSpec.Builder constructor = MethodSpec.constructorBuilder().addModifiers(PRIVATE)
        .addAnnotation(Builder.class);
    request.getRequestFields()
        .forEach(rf -> constructor.addParameter(determineType(request.getRequestType(), rf),
            rf.getValueName()));

    // Create builder string
    CodeBlock.Builder builder = CodeBlock.builder();
    if (specificData != null) {
      builder.add("$N.builder()", specificData);
      request.getRequestFields()
          .forEach(rf -> builder.add(".$N($N)", rf.getValueName(), rf.getValueName()));
      builder.add(".build()");
    } else {
      builder.add("$L", "null");
    }

    // Add constructor statement
    constructor.addStatement("super($T.$L, $L)", RequestType.class, request.getRequestType(),
        builder.build());

    return constructor.build();
  }
}
