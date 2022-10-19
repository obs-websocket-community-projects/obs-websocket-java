package io.obswebsocket.community.client.message.request.filters;

import com.google.gson.JsonObject;
import com.google.gson.internal.LazilyParsedNumber;
import io.obswebsocket.community.client.message.request.AbstractRequestSerializationTest;
import org.junit.jupiter.api.Test;

public class FiltersRequestsSerializationTest extends AbstractRequestSerializationTest {

  private static final String TYPE = "filters";

  @Test
  void getSourceFilterListRequest() {
    GetSourceFilterListRequest getSourceFilterListRequest = GetSourceFilterListRequest.builder()
        .sourceName("Source name")
        .build();

    assertRequest(TYPE, getSourceFilterListRequest);
  }

  @Test
  void getSourceFilterDefaultSettingsRequest() {
    GetSourceFilterDefaultSettingsRequest getSourceFilterDefaultSettingsRequest = GetSourceFilterDefaultSettingsRequest.builder()
        .filterKind("Filter Kind")
        .build();

    assertRequest(TYPE, getSourceFilterDefaultSettingsRequest);
  }

  @Test
  void createSourceFilterRequest() {
    JsonObject filterSettings = new JsonObject();
    filterSettings.addProperty("randomStringSetting", "randomString");
    filterSettings.addProperty("randomBooleanSetting", false);
    filterSettings.addProperty("randomIntegerSetting", new LazilyParsedNumber("113"));

    CreateSourceFilterRequest createSourceFilterRequest = CreateSourceFilterRequest.builder()
        .sourceName("Source name")
        .filterName("Filter Name")
        .filterIndex(3)
        .filterKind("Filter kind")
        .filterSettings(filterSettings)
        .build();

    assertRequest(TYPE, createSourceFilterRequest);
  }

  @Test
  void removeSourceFilterRequest() {
    RemoveSourceFilterRequest removeSourceFilterRequest = RemoveSourceFilterRequest.builder()
        .sourceName("Source name")
        .filterName("Filter name")
        .build();

    assertRequest(TYPE, removeSourceFilterRequest);
  }

  @Test
  void setSourceFilterNameRequest() {
    SetSourceFilterNameRequest setSourceFilterNameRequest = SetSourceFilterNameRequest.builder()
        .sourceName("Source Name")
        .filterName("Filter Name")
        .newFilterName("New Filter Name")
        .build();

    assertRequest(TYPE, setSourceFilterNameRequest);
  }

  @Test
  void getSourceFilterRequest() {
    GetSourceFilterRequest getSourceFilterRequest = GetSourceFilterRequest.builder()
        .sourceName("Source name")
        .filterName("Filter Name")
        .build();

    assertRequest(TYPE, getSourceFilterRequest);
  }

  @Test
  void setSourceFilterIndexRequest() {
    SetSourceFilterIndexRequest setSourceFilterIndexRequest = SetSourceFilterIndexRequest.builder()
        .sourceName("Source Name")
        .filterName("Filter Name")
        .filterIndex(3)
        .build();

    assertRequest(TYPE, setSourceFilterIndexRequest);
  }

  @Test
  void setSourceFilterSettingsRequest() {
    JsonObject filterSettings = new JsonObject();
    filterSettings.addProperty("randomStringSetting", "randomString");
    filterSettings.addProperty("randomBooleanSetting", false);
    filterSettings.addProperty("randomIntegerSetting", new LazilyParsedNumber("1"));

    SetSourceFilterSettingsRequest setSourceFilterSettingsRequest = SetSourceFilterSettingsRequest
        .builder()
        .sourceName("Source name")
        .filterName("Filter name")
        .filterSettings(filterSettings)
        .build();

    assertRequest(TYPE, setSourceFilterSettingsRequest);
  }

  @Test
  void setSourceFilterEnabledRequest() {
    SetSourceFilterEnabledRequest setSourceFilterEnabledRequest = SetSourceFilterEnabledRequest
        .builder()
        .sourceName("Source name")
        .filterName("Filter name")
        .filterEnabled(false)
        .build();

    assertRequest(TYPE, setSourceFilterEnabledRequest);
  }
}
