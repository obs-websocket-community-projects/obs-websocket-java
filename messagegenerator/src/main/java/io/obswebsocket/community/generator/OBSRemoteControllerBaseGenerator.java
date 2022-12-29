package io.obswebsocket.community.generator;

import static javax.lang.model.element.Modifier.ABSTRACT;
import static javax.lang.model.element.Modifier.PUBLIC;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;
import com.squareup.javapoet.TypeVariableName;
import io.obswebsocket.community.client.OBSRemoteControllerBase;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.generator.model.generated.Protocol;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OBSRemoteControllerBaseGenerator extends GeneratorBase {

  public static final File folder = new File(
      "./client/src/main/java/io/obswebsocket/community/client");
  private final Protocol protocol;

  public void generate() {
    File targetFile = new File(folder, OBSRemoteControllerBase.class.getSimpleName() + ".java");
    try (PrintStream out = this.streamFor(targetFile)) {
      this.generate(out);
    } catch (IOException e) {
      log.error("Unable to write {}", targetFile, e);
    }
  }

  void generate(PrintStream out) throws IOException {

    TypeSpec.Builder classTypeBuilder =
        TypeSpec.classBuilder(OBSRemoteControllerBase.class.getSimpleName())
            .addModifiers(PUBLIC, ABSTRACT)
            .addMethod(this.generateAbstractSendRequest());

    this.protocol.getRequests().forEach(req -> {
      this.addMethodFor(classTypeBuilder, req, false);
      this.addMethodFor(classTypeBuilder, req, true);
    });

    JavaFile javaFile = this.javaFileBuilder(OBSRemoteControllerBase.class.getPackage().getName(),
        classTypeBuilder.build()).build();
    javaFile.writeTo(out);
  }


  private MethodSpec generateAbstractSendRequest() {
    TypeVariableName requestName = TypeVariableName.get("R", Request.class);
    TypeVariableName responseName = TypeVariableName.get("RR", RequestResponse.class);
    ParameterizedTypeName consumer = ParameterizedTypeName.get(ClassName.get(Consumer.class),
        responseName);
    return MethodSpec
        .methodBuilder("sendRequest")
        .addModifiers(PUBLIC, ABSTRACT)
        .addTypeVariable(requestName)
        .addTypeVariable(responseName)
        .addParameter(requestName, "request")
        .addParameter(consumer, "callback")
        .build();
  }

  private void addMethodFor(Builder classTypeBuilder,
      io.obswebsocket.community.generator.model.generated.Request req,
      boolean blocking) {

    String type = req.getRequestType();
    MethodSpec.Builder builder = MethodSpec.methodBuilder(
            Character.toLowerCase(type.charAt(0)) + type.substring(1))
        .addModifiers(PUBLIC);

    req.getRequestFields()
        .forEach(
            rf -> builder.addParameter(this.determineType(req.getRequestType(), rf), rf.getValueName()));

    ClassName responseType = ClassName.get(ResponseGenerator.BASE_PACKAGE + req.getCategory(),
        type + "Response");
    if (!blocking) {
      builder.addParameter(
          ParameterizedTypeName.get(ClassName.get(Consumer.class), responseType),
          "callback");
    } else {
      builder.addParameter(TypeName.LONG, "timeout");
      builder.returns(responseType);
    }

    // Body
    CodeBlock.Builder bodyBuilder = CodeBlock.builder();
    if (blocking) {
      ParameterizedTypeName blockingConsumer = ParameterizedTypeName.get(
          ClassName.get(OBSRemoteControllerBase.class.getPackage().getName(), "BlockingConsumer"),
          responseType);
      builder.addStatement("$T callback = new $T()", blockingConsumer, blockingConsumer);
    }

    bodyBuilder.add("this.sendRequest(");
    bodyBuilder.add("$T.builder()", ClassName.get(RequestGenerator.BASE_PACKAGE + req.getCategory(),
        req.getRequestType() + "Request"));
    req.getRequestFields()
        .forEach(rf -> bodyBuilder.add(".$L($L)", rf.getValueName(), rf.getValueName()));
    bodyBuilder.add(".build(), callback)");
    builder.addStatement(bodyBuilder.build());
    if (blocking) {
      builder.addCode("try { return callback.get(timeout); } catch ($T e) { throw new $T(e); }",
          ClassName.get(InterruptedException.class), ClassName.get(RuntimeException.class));
    }

    builder.addJavadoc("$L\n", req.getDescription());
    req.getRequestFields()
        .forEach(rf ->
            builder.addJavadoc("\n@param $L $L", rf.getValueName(), rf.getValueDescription()));
    if (!blocking) {
      builder.addJavadoc("\n@param callback Consumer&lt;$L&gt;", type + "Response");
    } else {
      builder.addJavadoc("\n@param timeout long timeout in ms");
      builder.addJavadoc("\n@return the $T, null if the request timed out", responseType);
    }

    classTypeBuilder.addMethod(builder.build());
  }
}
