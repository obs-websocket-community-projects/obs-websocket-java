package io.obswebsocket.community.generator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.generator.model.generated.Event;
import io.obswebsocket.community.generator.model.generated.Protocol;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class EventTypeGeneratorTest extends AbstractTestBase {

  @Test
  void generate() throws IOException {
    Event event = Event.builder().build();
    EventTypeGenerator generatorSpy = spy(
        new EventTypeGenerator(Protocol.builder().event(event).build()));
    doNothing().when(generatorSpy).generateRequestType(any());
    doReturn(new PrintStream(new ByteArrayOutputStream())).when(generatorSpy).streamFor(any());

    generatorSpy.generate();

    verify(generatorSpy, times(1)).generateRequestType(any());
  }

  @Test
  void withoutParams() throws IOException {
    Protocol protocol = Protocol.builder()
        .event(Event.builder()
            .eventType("Type")
            .description("Description")
            .category("category")
            .eventSubscription("subscription").build())
        .event(Event.builder()
            .eventType("Other")
            .description("Description")
            .category("other")
            .eventSubscription("other").build())
        .build();

    ByteArrayOutputStream bar = new ByteArrayOutputStream();
    new EventTypeGenerator(protocol).generateRequestType(new PrintStream(bar));

    assertResult("/EventTypes.java", bar);
  }
}
