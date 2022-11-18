package io.obswebsocket.community.generator;

import static javax.lang.model.element.Modifier.PROTECTED;
import static javax.lang.model.element.Modifier.PUBLIC;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import io.obswebsocket.community.generator.model.generated.Event;
import io.obswebsocket.community.generator.model.generated.Protocol;
import java.io.File;
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
public class EventGenerator extends GeneratorBase {

  public static final File eventFolder = new File(GeneratorMain.target, "event");
  public static final String BASE_PACKAGE = "io.obswebsocket.community.client.message.event.";
  private final Protocol protocol;

  public void generate() {
    cleanOldMessages(eventFolder);
    protocol.getEvents().forEach(event -> {
      try (PrintStream out = streamFor(determineTarget(event))) {
        generateEvent(event, out);
      } catch (Exception e) {
        log.error("Unable to write {}", event, e);
      }
    });
  }

  File determineTarget(Event req) {
    return new File(eventFolder,
        req.getCategory() + "/" + req.getEventType() + "Event.java");
  }

  void generateEvent(Event event, PrintStream out) throws IOException {
    String pkg = BASE_PACKAGE + event.getCategory();
    String className = event.getEventType() + "Event";

    TypeSpec specificData = buildSpecificData(event.getEventType(),
        event.getDataFields(), true);

    TypeSpec.Builder classTypeBuilder = TypeSpec.classBuilder(className).addModifiers(PUBLIC)
        .addAnnotation(Getter.class).addAnnotation(
            AnnotationSpec.builder(ToString.class).addMember("callSuper", "$L", true).build())
        .addJavadoc(event.getDescription()
            .replace("\\u", "\\\\u")
            .replaceAll("<", "&lt;")
            .replaceAll(">", "&gt;"));

    classTypeBuilder.addMethod(MethodSpec.constructorBuilder()
        .addModifiers(PROTECTED)
        .addStatement("super(Intent.$L)", event.getEventSubscription())
        .build());

    if (specificData != null) {
      ClassName specificDataClass = ClassName.get("", className + ".SpecificData");
      classTypeBuilder.addType(specificData)
          .superclass(ParameterizedTypeName.get(
              ClassName.get(io.obswebsocket.community.client.message.event.Event.class),
              specificDataClass));

      classTypeBuilder.addMethod(MethodSpec.constructorBuilder()
          .addModifiers(PROTECTED)
          .addParameter(specificDataClass, "data")
          .addStatement("super(Intent.$L, data)", event.getEventSubscription())
          .build());
    } else {
      classTypeBuilder.superclass(ParameterizedTypeName.get(
          ClassName.get(io.obswebsocket.community.client.message.event.Event.class),
          ClassName.get("", "Void")));
    }
    addGetters(MessageClass.Event, event.getEventType(), event.getDataFields(), classTypeBuilder);
    TypeSpec classType = classTypeBuilder.build();

    JavaFile javaFile = javaFileBuilder(pkg, classType).build();
    javaFile.writeTo(out);
  }
}
