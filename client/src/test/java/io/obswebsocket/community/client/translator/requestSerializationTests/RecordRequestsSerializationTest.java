package io.obswebsocket.community.client.translator.requestSerializationTests;

import io.obswebsocket.community.client.message.request.record.GetRecordDirectoryRequest;
import io.obswebsocket.community.client.message.request.record.GetRecordFilenameFormattingRequest;
import io.obswebsocket.community.client.message.request.record.GetRecordStatusRequest;
import io.obswebsocket.community.client.message.request.record.PauseRecordRequest;
import io.obswebsocket.community.client.message.request.record.ResumeRecordRequest;
import io.obswebsocket.community.client.message.request.record.SetRecordDirectoryRequest;
import io.obswebsocket.community.client.message.request.record.SetRecordFilenameFormattingRequest;
import io.obswebsocket.community.client.message.request.record.StartRecordRequest;
import io.obswebsocket.community.client.message.request.record.StopRecordRequest;
import io.obswebsocket.community.client.message.request.record.ToggleRecordPauseRequest;
import io.obswebsocket.community.client.message.request.record.ToggleRecordRequest;
import io.obswebsocket.community.client.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class RecordRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void getRecordStatusRequest() {
    GetRecordStatusRequest getRecordStatusRequest = GetRecordStatusRequest.builder()
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'requestType': 'GetRecordStatus',\n" +
        "\t'requestId': '" + getRecordStatusRequest.getRequestId() + "'\n" +
        "}";

    assertSerializationAndDeserialization(json, getRecordStatusRequest);
  }

  @Test
  void toggleRecordRequest() {
    ToggleRecordRequest toggleRecordRequest = ToggleRecordRequest.builder()
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'requestType': 'ToggleRecord',\n" +
        "\t'requestId': '" + toggleRecordRequest.getRequestId() + "'\n" +
        "}";

    assertSerializationAndDeserialization(json, toggleRecordRequest);
  }

  @Test
  void startRecordRequest() {
    StartRecordRequest startRecordRequest = StartRecordRequest.builder()
        .waitForResult(true)
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'requestType': 'StartRecord',\n" +
        "\t'requestId': '" + startRecordRequest.getRequestId() + "',\n" +
        "\t'requestData': {\n" +
        "\t\t'waitForResult': true\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, startRecordRequest);
  }

  @Test
  void stopRecordRequest() {
    StopRecordRequest stopRecordRequest = StopRecordRequest.builder()
        .waitForResult(false)
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'requestType': 'StopRecord',\n" +
        "\t'requestId': '" + stopRecordRequest.getRequestId() + "',\n" +
        "\t'requestData': {\n" +
        "\t\t'waitForResult': false\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, stopRecordRequest);
  }

  @Test
  void toggleRecordPauseRequest() {
    ToggleRecordPauseRequest toggleRecordPauseRequest = ToggleRecordPauseRequest.builder()
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'requestType': 'ToggleRecordPause',\n" +
        "\t'requestId': '" + toggleRecordPauseRequest.getRequestId() + "'\n" +
        "}";

    assertSerializationAndDeserialization(json, toggleRecordPauseRequest);
  }

  @Test
  void pauseRecordRequest() {
    PauseRecordRequest pauseRecordRequest = PauseRecordRequest.builder()
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'requestType': 'PauseRecord',\n" +
        "\t'requestId': '" + pauseRecordRequest.getRequestId() + "'\n" +
        "}";

    assertSerializationAndDeserialization(json, pauseRecordRequest);
  }

  @Test
  void resumeRecordRequest() {
    ResumeRecordRequest resumeRecordRequest = ResumeRecordRequest.builder()
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'requestType': 'ResumeRecord',\n" +
        "\t'requestId': '" + resumeRecordRequest.getRequestId() + "'\n" +
        "}";

    assertSerializationAndDeserialization(json, resumeRecordRequest);
  }

  @Test
  void getRecordDirectoryRequest() {
    GetRecordDirectoryRequest getRecordDirectoryRequest = GetRecordDirectoryRequest.builder()
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'requestType': 'GetRecordDirectory',\n" +
        "\t'requestId': '" + getRecordDirectoryRequest.getRequestId() + "'\n" +
        "}";

    assertSerializationAndDeserialization(json, getRecordDirectoryRequest);
  }

  @Test
  void setRecordDirectoryRequest() {
    SetRecordDirectoryRequest getRecordDirectoryRequest = SetRecordDirectoryRequest.builder()
        .recordDirectory("./")
        .createIfNotExist(true)
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'requestType': 'SetRecordDirectory',\n" +
        "\t'requestId': '" + getRecordDirectoryRequest.getRequestId() + "',\n" +
        "\t'requestData': {\n" +
        "\t\t'recordDirectory': './',\n" +
        "\t\t'createIfNotExist': true\n" +
        "\t}\n" +
        "}";

    System.out.println(json);

    assertSerializationAndDeserialization(json, getRecordDirectoryRequest);
  }

  @Test
  void getRecordFilenameFormattingRequest() {
    GetRecordFilenameFormattingRequest getRecordFilenameFormattingRequest = GetRecordFilenameFormattingRequest
        .builder()
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'requestType': 'GetRecordFilenameFormatting',\n" +
        "\t'requestId': '" + getRecordFilenameFormattingRequest.getRequestId() + "'\n" +
        "}";

    assertSerializationAndDeserialization(json, getRecordFilenameFormattingRequest);
  }

  @Test
  void setRecordFilenameFormattingRequest() {
    SetRecordFilenameFormattingRequest setRecordFilenameFormattingRequest = SetRecordFilenameFormattingRequest
        .builder()
        .filenameFormatting("$1 $2")
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'requestType': 'SetRecordFilenameFormatting',\n" +
        "\t'requestId': '" + setRecordFilenameFormattingRequest.getRequestId() + "',\n" +
        "\t'requestData': {\n" +
        "\t\t'filenameFormatting': '$1 $2'\n" +
        "\t}\n" +
        "}";

    System.out.println(json);

    assertSerializationAndDeserialization(json, setRecordFilenameFormattingRequest);
  }
}
