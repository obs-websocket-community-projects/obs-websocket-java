package io.obswebsocket.community.generator;

import static javax.lang.model.element.Modifier.ABSTRACT;
import static javax.lang.model.element.Modifier.PUBLIC;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
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
    try (PrintStream out = new PrintStream(targetFile)) {
      generate(out);
    } catch (IOException e) {
      log.error("Unable to write {}", targetFile, e);
    }
  }

  private void generate(PrintStream out) throws IOException {

    TypeSpec.Builder classTypeBuilder =
        TypeSpec.classBuilder(OBSRemoteControllerBase.class.getSimpleName())
            .addModifiers(PUBLIC, ABSTRACT)
            .addMethod(generateAbstractSendRequest())
            .addJavadoc(GeneratorMain.GENERATED_MSG);

    protocol.getRequests().forEach(req -> addMethodFor(classTypeBuilder, req));

    JavaFile javaFile = JavaFile.builder(OBSRemoteControllerBase.class.getPackage().getName(),
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
      io.obswebsocket.community.generator.model.generated.Request req) {

    String type = req.getRequestType();
    MethodSpec.Builder builder = MethodSpec.methodBuilder(
            Character.toLowerCase(type.charAt(0)) + type.substring(1))
        .addModifiers(PUBLIC);

    req.getRequestFields()
        .forEach(rf -> builder.addParameter(determineType(req, rf), rf.getValueName()));

    builder.addParameter(
        ParameterizedTypeName.get(ClassName.get(Consumer.class),
            ClassName.get(ResponseGenerator.BASE_PACKAGE + req.getCategory(), type + "Response")),
        "callback");

    // Body
    CodeBlock.Builder bodyBuilder = CodeBlock.builder();
    bodyBuilder.add("sendRequest(");
    bodyBuilder.add("$T.builder()", ClassName.get(RequestGenerator.BASE_PACKAGE + req.getCategory(),
        req.getRequestType() + "Request"));
    req.getRequestFields()
        .forEach(rf -> bodyBuilder.add(".$L($L)", rf.getValueName(), rf.getValueName()));
    bodyBuilder.add(".build()");
    bodyBuilder.add(", callback)");
    builder.addStatement(bodyBuilder.build());

    builder.addJavadoc("$L\n", req.getDescription().replace("\\u", "\\\\u"));
    req.getRequestFields()
        .forEach(rf ->
            builder.addJavadoc("\n@param $L $L", rf.getValueName(),
                rf.getValueDescription().replace("\\u", "\\\\u")));

    classTypeBuilder.addMethod(builder.build());
  }
}
