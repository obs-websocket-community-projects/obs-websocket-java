package io.obswebsocket.community.client.message.response.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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

  @Test
  void getMonitorListResponse() {
    assertResponse(TYPE, GetMonitorListResponse.class, d -> {
      JsonObject o1 = new JsonObject();
      o1.addProperty("key", "value");
      JsonObject o2 = new JsonObject();
      o2.addProperty("key", "value");

      JsonArray arr = new JsonArray();
      arr.add(o1);
      arr.add(o2);
      assertThat(d.getMonitors()).usingRecursiveComparison().isEqualTo(arr);
    });
  }

  @Test
  void openVideoMixProjectorResponse() {
    assertResponse(TYPE, OpenVideoMixProjectorResponse.class, Assertions::assertNull);
  }

  @Test
  void openSourceProjectorResponse() {
    assertResponse(TYPE, OpenVideoMixProjectorResponse.class, Assertions::assertNull);
  }
}
