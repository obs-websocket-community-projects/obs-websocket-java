package io.obswebsocket.community.client.message.request.ui;

import io.obswebsocket.community.client.message.request.AbstractRequestSerializationTest;
import org.junit.jupiter.api.Test;

public class UIRequestSerializationTest extends AbstractRequestSerializationTest {

  private static final String TYPE = "ui";

  @Test
  void getStudioModeEnabledRequest() {
    assertRequest(TYPE, GetStudioModeEnabledRequest.builder().build());
  }

  @Test
  void setStudioModeEnabledRequest() {
    assertRequest(TYPE, SetStudioModeEnabledRequest.builder().studioModeEnabled(true).build());
  }

  @Test
  void openInputPropertiesDialogRequest() {
    assertRequest(TYPE, OpenInputPropertiesDialogRequest.builder().inputName("SomeName").build());
  }

  @Test
  void openInputFiltersDialogRequest() {
    assertRequest(TYPE, OpenInputFiltersDialogRequest.builder().inputName("SomeName").build());
  }

  @Test
  void openInputInteractDialogRequest() {
    assertRequest(TYPE, OpenInputInteractDialogRequest.builder().inputName("SomeName").build());
  }

  @Test
  void getMonitorListRequest() {
    assertRequest(TYPE, GetMonitorListRequest.builder().build());
  }
}
