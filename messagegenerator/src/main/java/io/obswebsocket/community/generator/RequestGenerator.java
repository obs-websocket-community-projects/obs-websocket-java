package io.obswebsocket.community.generator;

import static io.obswebsocket.community.client.message.request.Request.Data;
import static javax.lang.model.element.Modifier.PRIVATE;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;

import com.google.gson.JsonObject;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import io.obswebsocket.community.generator.model.generated.Protocol;
import io.obswebsocket.community.generator.model.generated.Request;
import io.obswebsocket.community.generator.model.generated.RequestField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Generates Request classes
 */
@Slf4j
@RequiredArgsConstructor
public class RequestGenerator {

  private static final File requestFolder = new File(GeneratorMain.target, "request");
  private static final String BASE_PACKAGE = "io.obswebsocket.community.client.message.request.";
  private final Protocol protocol;

  public void generate() {
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
    return new PrintStream(target);
//    return System.out;
  }

  private void generateRequestResponse(Request request, PrintStream out) throws IOException {
    String pkg = BASE_PACKAGE + request.getCategory();
    String className = request.getRequestType() + "Request";

    TypeSpec specificData = buildSpecificData(request);

    MethodSpec constructor = buildConstructor(request, specificData);

    TypeSpec.Builder classTypeBuilder = TypeSpec.classBuilder(className).addModifiers(PUBLIC)
        .addAnnotation(Getter.class).addAnnotation(
            AnnotationSpec.builder(ToString.class).addMember("callSuper", "$L", true).build())
        .addJavadoc("$L", request.getDescription());
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

  private TypeSpec buildSpecificData(Request request) {
    if (request.getRequestFields().isEmpty()) {
      return null;
    }

    TypeSpec.Builder specificData = TypeSpec.classBuilder("SpecificData")
        .addModifiers(STATIC)
        .addAnnotation(Getter.class).addAnnotation(ToString.class).addAnnotation(Builder.class);

    request.getRequestFields().forEach(field -> {
      FieldSpec.Builder fldBuilder = FieldSpec.builder(determineType(request, field),
          field.getValueName(), PRIVATE);
      if (!Boolean.TRUE.equals(field.valueOptional)) {
        fldBuilder.addAnnotation(NonNull.class);
      }
      specificData.addField(fldBuilder.build());
    });

    return specificData.build();
  }

  private MethodSpec buildConstructor(Request request, TypeSpec specificData) {
    MethodSpec.Builder constructor = MethodSpec.constructorBuilder().addModifiers(PRIVATE)
        .addAnnotation(Builder.class);
    request.getRequestFields()
        .forEach(rf -> constructor.addParameter(determineType(request, rf), rf.getValueName()));

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
    constructor.addStatement("super($T.$L, $L)", Data.Type.class, request.getRequestType(),
        builder.build());

    return constructor.build();
  }

  private TypeName determineType(Request request, RequestField rf) {
    switch (rf.getValueType()) {
      case "Number":
        return TypeName.INT;
      case "Boolean":
        return TypeName.BOOLEAN;
      case "String":
        return TypeName.get(String.class);
      case "JsonObject":
        log.warn("{}.{} is of type JsonObject, is this correct?", request.getRequestType(),
            rf.getValueName());
        return TypeName.get(JsonObject.class);
      default:
        return determineComplexType(request, rf);
    }
  }

  private static TypeName determineComplexType(Request request, RequestField rf) {
    try {
      // Type in the model package
      Class<?> classType = Class.forName(
          "io.obswebsocket.community.client.message.model." + rf.getValueType());
      return TypeName.get(classType);
    } catch (ClassNotFoundException e) {
      log.debug("Unable to find type {}", rf.getValueType());
    }

    try {
      // Fully qualified type
      Class<?> classType = Class.forName(rf.getValueType());
      return TypeName.get(classType);
    } catch (ClassNotFoundException e) {
      log.debug("Unable to find type {}", rf.getValueType());
    }

    try {
      // Nested type
      StringBuilder sb = new StringBuilder(rf.getValueType());
      int idx = sb.lastIndexOf(".");
      if (idx != -1) {
        sb.replace(idx, idx + 1, "$");
        Class<?> classType = Class.forName(sb.toString());
        return TypeName.get(classType);
      }
    } catch (ClassNotFoundException e) {
      log.debug("Unable to find type {}", rf.getValueType());
    }

    log.error("Unable to get type ({}) for {}.{}", rf.getValueType(), request.getRequestType(),
        rf.getValueName());
    return TypeName.get(Object.class);
  }
}
