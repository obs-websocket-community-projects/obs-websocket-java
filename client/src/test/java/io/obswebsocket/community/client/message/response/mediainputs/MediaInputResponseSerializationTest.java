package io.obswebsocket.community.client.message.response.mediainputs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.internal.LazilyParsedNumber;
import io.obswebsocket.community.client.message.response.AbstractResponseSerializationTest;
import io.obswebsocket.community.client.model.MediaState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MediaInputResponseSerializationTest extends AbstractResponseSerializationTest {

  public static final String TYPE = "mediainputs";

  @Test
  void getMediaInputStatusResponse() {
    assertResponse(TYPE, GetMediaInputStatusResponse.class, d -> {
      assertEquals(MediaState.BUFFERING, d.getMediaState());
      assertEquals(new LazilyParsedNumber("123"), d.getMediaDuration());
      assertEquals(new LazilyParsedNumber("321"), d.getMediaCursor());
    });
  }

  @Test
  void setMediaInputCursorResponse() {
    assertResponse(TYPE, SetMediaInputCursorResponse.class, Assertions::assertNull);
  }

  @Test
  void offsetMediaInputCursorResponse() {
    assertResponse(TYPE, OffsetMediaInputCursorResponse.class, Assertions::assertNull);
  }

  @Test
  void triggerMediaInputActionResponse() {
    assertResponse(TYPE, TriggerMediaInputActionResponse.class, Assertions::assertNull);
  }
}
