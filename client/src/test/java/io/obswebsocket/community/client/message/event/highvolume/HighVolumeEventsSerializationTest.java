package io.obswebsocket.community.client.message.event.highvolume;

import io.obswebsocket.community.client.message.event.AbstractEventSerializationTest;
import io.obswebsocket.community.client.message.event.highvolume.InputVolumeMetersEvent.InputLevels;
import org.junit.jupiter.api.Test;

class HighVolumeEventsSerializationTest extends AbstractEventSerializationTest {

  private static final String TYPE = "highvolume";

  @Test
  void inputActiveStateChangedEvent() {
    assertEventType(TYPE, new InputActiveStateChangedEvent(
        InputActiveStateChangedEvent.SpecificData.builder()
            .inputName("SomeName")
            .videoActive(true)
            .build()));
  }

  @Test
  void inputShowStateChangedEvent() {
    assertEventType(TYPE, new InputShowStateChangedEvent(
        InputShowStateChangedEvent.SpecificData.builder()
            .inputName("SomeName")
            .videoShowing(true)
            .build()));
  }

  @Test
  void inputVolumeMetersEvent() {
    InputLevels input1 = new InputLevels();
    input1.setInputName("SomeName");
    input1.setInputKind("SomeKind");
    input1.setUnversionedInputKind("SomeOtherKind");
    input1.setInputVolumeDb(123.4d);
    input1.setInputVolumeMul(432.1d);

    assertEventType(TYPE, new InputVolumeMetersEvent(
        InputVolumeMetersEvent.SpecificData.builder()
            .input(input1)
            .build()));
  }
}
