package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

class OutputsEventsSerializationTest extends AbstractSerializationTest {

  @Test
  void streamStateChangedEvent() {
    StreamStateChangedEvent streamStateChangedEvent = new StreamStateChangedEvent(
        StreamStateChangedEvent.SpecificData.builder()
            .outputActive(true)
            .outputState("streaming")
            .build());

    String json = this.readResourceFile("events/outputs/StreamStateChanged.json");

    assertSerializationAndDeserialization(json, streamStateChangedEvent);
  }

  @Test
  void recordStateChangedEvent() {
    RecordStateChangedEvent recordStateChangedEvent = new RecordStateChangedEvent(
        RecordStateChangedEvent.SpecificData.builder()
            .outputActive(false)
            .outputState("stopped")
            .outputPath("path/to/file.mp4")
            .build());

    String json = this.readResourceFile("events/outputs/RecordStateChanged.json");

    assertSerializationAndDeserialization(json, recordStateChangedEvent);
  }

  @Test
  void replayBufferStateChangedEvent() {
    ReplayBufferStateChangedEvent replayBufferStateChangedEvent = new ReplayBufferStateChangedEvent(
        ReplayBufferStateChangedEvent.SpecificData.builder()
            .outputActive(true)
            .outputState("started")
            .build());

    String json = this.readResourceFile("events/outputs/ReplayBufferStateChanged.json");

    assertSerializationAndDeserialization(json, replayBufferStateChangedEvent);
  }

  @Test
  void virtualcamStateChangedEvent() {
    VirtualcamStateChangedEvent virtualcamStateChangedEvent = new VirtualcamStateChangedEvent(
        VirtualcamStateChangedEvent.SpecificData.builder()
            .outputActive(false)
            .outputState("stopped")
            .build());

    String json = this.readResourceFile("events/outputs/VirtualcamStateChanged.json");

    assertSerializationAndDeserialization(json, virtualcamStateChangedEvent);
  }

  @Test
  void replayBufferSavedEvent() {
    ReplayBufferSavedEvent replayBufferSavedEvent = new ReplayBufferSavedEvent(
        ReplayBufferSavedEvent.SpecificData.builder()
            .savedReplayPath("path/to/replay.mp4")
            .build());

    String json = this.readResourceFile("events/outputs/ReplayBufferSaved.json");

    assertSerializationAndDeserialization(json, replayBufferSavedEvent);
  }
}
