package io.obswebsocket.community.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.generator.model.generated.Event;
import io.obswebsocket.community.generator.model.generated.Protocol;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class EventGeneratorTest extends AbstractTestBase {

  @Test
  void generate() throws IOException {
    Event event = Event.builder().build();
    EventGenerator generatorSpy = spy(new EventGenerator(Protocol.builder().event(event).build()));
    doNothing().when(generatorSpy).generateEvent(any(), any());
    doNothing().when(generatorSpy).cleanOldMessages(any());
    doReturn(new PrintStream(new ByteArrayOutputStream())).when(generatorSpy).streamFor(any());

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
}
