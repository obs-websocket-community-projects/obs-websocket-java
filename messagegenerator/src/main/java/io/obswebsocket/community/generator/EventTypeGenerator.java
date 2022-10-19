package io.obswebsocket.community.generator;

import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PRIVATE;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.WildcardTypeName;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.event.EventType;
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
public class EventTypeGenerator {

  private final Protocol protocol;

  public void generate() {
    File targetFile = new File(EventGenerator.eventFolder, "EventType.java");
    try (PrintStream out = new PrintStream(targetFile)) {
//    try (PrintStream out = System.out) {
      generateRequestType(out);
    } catch (IOException e) {
      log.error("Unable to write {}", targetFile, e);
    }
  }

  private void generateRequestType(PrintStream out) throws IOException {
    TypeSpec.Builder classTypeBuilder = TypeSpec.enumBuilder(EventType.class.getSimpleName())
        .addModifiers(PUBLIC)
        .addAnnotation(Getter.class)
        .addAnnotation(RequiredArgsConstructor.class)
        .addField(ParameterizedTypeName.get(ClassName.get(Class.class),
            WildcardTypeName.subtypeOf(Event.class)), "eventClass", PRIVATE, FINAL);

    protocol.getEvents().forEach(req -> classTypeBuilder.addEnumConstant(req.getEventType(),
        TypeSpec.anonymousClassBuilder("$T.class",
            ClassName.get(EventGenerator.BASE_PACKAGE + req.getCategory(),
                req.getEventType() + "Event")
        ).build()
    ));
    classTypeBuilder.addMethod(fromMethod());

    JavaFile javaFile = JavaFile.builder(EventType.class.getPackage().getName(),
        classTypeBuilder.build()).build();
    javaFile.writeTo(out);
  }

  private MethodSpec fromMethod() {
    return MethodSpec.methodBuilder("from")
        .addModifiers(STATIC)
        .returns(EventType.class)
        .addParameter(ParameterizedTypeName.get(ClassName.get(Class.class),
            WildcardTypeName.subtypeOf(Event.class)), "eventClass")
        .beginControlFlow("for (EventType type : values())")
        .beginControlFlow("if (type.eventClass.equals(eventClass))")
        .addStatement("return type")
        .endControlFlow()
        .endControlFlow()
        .addStatement("return null")
        .build();
  }
}
