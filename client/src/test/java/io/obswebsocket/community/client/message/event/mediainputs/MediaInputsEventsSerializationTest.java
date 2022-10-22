package io.obswebsocket.community.client.message.event.mediainputs;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

class MediaInputsEventsSerializationTest extends AbstractSerializationTest {

  @Test
  void mediaInputPlaybackStartedEvent() {
    MediaInputPlaybackStartedEvent mediaInputPlaybackStartedEvent = new MediaInputPlaybackStartedEvent(
        MediaInputPlaybackStartedEvent.SpecificData.builder()
            .inputName("Input Playback Started")
            .build());

    String json = this.readResourceFile("events/mediainputs/MediaInputPlaybackStarted.json");

    assertSerializationAndDeserialization(json, mediaInputPlaybackStartedEvent);
  }

  @Test
  void mediaInputPlaybackEndedEvent() {
    MediaInputPlaybackEndedEvent mediaInputPlaybackEndedEvent = new MediaInputPlaybackEndedEvent(
        MediaInputPlaybackEndedEvent.SpecificData.builder()
            .inputName("Input Playback Ended")
            .build());

    String json = this.readResourceFile("events/mediainputs/MediaInputPlaybackEnded.json");

    assertSerializationAndDeserialization(json, mediaInputPlaybackEndedEvent);
  }

  @Test
  void mediaInputActionTriggeredEvent() {
    MediaInputActionTriggeredEvent studioModeStateChangedEvent = new MediaInputActionTriggeredEvent(
        MediaInputActionTriggeredEvent.SpecificData.builder()
            .inputName("Input Action Triggered")
            .mediaAction("restart")
            .build());

    String json = this.readResourceFile("events/mediainputs/MediaInputActionTriggered.json");

    assertSerializationAndDeserialization(json, studioModeStateChangedEvent);
  }
}
