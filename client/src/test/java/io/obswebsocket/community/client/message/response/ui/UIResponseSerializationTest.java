package io.obswebsocket.community.client.message.response.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.obswebsocket.community.client.message.response.AbstractResponseSerializationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UIResponseSerializationTest extends AbstractResponseSerializationTest {

  public static final String TYPE = "ui";

  @Test
  void getStudioModeEnabledResponse() {
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

  @Test
  void getMonitorListResponse() {
    assertResponse(TYPE, GetMonitorListResponse.class, d -> {
      assertThat(d.getMonitors().size()).isEqualTo(2);
      assertThat(d.getMonitors().get(0).getMonitorIndex()).isEqualTo(0);
      assertThat(d.getMonitors().get(0).getMonitorName()).isEqualTo("\\\\.\\DISPLAY1(0)");
      assertThat(d.getMonitors().get(0).getMonitorWidth()).isEqualTo(1920);
    });
  }

  @Test
  void openVideoMixProjectorResponse() {
    assertResponse(TYPE, OpenVideoMixProjectorResponse.class, Assertions::assertNull);
  }

  @Test
  void openSourceProjectorResponse() {
    assertResponse(TYPE, OpenSourceProjectorResponse.class, Assertions::assertNull);
  }
}
