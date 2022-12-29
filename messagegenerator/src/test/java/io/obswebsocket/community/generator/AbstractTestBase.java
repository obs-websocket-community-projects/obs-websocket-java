package io.obswebsocket.community.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import io.obswebsocket.community.generator.model.generated.RequestField;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.IOUtils;

abstract class AbstractTestBase {

  void withoutParams() throws IOException {
  }

  void withParams() throws IOException {
  }

  protected void assertResult(String path, ByteArrayOutputStream bar) {
    assertEquals(this.readExpected(path),
        new String(bar.toByteArray(), StandardCharsets.UTF_8).trim());
  }

  protected List<RequestField> buildDataFields() {
    List<RequestField> fields = new ArrayList<>();

    // Regular fields
    fields.add(RequestField.builder().valueType("String").valueName("stringField")
        .valueDescription("stringField description").build());
    fields.add(RequestField.builder().valueType("Boolean").valueName("booleanField")
        .valueDescription("booleanField description").build());

    // Arrays
    fields.add(RequestField.builder().valueType("Array<Boolean>").valueName("booleanList")
        .valueDescription("booleanList description").build());
    fields.add(RequestField.builder().valueType("Array<String>").valueName("stringList")
        .valueDescription("stringList description").build());

    // Other types
    fields.add(
        RequestField.builder().valueType("io.obswebsocket.community.client.model.Input.AudioTracks")
            .valueName("audioTracks").valueDescription("audioTracks description").build());
    fields.add(
        RequestField.builder().valueType("JsonObject").valueName("jsonObject")
            .valueDescription("jsonObject description").build());
    fields.add(
        RequestField.builder().valueType("Array<Scene>").valueName("sceneList")
            .valueDescription("sceneList description").build());

    return fields;
  }

  protected String readExpected(String path) {
    InputStream stream = AbstractTestBase.class.getResourceAsStream(path);
    Objects.requireNonNull(stream, path + " can't be read");
    try {
      return String.join("\n", IOUtils.readLines(stream, StandardCharsets.UTF_8)).trim();
    } catch (IOException e) {
      fail(e);
      return null;
    }
  }
}
