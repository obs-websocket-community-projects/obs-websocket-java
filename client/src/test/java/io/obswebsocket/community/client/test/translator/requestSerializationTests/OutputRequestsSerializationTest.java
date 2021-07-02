package io.obswebsocket.community.client.test.translator.requestSerializationTests;

import io.obswebsocket.community.client.message.request.outputs.GetLastReplayBufferReplayRequest;
import io.obswebsocket.community.client.message.request.outputs.GetOutputListRequest;
import io.obswebsocket.community.client.message.request.outputs.GetReplayBufferStatusRequest;
import io.obswebsocket.community.client.message.request.outputs.SaveReplayBufferRequest;
import io.obswebsocket.community.client.message.request.outputs.StartOutputRequest;
import io.obswebsocket.community.client.message.request.outputs.StopOutputRequest;
import io.obswebsocket.community.client.message.request.outputs.StopReplayBufferRequest;
import io.obswebsocket.community.client.message.request.outputs.ToggleOutputRequest;
import io.obswebsocket.community.client.message.request.outputs.ToggleReplayBufferRequest;
import io.obswebsocket.community.client.test.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class OutputRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void getLastReplayBufferReplayRequest() {
    GetLastReplayBufferReplayRequest getLastReplayBufferReplayRequest = GetLastReplayBufferReplayRequest
        .builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"GetLastReplayBufferReplay\",\n" +
        "\t\"requestId\": " + getLastReplayBufferReplayRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getLastReplayBufferReplayRequest);
  }

  @Test
  void getOutputListRequest() {
    GetOutputListRequest getOutputListRequest = GetOutputListRequest.builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"GetOutputList\",\n" +
        "\t\"requestId\": " + getOutputListRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getOutputListRequest);
  }

  @Test
  void getReplayBufferStatusRequest() {
    GetReplayBufferStatusRequest getReplayBufferStatusRequest = GetReplayBufferStatusRequest
        .builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"GetReplayBufferStatus\",\n" +
        "\t\"requestId\": " + getReplayBufferStatusRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getReplayBufferStatusRequest);
  }

  @Test
  void saveReplayBufferRequest() {
    SaveReplayBufferRequest saveReplayBufferRequest = SaveReplayBufferRequest.builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"SaveReplayBuffer\",\n" +
        "\t\"requestId\": " + saveReplayBufferRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, saveReplayBufferRequest);
  }

  @Test
  void stopReplayBufferRequest() {
    StopReplayBufferRequest stopReplayBufferRequest = StopReplayBufferRequest.builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"StopReplayBuffer\",\n" +
        "\t\"requestId\": " + stopReplayBufferRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, stopReplayBufferRequest);
  }

  @Test
  void toggleReplayBufferRequest() {
    ToggleReplayBufferRequest toggleReplayBufferRequest = ToggleReplayBufferRequest.builder()
        .build();

    String json = "{\n" +
        "\t\"requestType\": \"ToggleReplayBuffer\",\n" +
        "\t\"requestId\": " + toggleReplayBufferRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, toggleReplayBufferRequest);
  }

  @Test
  void startOutputRequest() {
    StartOutputRequest startOutputRequest = StartOutputRequest.builder()
        .outputName("Output")
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"outputName\": \"Output\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"StartOutput\",\n" +
        "\t\"requestId\": " + startOutputRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, startOutputRequest);
  }

  @Test
  void stopOutputRequest() {
    StopOutputRequest stopOutputRequest = StopOutputRequest.builder()
        .outputName("Output")
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"outputName\": \"Output\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"StopOutput\",\n" +
        "\t\"requestId\": " + stopOutputRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, stopOutputRequest);
  }

  @Test
  void toggleOutputRequest() {
    ToggleOutputRequest toggleOutputRequest = ToggleOutputRequest.builder()
        .outputName("Output")
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"outputName\": \"Output\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"ToggleOutput\",\n" +
        "\t\"requestId\": " + toggleOutputRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, toggleOutputRequest);
  }
}
