package io.obswebsocket.community.generator;

import static javax.lang.model.element.Modifier.PRIVATE;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;

import com.google.gson.JsonObject;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import io.obswebsocket.community.generator.model.generated.Request;
import io.obswebsocket.community.generator.model.generated.RequestField;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

/**
 * Generates Request classes
 */
@Slf4j
@RequiredArgsConstructor
public class GeneratorBase {

  protected void cleanOldMessages(File folder) {
    File[] toDelete = folder.listFiles(File::isDirectory);
    Stream.of(Objects.requireNonNull(toDelete, "Unable to delete old files")).forEach(dir -> {
      try {
        FileUtils.deleteDirectory(dir);
      } catch (IOException e) {
        log.error("Unable to delete {}", folder);
      }
    });
  }

  protected TypeSpec buildSpecificData(Request request, List<RequestField> fields,
      boolean response) {
    if (fields.isEmpty()) {
      return null;
    }

    TypeSpec.Builder specificData = TypeSpec.classBuilder("SpecificData")
        .addModifiers(STATIC)
        .addAnnotation(Getter.class).addAnnotation(ToString.class);

    if (!response) {
      specificData.addAnnotation(Builder.class);
    } else {
      specificData.addModifiers(PUBLIC);
    }

    fields.forEach(field -> {
      FieldSpec.Builder fldBuilder = FieldSpec.builder(determineType(request, field),
          field.getValueName(), PRIVATE);
      if (!Boolean.TRUE.equals(field.valueOptional)) {
        fldBuilder.addAnnotation(NonNull.class);
      }
      if (response) {
        fldBuilder.addJavadoc(field.getValueDescription());
      }
      specificData.addField(fldBuilder.build());
    });

    return specificData.build();
  }

  private static final Pattern ARRAY_PATTERN = Pattern.compile("Array<(.*)>");

  protected TypeName determineType(Request request, RequestField rf) {
    return determineType(request, rf, rf.getValueType());
  }

  private TypeName determineType(Request request, RequestField rf, String type) {

    Matcher matcher = ARRAY_PATTERN.matcher(type);
    if (matcher.matches()) {
      return ParameterizedTypeName.get(ClassName.get(List.class),
          determineType(request, rf, matcher.group(1)));
    }

    switch (type) {
      case "Number":
        return TypeName.get(Number.class);
      case "Boolean":
        return TypeName.get(Boolean.class);
      case "String":
        return TypeName.get(String.class);
      case "JsonObject":
        return TypeName.get(JsonObject.class);
      default:
        return determineComplexType(request, rf, type);
    }
  }

  private static TypeName determineComplexType(Request request, RequestField rf, String type) {
    try {
      // Type in the model package
      Class<?> classType = Class.forName(
          "io.obswebsocket.community.client.model." + type);
      return TypeName.get(classType);
    } catch (ClassNotFoundException e) {
      log.debug("Unable to find type {}", type);
    }

    try {
      // Fully qualified type
      Class<?> classType = Class.forName(type);
      return TypeName.get(classType);
    } catch (ClassNotFoundException e) {
      log.debug("Unable to find type {}", type);
    }

    try {
      // Nested type
      StringBuilder sb = new StringBuilder(type);
      int idx = sb.lastIndexOf(".");
      if (idx != -1) {
        sb.replace(idx, idx + 1, "$");
        Class<?> classType = Class.forName(sb.toString());
        return TypeName.get(classType);
      }
    } catch (ClassNotFoundException e) {
      log.debug("Unable to find type {}", type);
    }

    log.error("Unable to get type ({}) for {}.{}", type, request.getRequestType(),
        rf.getValueName());
    return TypeName.get(Object.class);
  }
}