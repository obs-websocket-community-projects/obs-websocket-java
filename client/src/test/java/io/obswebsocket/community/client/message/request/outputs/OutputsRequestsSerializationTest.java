package io.obswebsocket.community.client.message.request.outputs;

import org.junit.jupiter.api.Test;

import io.obswebsocket.community.client.message.AbstractSerializationTest;

public class OutputsRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void getLastReplayBufferReplayRequest() {
    GetLastReplayBufferReplayRequest getLastReplayBufferReplayRequest = GetLastReplayBufferReplayRequest
            .builder().build();

    String json = "{'d': {\n" +
            "\t'requestType': 'GetLastReplayBufferReplay',\n" +
            "\t'requestId': " + getLastReplayBufferReplayRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, getLastReplayBufferReplayRequest);
  }

  @Test
  void getOutputListRequest() {
    GetOutputListRequest getOutputListRequest = GetOutputListRequest.builder().build();

    String json = "{'d': {\n" +
            "\t'requestType': 'GetOutputList',\n" +
            "\t'requestId': " + getOutputListRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, getOutputListRequest);
  }

  @Test
  void getReplayBufferStatusRequest() {
    GetReplayBufferStatusRequest getReplayBufferStatusRequest = GetReplayBufferStatusRequest
            .builder().build();

    String json = "{'d': {\n" +
            "\t'requestType': 'GetReplayBufferStatus',\n" +
            "\t'requestId': " + getReplayBufferStatusRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, getReplayBufferStatusRequest);
  }

  @Test
  void saveReplayBufferRequest() {
    SaveReplayBufferRequest saveReplayBufferRequest = SaveReplayBufferRequest.builder().build();

    String json = "{'d': {\n" +
            "\t'requestType': 'SaveReplayBuffer',\n" +
            "\t'requestId': " + saveReplayBufferRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, saveReplayBufferRequest);
  }

  @Test
  void stopReplayBufferRequest() {
    StopReplayBufferRequest stopReplayBufferRequest = StopReplayBufferRequest.builder().build();

    String json = "{'d': {\n" +
            "\t'requestType': 'StopReplayBuffer',\n" +
            "\t'requestId': " + stopReplayBufferRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, stopReplayBufferRequest);
  }

  @Test
  void toggleReplayBufferRequest() {
    ToggleReplayBufferRequest toggleReplayBufferRequest = ToggleReplayBufferRequest.builder()
                                                                                   .build();

    String json = "{'d': {\n" +
            "\t'requestType': 'ToggleReplayBuffer',\n" +
            "\t'requestId': " + toggleReplayBufferRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, toggleReplayBufferRequest);
  }

  @Test
  void startOutputRequest() {
    StartOutputRequest startOutputRequest = StartOutputRequest.builder()
                                                              .outputName("Output")
                                                              .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'outputName': 'Output'\n" +
            "\t},\n" +
            "\t'requestType': 'StartOutput',\n" +
            "\t'requestId': " + startOutputRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, startOutputRequest);
  }

  @Test
  void stopOutputRequest() {
    StopOutputRequest stopOutputRequest = StopOutputRequest.builder()
                                                           .outputName("Output")
                                                           .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'outputName': 'Output'\n" +
            "\t},\n" +
            "\t'requestType': 'StopOutput',\n" +
            "\t'requestId': " + stopOutputRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, stopOutputRequest);
  }

  @Test
  void toggleOutputRequest() {
    ToggleOutputRequest toggleOutputRequest = ToggleOutputRequest.builder()
                                                                 .outputName("Output")
                                                                 .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'outputName': 'Output'\n" +
            "\t},\n" +
            "\t'requestType': 'ToggleOutput',\n" +
            "\t'requestId': " + toggleOutputRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, toggleOutputRequest);
  }
}
