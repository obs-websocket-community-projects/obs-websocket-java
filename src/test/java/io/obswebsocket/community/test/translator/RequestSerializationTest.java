package io.obswebsocket.community.test.translator;

import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.request.RequestBatch;
import io.obswebsocket.community.message.request.config.CreateSceneCollectionRequest;
import io.obswebsocket.community.message.request.config.GetProfileListRequest;
import io.obswebsocket.community.message.request.general.*;
import io.obswebsocket.community.message.request.transitions.GetCurrentTransitionRequest;
import io.obswebsocket.community.model.Projector;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestSerializationTest extends AbstractSerializationTest {
    @Test
    void notOrUnknownRequest() {
        assertThat(deserializeTo("[]", Request.class)).isNull();
        assertThat(deserializeTo("{}", Request.class)).isNull();
        assertThat(deserializeTo("{'messageType':'Request'}", Request.class)).isNull();
        assertThat(deserializeTo("{'messageType':'Request', 'requestType':'SomethingGibberish'}", Request.class)).isNull();
    }

    @Test
    void sleepRequest() {
        SleepRequest sleepRequest1000 = SleepRequest.builder().sleepMillis(1000L).build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"sleepMillis\": 1000\n" +
                "\t},\n" +
                "\t\"requestType\": \"Sleep\",\n" +
                "\t\"requestId\": " + sleepRequest1000.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        Request request = deserializeTo(json, Request.class);
        assertThat(request).isNotNull();
        assertThat(request.getRequestType()).isEqualTo(Request.Type.Sleep);
    }

    @Test
    void requestBatch() {
        SleepRequest sleepRequest1000 = SleepRequest.builder().sleepMillis(1000L).build();
        SleepRequest sleepRequest2000 = SleepRequest.builder().sleepMillis(2000L).build();
        RequestBatch requestBatch = RequestBatch.builder().haltOnFailure(false).requests(Arrays.asList(sleepRequest1000, sleepRequest2000)).build();

        String json = "{\n" +
                "  \"requestId\": " + requestBatch.getRequestId() + ",\n" +
                "  \"haltOnFailure\": false,\n" +
                "  \"requests\": [\n" +
                "    {\n" +
                "      \"requestData\": {\n" +
                "        \"sleepMillis\": 1000\n" +
                "      },\n" +
                "      \"requestType\": \"Sleep\",\n" +
                "      \"requestId\": " + sleepRequest1000.getRequestId() + ",\n" +
                "      \"messageType\": \"Request\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"requestData\": {\n" +
                "        \"sleepMillis\": 2000\n" +
                "      },\n" +
                "      \"requestType\": \"Sleep\",\n" +
                "      \"requestId\": " + sleepRequest2000.getRequestId() + ",\n" +
                "      \"messageType\": \"Request\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"messageType\": \"RequestBatch\"\n" +
                "}";

        assertSerializationAndDeserialization(json, requestBatch);
    }

    @Test
    void getCurrentTransitionRequest() {
        GetCurrentTransitionRequest getCurrentTransitionRequest = GetCurrentTransitionRequest.builder().build();

        String json = "{\n" +
                "\t\"requestType\": \"GetCurrentTransition\",\n" +
                "\t\"requestId\": " + getCurrentTransitionRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getCurrentTransitionRequest);
    }

    @Test
    void getHotkeyListRequest() {
        GetHotkeyListRequest getHotkeyListRequest = GetHotkeyListRequest.builder().build();

        String json = "{\n" +
                "\t\"requestType\": \"GetHotkeyList\",\n" +
                "\t\"requestId\": " + getHotkeyListRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getHotkeyListRequest);
    }

    @Test
    void getStudioModeEnabledRequest() {
        GetStudioModeEnabledRequest getStudioModeEnabledRequest = GetStudioModeEnabledRequest.builder().build();

        String json = "{\n" +
                "\t\"requestType\": \"GetStudioModeEnabled\",\n" +
                "\t\"requestId\": " + getStudioModeEnabledRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}\n";

        assertSerializationAndDeserialization(json, getStudioModeEnabledRequest);
    }

    @Test
    void openProjectorRequest() {
        OpenProjectorRequest openProjectorRequest = OpenProjectorRequest.builder()
                .projectorType(Projector.Type.MULTIVIEW)
                .projectorGeometry("GeometryString")
                .projectorMonitor(1)
                .sourceName("Source String name")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"projectorType\": \"MULTIVIEW\",\n" +
                "\t\t\"projectorMonitor\": 1,\n" +
                "\t\t\"projectorGeometry\": \"GeometryString\",\n" +
                "\t\t\"sourceName\": \"Source String name\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"OpenProjector\",\n" +
                "\t\"requestId\": " + openProjectorRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, openProjectorRequest);
    }

    @Test
    void setStudioModeEnabledRequest() {
        SetStudioModeEnabledRequest setStudioModeEnabledRequest = SetStudioModeEnabledRequest.builder().studioModeEnabled(false).build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"studioModeEnabled\": false\n" +
                "\t},\n" +
                "\t\"requestType\": \"SetStudioModeEnabled\",\n" +
                "\t\"requestId\": " + setStudioModeEnabledRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, setStudioModeEnabledRequest);
    }

    @Test
    void triggerHotkeyByNameRequest() {
        TriggerHotkeyByNameRequest triggerHotkeyByNameRequest = TriggerHotkeyByNameRequest.builder().hotkeyName("Hotkey").build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"hotkeyName\": \"Hotkey\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"TriggerHotkeyByName\",\n" +
                "\t\"requestId\": " + triggerHotkeyByNameRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, triggerHotkeyByNameRequest);
    }

    @Test
    void triggerHotkeyByKeySequenceRequest() {
        TriggerHotkeyByKeySequenceRequest triggerHotkeyByKeySequenceRequest = TriggerHotkeyByKeySequenceRequest.builder()
                .keyId("KeyId1")
                .keyModifiers(TriggerHotkeyByKeySequenceRequest.KeyModifiers.builder()
                        .alt(true)
                        .shift(true)
                        .build()
                ).build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"keyId\": \"KeyId1\",\n" +
                "\t\t\"keyModifiers\": {\n" +
                "\t\t\t\"shift\": true,\n" +
                "\t\t\t\"alt\": true,\n" +
                "\t\t\t\"control\": false,\n" +
                "\t\t\t\"command\": false\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"requestType\": \"TriggerHotkeyByName\",\n" +
                "\t\"requestId\": " + triggerHotkeyByKeySequenceRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, triggerHotkeyByKeySequenceRequest);
    }

    @Test
    void createSceneCollectionRequest() {
        CreateSceneCollectionRequest createSceneCollectionRequest = CreateSceneCollectionRequest.builder().sceneCollectionName("Collection Name").build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"sceneCollectionName\": \"Collection Name\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"SetCurrentSceneCollection\",\n" +
                "\t\"requestId\": " + createSceneCollectionRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, createSceneCollectionRequest);
    }

    @Test
    void getProfileListRequest() {
        GetProfileListRequest getProfileListRequest = GetProfileListRequest.builder().build();

        String json = "{\n" +
                "\t\"requestType\": \"GetProfileList\",\n" +
                "\t\"requestId\": " + getProfileListRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getProfileListRequest);
    }
}
