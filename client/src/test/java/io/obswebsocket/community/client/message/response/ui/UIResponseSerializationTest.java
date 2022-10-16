package io.obswebsocket.community.client.message.response.ui;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.obswebsocket.community.client.message.response.AbstractResponseSerializationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UIResponseSerializationTest extends AbstractResponseSerializationTest {

  public static final String TYPE = "ui";

  @Test
  void getSceneListResponse() {
    assertResponse(TYPE, GetStudioModeEnabledResponse.class,
        d -> assertTrue(d.getStudioModeEnabled()));
  }

  @Test
  void setStudioModeEnabledResponse() {
    assertResponse(TYPE, SetStudioModeEnabledResponse.class, Assertions::assertNull);
  }

  @Test
  void openInputPropertiesDialogResponse() {
    assertResponse(TYPE, OpenInputPropertiesDialogResponse.class, Assertions::assertNull);
  }

  @Test
  void openInputFiltersDialogResponse() {
    assertResponse(TYPE, OpenInputFiltersDialogResponse.class, Assertions::assertNull);
  }

  @Test
  void openInputInteractDialogResponse() {
    assertResponse(TYPE, OpenInputInteractDialogResponse.class, Assertions::assertNull);
  }
}
