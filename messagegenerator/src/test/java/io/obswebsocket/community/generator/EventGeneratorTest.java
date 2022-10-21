package io.obswebsocket.community.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.generator.model.generated.Event;
import io.obswebsocket.community.generator.model.generated.Protocol;
import io.obswebsocket.community.generator.model.generated.RequestField;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

class EventGeneratorTest extends AbstractTestBase {

  @Test
  void generate() throws IOException {
    Event event = Event.builder().build();
    EventGenerator generatorSpy = spy(new EventGenerator(Protocol.builder().event(event).build()));
    doNothing().when(generatorSpy).generateEvent(any(), any());
    doNothing().when(generatorSpy).cleanOldMessages(any());

    generatorSpy.generate();

    verify(generatorSpy, times(1)).generateEvent(eq(event), any());
    verify(generatorSpy, times(1)).cleanOldMessages(eq(EventGenerator.eventFolder));
  }

  @Test
  void determineTarget() {
    File targetFile = new EventGenerator(null).determineTarget(
        Event.builder().category("somecategory").eventType("SomeEvent").build());

    assertEquals(new File(EventGenerator.eventFolder, "somecategory/SomeEventEvent.java"),
        targetFile);
  }

  @Test
  void withoutParams() throws IOException {
    Event event = Event.builder()
        .eventType("Type")
        .description("Description")
        .category("category")
        .eventSubscription("subscription")
        .build();

    ByteArrayOutputStream bar = new ByteArrayOutputStream();
    new EventGenerator(null).generateEvent(event, new PrintStream(bar));

    assertResult("/EventWithoutParameters.java", bar);
  }

  @Test
  void withParams() throws IOException {
    Event event = Event.builder()
        .eventType("Type")
        .description("Description")
        .category("category")
        .eventSubscription("subscription")
        .dataFields(buildDataFields())
        .build();

    ByteArrayOutputStream bar = new ByteArrayOutputStream();
    new EventGenerator(null).generateEvent(event, new PrintStream(bar));

    assertResult("/EventWithParameters.java", bar);
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
    InputStream stream = EventGeneratorTest.class.getResourceAsStream(path);
    Objects.requireNonNull(stream, path + " can't be read");
    try {
      return String.join("\n", IOUtils.readLines(stream, StandardCharsets.UTF_8)).trim();
    } catch (IOException e) {
      fail(e);
      return null;
    }
  }
}
