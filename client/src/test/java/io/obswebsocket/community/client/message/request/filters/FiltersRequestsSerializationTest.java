package io.obswebsocket.community.client.message.request.filters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import com.google.gson.JsonObject;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import io.obswebsocket.community.client.message.Message.OperationCode;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.translator.GsonMessageTranslator;
import io.obswebsocket.community.client.translator.MessageTranslator;

public class FiltersRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void createSourceFilterRequest() {
    JsonObject filterSettings = new JsonObject();
    filterSettings.addProperty("randomStringSetting", "randomString");
    filterSettings.addProperty("randomBooleanSetting", false);
    filterSettings.addProperty("randomIntegerSetting", 113);

    CreateSourceFilterRequest createSourceFilterRequest = CreateSourceFilterRequest.builder()
                                                                                   .sourceName("Source name")
                                                                                   .filterName("Filter Name")
                                                                                   .filterIndex(3)
                                                                                   .filterKind("Filter kind")
                                                                                   .filterSettings(filterSettings)
                                                                                   .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'filterName': 'Filter Name',\n" +
            "\t\t'filterIndex': 3,\n" +
            "\t\t'filterKind': 'Filter kind',\n" +
            "\t\t'filterSettings': {\n" +
            "\t\t\t'randomStringSetting': 'randomString',\n" +
            "\t\t\t'randomBooleanSetting': false,\n" +
            "\t\t\t'randomIntegerSetting': 113\n" +
            "\t\t},\n" +
            "\t\t'sourceName': 'Source name'\n" +
            "\t},\n" +
            "\t'requestType': 'CreateSourceFilter',\n" +
            "\t'requestId': " + createSourceFilterRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    MessageTranslator translator = new GsonMessageTranslator();

    CreateSourceFilterRequest actualObject = translator
            .fromJson(json, CreateSourceFilterRequest.class);

