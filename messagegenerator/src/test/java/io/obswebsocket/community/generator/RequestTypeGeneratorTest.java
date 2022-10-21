package io.obswebsocket.community.generator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.generator.model.generated.Protocol;
import io.obswebsocket.community.generator.model.generated.Request;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class RequestTypeGeneratorTest extends AbstractTestBase {

  @Test
  void generate() throws IOException {
    Request request = Request.builder().build();
    RequestTypeGenerator generatorSpy = spy(
        new RequestTypeGenerator(Protocol.builder().request(request).build()));
    doNothing().when(generatorSpy).generateRequestType(any());
    doReturn(new PrintStream(new ByteArrayOutputStream())).when(generatorSpy).streamFor(any());

    generatorSpy.generate();

    verify(generatorSpy, times(1)).generateRequestType(any());
  }

  @Test
  void withoutParams() throws IOException {
    Protocol protocol = Protocol.builder()
        .request(Request.builder().requestType("SomeType").description("Description").build())
        .request(
            Request.builder().requestType("OtherType").description("Other description")
                .requestFields(buildDataFields()).build())
        .build();

    ByteArrayOutputStream bar = new ByteArrayOutputStream();
    new RequestTypeGenerator(protocol).generateRequestType(new PrintStream(bar));

    assertResult("/RequestTypes.java", bar);
  }
}
