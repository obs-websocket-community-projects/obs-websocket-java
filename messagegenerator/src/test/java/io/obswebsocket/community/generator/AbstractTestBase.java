package io.obswebsocket.community.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.spy;

import io.obswebsocket.community.generator.model.generated.RequestField;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

abstract class AbstractTestBase {

  /**
   * Use this to re-generate the output when the generator changes. Be sure that the expected
   * results are what they are supposed to be!
   *
   * @throws Exception Should not be thrown
   */
  @Test
  @Disabled
  void generateOutputs() throws Exception {
    generateOutput(EventGeneratorTest.class);
  }

  private <T extends AbstractTestBase> void generateOutput(Class<T> base) throws Exception {
    AbstractTestBase instance = spy(base);
    doAnswer(m -> {
      String path = m.getArgument(0);
      ByteArrayOutputStream bar = m.getArgument(1);
      FileUtils.write(new File("src/test/resources/" + path), bar.toString(),
          StandardCharsets.UTF_8);
      return null;
    }).when(instance).assertResult(any(), any());
    instance.withoutParams();
    instance.withParams();
  }

  abstract void withoutParams() throws IOException;

  abstract void withParams() throws IOException;

  protected void assertResult(String path, ByteArrayOutputStream bar) {
    assertEquals(readExpected(path),
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
