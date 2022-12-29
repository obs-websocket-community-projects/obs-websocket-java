package io.obswebsocket.community.generator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.generator.model.generated.Event;
import io.obswebsocket.community.generator.model.generated.Protocol;
import io.obswebsocket.community.generator.model.generated.Request;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class OBSRemoteControllerBaseGeneratorTest extends AbstractTestBase {

  @Test
  void generate() throws IOException {
    Event event = Event.builder().build();
    OBSRemoteControllerBaseGenerator generatorSpy = spy(
        new OBSRemoteControllerBaseGenerator(Protocol.builder().event(event).build()));
    doNothing().when(generatorSpy).generate(any());
    doReturn(new PrintStream(new ByteArrayOutputStream())).when(generatorSpy).streamFor(any());

    generatorSpy.generate();

    verify(generatorSpy, times(1)).generate(any());
  }

  @Test
  void withoutParams() throws IOException {
    Protocol protocol = Protocol.builder()
        .request(Request.builder().requestType("SomeType").description("Description").build())
        .request(
            Request.builder().requestType("OtherType").description("Other description")
                .requestFields(this.buildDataFields()).build())
        .build();

    ByteArrayOutputStream bar = new ByteArrayOutputStream();
    new OBSRemoteControllerBaseGenerator(protocol).generate(new PrintStream(bar));

    this.assertResult("/OBSRemoteControllerBaseGenerator.java", bar);
  }
}
