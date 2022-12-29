package io.obswebsocket.community.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.generator.model.generated.Protocol;
import io.obswebsocket.community.generator.model.generated.Request;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class ResponseGeneratorTest extends AbstractTestBase {

  @Test
  void generate() throws IOException {
    Request request = Request.builder().build();
    ResponseGenerator generatorSpy = spy(
        new ResponseGenerator(Protocol.builder().request(request).build()));
    doNothing().when(generatorSpy).generateResponse(any(), any());
    doNothing().when(generatorSpy).cleanOldMessages(any());
    doReturn(new PrintStream(new ByteArrayOutputStream())).when(generatorSpy).streamFor(any());

    generatorSpy.generate();

    verify(generatorSpy, times(1)).generateResponse(eq(request), any());
    verify(generatorSpy, times(1)).cleanOldMessages(eq(ResponseGenerator.RESPONSE_FOLDER));
  }

  @Test
  void determineTarget() {
    File targetFile = new ResponseGenerator(null).determineTarget(
        Request.builder().category("somecategory").requestType("SomeResponse").build());

    assertEquals(
        new File(ResponseGenerator.RESPONSE_FOLDER, "somecategory/SomeResponseResponse.java"),
        targetFile);
  }

  @Test
  void withoutParams() throws IOException {
    Request request = Request.builder()
        .requestType("Type")
        .description("Description")
        .category("category")
        .build();

    ByteArrayOutputStream bar = new ByteArrayOutputStream();
    new ResponseGenerator(null).generateResponse(request, new PrintStream(bar));

    assertResult("/ResponseWithoutParameters.java", bar);
  }

  @Test
  void withParams() throws IOException {
    Request request = Request.builder()
        .requestType("Type")
        .description("Description")
        .category("category")
        .responseFields(buildDataFields())
        .build();

    ByteArrayOutputStream bar = new ByteArrayOutputStream();
    new ResponseGenerator(null).generateResponse(request, new PrintStream(bar));

    assertResult("/ResponseWithParameters.java", bar);
  }
}
