package io.obswebsocket.community.client.message.response.sources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.obswebsocket.community.client.message.response.AbstractResponseSerializationTest;
import org.junit.jupiter.api.Test;

public class SourcesResponseSerializationTest extends AbstractResponseSerializationTest {

  public static final String TYPE = "sources";

  @Test
  void getSourceActiveResponse() {
    assertResponse(TYPE, GetSourceActiveResponse.class, d -> {
      assertTrue(d.getVideoActive());
      assertTrue(d.getVideoShowing());
    });
  }

  @Test
  void getSourceScreenshotResponse() {
    assertResponse(TYPE, GetSourceScreenshotResponse.class, d -> {
      assertEquals("base64:abcdef0123456789", d.getImageData());
    });
  }

  @Test
  void saveSourceScreenshotResponse() {
    assertResponse(TYPE, SaveSourceScreenshotResponse.class, d -> {
      assertEquals("base64:abcdef0123456789", d.getImageData());
    });
  }
}
