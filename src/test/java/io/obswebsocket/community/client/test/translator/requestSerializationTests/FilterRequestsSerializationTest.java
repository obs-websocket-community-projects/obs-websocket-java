package io.obswebsocket.community.client.test.translator.requestSerializationTests;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.Message;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.config.CreateSceneCollectionRequest;
import io.obswebsocket.community.client.message.request.filters.CreateSourceFilterRequest;
import io.obswebsocket.community.client.message.request.filters.GetSourceFilterRequest;
import io.obswebsocket.community.client.test.translator.AbstractSerializationTest;
import io.obswebsocket.community.client.translator.GsonMessageTranslator;
import io.obswebsocket.community.client.translator.MessageTranslator;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

public class FilterRequestsSerializationTest extends AbstractSerializationTest {
    @Test
    void createInputRequest() {
        JsonObject filterSettings = new JsonObject();
        filterSettings.addProperty("randomStringSetting", "randomString");
        filterSettings.addProperty("randomBooleanSetting", false);
        filterSettings.addProperty("randomIntegerSetting", 113);

        CreateSourceFilterRequest createSourceFilterRequest = CreateSourceFilterRequest.builder()
                .sourceName("Source name")
                .filterName("Filter Name")
                .filterEnabled(false)
                .filterIndex(3)
                .filterKind("Filter kind")
                .filterSettings(filterSettings)
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"filterName\": \"Filter Name\",\n" +
                "\t\t\"filterEnabled\": false,\n" +
                "\t\t\"filterIndex\": 3,\n" +
                "\t\t\"filterKind\": \"Filter kind\",\n" +
                "\t\t\"filterSettings\": {\n" +
                "\t\t\t\"randomStringSetting\": \"randomString\",\n" +
                "\t\t\t\"randomBooleanSetting\": false,\n" +
                "\t\t\t\"randomIntegerSetting\": 113\n" +
                "\t\t},\n" +
                "\t\t\"sourceName\": \"Source name\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"CreateSourceFilter\",\n" +
                "\t\"requestId\": " + createSourceFilterRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        MessageTranslator translator = new GsonMessageTranslator();

        CreateSourceFilterRequest actualObject = translator.fromJson(json, CreateSourceFilterRequest.class);

        assertThat(actualObject.getRequestData().getSourceName()).isEqualTo(createSourceFilterRequest.getRequestData().getSourceName());
        assertThat(actualObject.getRequestData().getFilterName()).isEqualTo(createSourceFilterRequest.getRequestData().getFilterName());
        assertThat(actualObject.getRequestData().getFilterIndex()).isEqualTo(createSourceFilterRequest.getRequestData().getFilterIndex());
        assertThat(actualObject.getRequestData().getFilterKind()).isEqualTo(createSourceFilterRequest.getRequestData().getFilterKind());
        assertThat(actualObject.getRequestData().getFilterSettings().get("randomStringSetting").getAsString()).isEqualTo(createSourceFilterRequest.getRequestData().getFilterSettings().get("randomStringSetting").getAsString());
        assertThat(actualObject.getRequestData().getFilterSettings().get("randomBooleanSetting").getAsBoolean()).isEqualTo(createSourceFilterRequest.getRequestData().getFilterSettings().get("randomBooleanSetting").getAsBoolean());
        assertThat(actualObject.getRequestData().getFilterSettings().get("randomIntegerSetting").getAsInt()).isEqualTo(createSourceFilterRequest.getRequestData().getFilterSettings().get("randomIntegerSetting").getAsInt());
        assertThat(actualObject.getRequestId()).isEqualTo(createSourceFilterRequest.getRequestId());
        assertThat(actualObject.getRequestType()).isEqualTo(Request.Type.CreateSourceFilter);
        assertThat(actualObject.getMessageType()).isEqualTo(Message.Type.Request);
        try {
            String actualJson = translator.toJson(createSourceFilterRequest);
            System.out.println("Serialized to: " + actualJson);
            JSONAssert.assertEquals(json, actualJson, false);
        } catch (JSONException e) {
            fail("Could not assert against JSON", e);
        }
    }

    @Test
    void createSceneCollectionRequest() {
        GetSourceFilterRequest getSourceFilterRequest = GetSourceFilterRequest.builder()
                .sourceName("Source name")
                .filterName("Filter Name")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"filterName\": \"Filter Name\",\n" +
                "\t\t\"sourceName\": \"Source name\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"GetSourceFilter\",\n" +
                "\t\"requestId\": " + getSourceFilterRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getSourceFilterRequest);
    }
}
