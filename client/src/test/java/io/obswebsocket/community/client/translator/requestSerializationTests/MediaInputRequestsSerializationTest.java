package io.obswebsocket.community.client.translator.requestSerializationTests;

import io.obswebsocket.community.client.message.request.mediainputs.GetMediaInputStatusRequest;
import io.obswebsocket.community.client.message.request.mediainputs.NextMediaInputPlaylistItemRequest;
import io.obswebsocket.community.client.message.request.mediainputs.OffsetMediaInputTimecodeRequest;
import io.obswebsocket.community.client.message.request.mediainputs.PreviousMediaInputPlaylistItemRequest;
import io.obswebsocket.community.client.message.request.mediainputs.SetMediaInputPauseStateRequest;
import io.obswebsocket.community.client.message.request.mediainputs.SetMediaInputTimecodeRequest;
import io.obswebsocket.community.client.message.request.mediainputs.StopMediaInputRequest;
import io.obswebsocket.community.client.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class MediaInputRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void getMediaInputStatusRequest() {
    GetMediaInputStatusRequest getMediaInputStatusRequest = GetMediaInputStatusRequest.builder()
        .inputName("Media Input")
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"inputName\": \"Media Input\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"GetMediaInputStatus\",\n" +
        "\t\"requestId\": " + getMediaInputStatusRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getMediaInputStatusRequest);
  }

  @Test
  void nextMediaInputPlaylistItemRequest() {
    NextMediaInputPlaylistItemRequest nextMediaInputPlaylistItemRequest = NextMediaInputPlaylistItemRequest
        .builder()
        .inputName("Media Input")
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"inputName\": \"Media Input\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"NextMediaInputPlaylistItem\",\n" +
        "\t\"requestId\": " + nextMediaInputPlaylistItemRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, nextMediaInputPlaylistItemRequest);
  }

  @Test
  void previousMediaInputPlaylistItemRequest() {
    PreviousMediaInputPlaylistItemRequest previousMediaInputPlaylistItemRequest = PreviousMediaInputPlaylistItemRequest
        .builder()
        .inputName("Media Input")
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"inputName\": \"Media Input\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"PreviousMediaInputPlaylistItem\",\n" +
        "\t\"requestId\": " + previousMediaInputPlaylistItemRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, previousMediaInputPlaylistItemRequest);
  }

  @Test
  void stopMediaInputRequest() {
    StopMediaInputRequest stopMediaInputRequest = StopMediaInputRequest.builder()
        .inputName("Media Input")
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"inputName\": \"Media Input\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"StopMediaInput\",\n" +
        "\t\"requestId\": " + stopMediaInputRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
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

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"timestampOffset\": 98329,\n" +
        "\t\t\"inputName\": \"Media Input\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"OffsetMediaInputTimecode\",\n" +
        "\t\"requestId\": " + offsetMediaInputTimecodeRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
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

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"mediaTimestamp\": 988975,\n" +
        "\t\t\"inputName\": \"Media Input\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"SetMediaInputTimecode\",\n" +
        "\t\"requestId\": " + setMediaInputTimecodeRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
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

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"pause\": false,\n" +
        "\t\t\"inputName\": \"Media Input\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"SetMediaInputPauseState\",\n" +
        "\t\"requestId\": " + setMediaInputPauseStateRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, setMediaInputPauseStateRequest);
  }
}