    assertThat(actualObject.getData().getRequestData().getSourceName())
            .isEqualTo(createSourceFilterRequest.getData().getRequestData().getSourceName());
    assertThat(actualObject.getData().getRequestData().getFilterName())
            .isEqualTo(createSourceFilterRequest.getData().getRequestData().getFilterName());
    assertThat(actualObject.getData().getRequestData().getFilterIndex())
            .isEqualTo(createSourceFilterRequest.getData().getRequestData().getFilterIndex());
    assertThat(actualObject.getData().getRequestData().getFilterKind())
            .isEqualTo(createSourceFilterRequest.getData().getRequestData().getFilterKind());
    assertThat(
            actualObject.getData().getRequestData().getFilterSettings().get("randomStringSetting").getAsString())
            .isEqualTo(createSourceFilterRequest.getData().getRequestData().getFilterSettings()
                                                .get("randomStringSetting").getAsString());
    assertThat(actualObject.getData().getRequestData().getFilterSettings().get("randomBooleanSetting")
                           .getAsBoolean()).isEqualTo(
            createSourceFilterRequest.getData().getRequestData().getFilterSettings().get("randomBooleanSetting")
                                     .getAsBoolean());
    assertThat(
            actualObject.getData().getRequestData().getFilterSettings().get("randomIntegerSetting").getAsInt())
            .isEqualTo(createSourceFilterRequest.getData().getRequestData().getFilterSettings()
                                                .get("randomIntegerSetting").getAsInt());
    assertThat(actualObject.getRequestId()).isEqualTo(createSourceFilterRequest.getRequestId());
    assertThat(actualObject.getRequestType()).isEqualTo(Request.Data.Type.CreateSourceFilter);
    assertThat(actualObject.getOperationCode()).isEqualTo(OperationCode.Request);
    try {
      String actualJson = translator.toJson(createSourceFilterRequest);
      System.out.println("Serialized to: " + actualJson);
      JSONAssert.assertEquals(json, actualJson, false);
    } catch (JSONException e) {
      fail("Could not assert against JSON", e);
    }
  }

  @Test
  void getSourceFilterRequest() {
    GetSourceFilterRequest getSourceFilterRequest = GetSourceFilterRequest.builder()
                                                                          .sourceName("Source name")
                                                                          .filterName("Filter Name")
                                                                          .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'filterName': 'Filter Name',\n" +
            "\t\t'sourceName': 'Source name'\n" +
            "\t},\n" +
            "\t'requestType': 'GetSourceFilter',\n" +
            "\t'requestId': " + getSourceFilterRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, getSourceFilterRequest);
  }

  @Test
  void getSourceFilterListRequest() {
    GetSourceFilterListRequest getSourceFilterListRequest = GetSourceFilterListRequest.builder()
                                                                                      .sourceName("Source name")
                                                                                      .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'sourceName': 'Source name'\n" +
            "\t},\n" +
            "\t'requestType': 'GetSourceFilterList',\n" +
            "\t'requestId': " + getSourceFilterListRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, getSourceFilterListRequest);
  }

  @Test
  void removeSourceFilterRequest() {
    RemoveSourceFilterRequest removeSourceFilterRequest = RemoveSourceFilterRequest.builder()
                                                                                   .sourceName("Source name")
                                                                                   .filterName("Filter name")
                                                                                   .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'filterName': 'Filter name',\n" +
            "\t\t'sourceName': 'Source name'\n" +
            "\t},\n" +
            "\t'requestType': 'RemoveSourceFilter',\n" +
            "\t'requestId': " + removeSourceFilterRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, removeSourceFilterRequest);
  }

  @Test
  void setSourceFilterEnabledRequest() {
    SetSourceFilterEnabledRequest setSourceFilterEnabledRequest = SetSourceFilterEnabledRequest
            .builder()
            .sourceName("Source name")
            .filterName("Filter name")
            .filterEnabled(false)
            .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'filterName': 'Filter name',\n" +
            "\t\t'filterEnabled': false,\n" +
            "\t\t'sourceName': 'Source name'\n" +
            "\t},\n" +
            "\t'requestType': 'SetSourceFilterEnabled',\n" +
            "\t'requestId': " + setSourceFilterEnabledRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, setSourceFilterEnabledRequest);
  }

  @Test
  void setSourceFilterSettingsRequest() {
    JsonObject filterSettings = new JsonObject();
    filterSettings.addProperty("randomStringSetting", "randomString");
    filterSettings.addProperty("randomBooleanSetting", false);
    filterSettings.addProperty("randomIntegerSetting", 1);

    SetSourceFilterSettingsRequest setSourceFilterSettingsRequest = SetSourceFilterSettingsRequest
            .builder()
            .sourceName("Source name")
            .filterName("Filter name")
            .filterSettings(filterSettings)
            .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'filterName': 'Filter name',\n" +
            "\t\t'filterSettings': {\n" +
            "\t\t\t'randomStringSetting': 'randomString',\n" +
            "\t\t\t'randomBooleanSetting': false,\n" +
            "\t\t\t'randomIntegerSetting': 1\n" +
            "\t\t},\n" +
            "\t\t'sourceName': 'Source name'\n" +
            "\t},\n" +
            "\t'requestType': 'SetSourceFilterSettings',\n" +
            "\t'requestId': " + setSourceFilterSettingsRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    MessageTranslator translator = new GsonMessageTranslator();

    SetSourceFilterSettingsRequest actualObject = translator
            .fromJson(json, SetSourceFilterSettingsRequest.class);

    assertThat(actualObject.getData().getRequestData().getSourceName())
            .isEqualTo(setSourceFilterSettingsRequest.getData().getRequestData().getSourceName());
    assertThat(actualObject.getData().getRequestData().getFilterName())
            .isEqualTo(setSourceFilterSettingsRequest.getData().getRequestData().getFilterName());
    assertThat(
            actualObject.getData().getRequestData().getFilterSettings().get("randomStringSetting").getAsString())
            .isEqualTo(setSourceFilterSettingsRequest.getData().getRequestData().getFilterSettings()
                                                     .get("randomStringSetting").getAsString());
    assertThat(actualObject.getData().getRequestData().getFilterSettings().get("randomBooleanSetting")
                           .getAsBoolean()).isEqualTo(
            setSourceFilterSettingsRequest.getData().getRequestData().getFilterSettings()
                                          .get("randomBooleanSetting").getAsBoolean());
    assertThat(
            actualObject.getData().getRequestData().getFilterSettings().get("randomIntegerSetting").getAsInt())
            .isEqualTo(setSourceFilterSettingsRequest.getData().getRequestData().getFilterSettings()
                                                     .get("randomIntegerSetting").getAsInt());
    assertThat(actualObject.getRequestId())
            .isEqualTo(setSourceFilterSettingsRequest.getRequestId());
    assertThat(actualObject.getRequestType()).isEqualTo(Request.Data.Type.SetSourceFilterSettings);
    assertThat(actualObject.getOperationCode()).isEqualTo(OperationCode.Request);
    try {
      String actualJson = translator.toJson(setSourceFilterSettingsRequest);
      System.out.println("Serialized to: " + actualJson);
      JSONAssert.assertEquals(json, actualJson, false);
    } catch (JSONException e) {
      fail("Could not assert against JSON", e);
    }
  }
}
