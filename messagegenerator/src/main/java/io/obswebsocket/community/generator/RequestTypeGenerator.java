package io.obswebsocket.community.generator;

import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PRIVATE;
import static javax.lang.model.element.Modifier.PUBLIC;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.WildcardTypeName;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.generator.model.generated.Protocol;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Generates Request classes
 */
@Slf4j
@RequiredArgsConstructor
public class RequestTypeGenerator extends GeneratorBase {

  private final Protocol protocol;

  public void generate() {
    File targetFile = new File(RequestGenerator.requestFolder, "RequestType.java");
    try (PrintStream out = new PrintStream(targetFile)) {
      generateRequestType(out);
    } catch (IOException e) {
      log.error("Unable to write {}", targetFile, e);
    }
  }

  private void generateRequestType(PrintStream out) throws IOException {
    TypeSpec.Builder classTypeBuilder = TypeSpec.enumBuilder(RequestType.class.getSimpleName())
        .addModifiers(PUBLIC)
        .addAnnotation(Getter.class)
        .addAnnotation(RequiredArgsConstructor.class)
        .addField(ParameterizedTypeName.get(ClassName.get(Class.class),
            WildcardTypeName.subtypeOf(Request.class)), "requestClass", PRIVATE, FINAL)
        .addField(ParameterizedTypeName.get(ClassName.get(Class.class), WildcardTypeName.subtypeOf(
            RequestResponse.class)), "requestResponseClass", PRIVATE, FINAL);

    protocol.getRequests().forEach(req -> classTypeBuilder.addEnumConstant(req.getRequestType(),
        TypeSpec.anonymousClassBuilder("$T.class, $T.class",
            ClassName.get(RequestGenerator.BASE_PACKAGE + req.getCategory(),
                req.getRequestType() + "Request"),
            ClassName.get(ResponseGenerator.BASE_PACKAGE + req.getCategory(),
                req.getRequestType() + "Response")
        ).build()
    ));

    JavaFile javaFile = javaFileBuilder(RequestType.class.getPackage().getName(),
        classTypeBuilder.build()).build();
    javaFile.writeTo(out);
  }
}
