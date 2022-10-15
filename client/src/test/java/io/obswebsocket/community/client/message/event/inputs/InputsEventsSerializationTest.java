package io.obswebsocket.community.client.message.event.inputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.event.AbstractEventSerializationTest;
import org.junit.jupiter.api.Test;

class InputsEventsSerializationTest extends AbstractEventSerializationTest {

  private static final String TYPE = "inputs";

  @Test
  void inputCreatedEvent() {
    JsonObject inputSettings = new JsonObject();
    inputSettings.addProperty("some", "Settings");

    JsonObject defaultInputSettings = new JsonObject();
    defaultInputSettings.addProperty("some", "DefaultSettings");

    assertEventType(TYPE, new InputCreatedEvent(
        InputCreatedEvent.SpecificData.builder()
            .inputName("SomeName")
            .inputKind("SomeKind")
            .unversionedInputKind("SomeOtherKind")
            .inputSettings(inputSettings)
            .defaultInputSettings(defaultInputSettings)
            .build()));
  }

  @Test
  void inputRemovedEvent() {
    assertEventType(TYPE, new InputRemovedEvent(
        InputRemovedEvent.SpecificData.builder()
            .inputName("SomeName")
            .build()));
  }

  @Test
  void inputNameChangedEvent() {
    assertEventType(TYPE, new InputNameChangedEvent(
        InputNameChangedEvent.SpecificData.builder()
            .inputName("SomeName")
            .oldInputName("SomeOldName")
            .build()));
  }

  @Test
  void inputMuteStateChangedEvent() {
    assertEventType(TYPE, new InputMuteStateChangedEvent(
        InputMuteStateChangedEvent.SpecificData.builder()
            .inputName("SomeName")
            .inputMuted(true)
            .build()));
  }

  @Test
  void inputVolumeChangedEvent() {
    assertEventType(TYPE, new InputVolumeChangedEvent(
        InputVolumeChangedEvent.SpecificData.builder()
            .inputName("SomeName")
            .inputVolumeMul(123.4f)
            .inputVolumeDb(432.1f)
            .build()));
  }

  @Test
  void inputAudioBalanceChangedEvent() {
    assertEventType(TYPE, new InputAudioBalanceChangedEvent(
        InputAudioBalanceChangedEvent.SpecificData.builder()
            .inputName("SomeName")
            .inputAudioBalance(123.4f)
            .build()));
  }

  @Test
  void inputAudioSyncOffsetChangedEvent() {
    assertEventType(TYPE, new InputAudioSyncOffsetChangedEvent(
        InputAudioSyncOffsetChangedEvent.SpecificData.builder()
            .inputName("SomeName")
            .inputAudioSyncOffset(123L)
            .build()));
  }
}
