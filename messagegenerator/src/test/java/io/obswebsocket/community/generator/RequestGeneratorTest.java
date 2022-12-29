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

class RequestGeneratorTest extends AbstractTestBase {

  @Test
  void generate() throws IOException {
    Request request = Request.builder().build();
    RequestGenerator generatorSpy = spy(
        new RequestGenerator(Protocol.builder().request(request).build()));
    doNothing().when(generatorSpy).generateRequest(any(), any());
    doNothing().when(generatorSpy).cleanOldMessages(any());
    doReturn(new PrintStream(new ByteArrayOutputStream())).when(generatorSpy).streamFor(any());

    generatorSpy.generate();

    verify(generatorSpy, times(1)).generateRequest(eq(request), any());
    verify(generatorSpy, times(1)).cleanOldMessages(eq(RequestGenerator.REQUEST_FOLDER));
  }

  @Test
  void determineTarget() {
    File targetFile = new RequestGenerator(null).determineTarget(
        Request.builder().category("somecategory").requestType("SomeRequest").build());

    assertEquals(new File(RequestGenerator.REQUEST_FOLDER, "somecategory/SomeRequestRequest.java"),
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
    new RequestGenerator(null).generateRequest(request, new PrintStream(bar));

    assertResult("/RequestWithoutParameters.java", bar);
  }

  @Test
  void withParams() throws IOException {
    Request request = Request.builder()
        .requestType("Type")
        .description("Description")
        .category("category")
        .requestFields(buildDataFields())
        .build();

    ByteArrayOutputStream bar = new ByteArrayOutputStream();
    new RequestGenerator(null).generateRequest(request, new PrintStream(bar));

    assertResult("/RequestWithParameters.java", bar);
  }
}
