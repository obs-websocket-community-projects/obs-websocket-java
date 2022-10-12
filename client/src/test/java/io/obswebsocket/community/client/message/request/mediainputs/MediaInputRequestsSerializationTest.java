package io.obswebsocket.community.client.message.request.mediainputs;

import org.junit.jupiter.api.Test;

import io.obswebsocket.community.client.message.AbstractSerializationTest;

public class MediaInputRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void getMediaInputStatusRequest() {
    GetMediaInputStatusRequest getMediaInputStatusRequest = GetMediaInputStatusRequest.builder()
                                                                                      .inputName("Media Input")
                                                                                      .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'inputName': 'Media Input'\n" +
            "\t},\n" +
            "\t'requestType': 'GetMediaInputStatus',\n" +
            "\t'requestId': " + getMediaInputStatusRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, getMediaInputStatusRequest);
  }

  @Test
  void nextMediaInputPlaylistItemRequest() {
    NextMediaInputPlaylistItemRequest nextMediaInputPlaylistItemRequest = NextMediaInputPlaylistItemRequest
            .builder()
            .inputName("Media Input")
            .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'inputName': 'Media Input'\n" +
            "\t},\n" +
            "\t'requestType': 'NextMediaInputPlaylistItem',\n" +
            "\t'requestId': " + nextMediaInputPlaylistItemRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, nextMediaInputPlaylistItemRequest);
  }

  @Test
  void previousMediaInputPlaylistItemRequest() {
    PreviousMediaInputPlaylistItemRequest previousMediaInputPlaylistItemRequest = PreviousMediaInputPlaylistItemRequest
            .builder()
            .inputName("Media Input")
            .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'inputName': 'Media Input'\n" +
            "\t},\n" +
            "\t'requestType': 'PreviousMediaInputPlaylistItem',\n" +
            "\t'requestId': " + previousMediaInputPlaylistItemRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, previousMediaInputPlaylistItemRequest);
  }

  @Test
  void stopMediaInputRequest() {
    StopMediaInputRequest stopMediaInputRequest = StopMediaInputRequest.builder()
                                                                       .inputName("Media Input")
                                                                       .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'inputName': 'Media Input'\n" +
            "\t},\n" +
            "\t'requestType': 'StopMediaInput',\n" +
            "\t'requestId': " + stopMediaInputRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, stopMediaInputRequest);
  }

  @Test
  void offsetMediaInputTimecodeRequest() {
    OffsetMediaInputTimecodeRequest offsetMediaInputTimecodeRequest = OffsetMediaInputTimecodeRequest
            .builder()
            .inputName("Media Input")
            .timestampOffset(98329L)
            .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'timestampOffset': 98329,\n" +
            "\t\t'inputName': 'Media Input'\n" +
            "\t},\n" +
            "\t'requestType': 'OffsetMediaInputTimecode',\n" +
            "\t'requestId': " + offsetMediaInputTimecodeRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, offsetMediaInputTimecodeRequest);
  }

  @Test
  void setMediaInputTimecodeRequest() {
    SetMediaInputTimecodeRequest setMediaInputTimecodeRequest = SetMediaInputTimecodeRequest
            .builder()
            .inputName("Media Input")
            .mediaTimestamp(988975L)
            .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'mediaTimestamp': 988975,\n" +
            "\t\t'inputName': 'Media Input'\n" +
            "\t},\n" +
            "\t'requestType': 'SetMediaInputTimecode',\n" +
            "\t'requestId': " + setMediaInputTimecodeRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, setMediaInputTimecodeRequest);
  }

  @Test
  void setMediaInputPauseStateRequest() {
    SetMediaInputPauseStateRequest setMediaInputPauseStateRequest = SetMediaInputPauseStateRequest
            .builder()
            .inputName("Media Input")
            .pause(false)
            .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'pause': false,\n" +
            "\t\t'inputName': 'Media Input'\n" +
            "\t},\n" +
            "\t'requestType': 'SetMediaInputPauseState',\n" +
            "\t'requestId': " + setMediaInputPauseStateRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, setMediaInputPauseStateRequest);
  }
}
