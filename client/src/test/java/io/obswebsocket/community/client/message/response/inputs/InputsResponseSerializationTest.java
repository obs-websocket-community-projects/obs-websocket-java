package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.AbstractResponseSerializationTest;
import io.obswebsocket.community.client.model.Input.MonitorType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputsResponseSerializationTest extends AbstractResponseSerializationTest {

  public static final String TYPE = "inputs";

  @Test
  void getInputListResponse() {
    assertResponse(TYPE, GetInputListResponse.class, d -> {
      Assertions.assertEquals(2, d.getInputs().size());
      Assertions.assertEquals("Unversioned Input Kind", d.getInputs().get(1).getUnversionedInputKind());
    });
  }

  @Test
  void getInputKindListResponse() {
    assertResponse(TYPE, GetInputKindListResponse.class, d -> {
      Assertions.assertEquals(2, d.getInputKinds().size());
    });
  }

  @Test
  void getSpecialInputsResponse() {
    assertResponse(TYPE, GetSpecialInputsResponse.class, d -> {
      Assertions.assertEquals("Desktop 1", d.getDesktop1());
      Assertions.assertEquals("Desktop 2", d.getDesktop2());
      Assertions.assertEquals("Mic 1", d.getMic1());
      Assertions.assertEquals("Mic 2", d.getMic2());
      Assertions.assertEquals("Mic 3", d.getMic3());
      Assertions.assertEquals("Mic 4", d.getMic4());
    });
  }

  @Test
  void createInputResponse() {
    assertResponse(TYPE, CreateInputResponse.class, d -> {
      Assertions.assertEquals(42, d.getSceneItemId());
    });
  }

  @Test
  void removeInputResponse() {
    assertResponse(TYPE, RemoveInputResponse.class, null);
  }

  @Test
  void setInputNameResponse() {
    assertResponse(TYPE, SetInputNameResponse.class, null);
  }

  @Test
  void getInputDefaultSettingsResponse() {
    assertResponse(TYPE, GetInputDefaultSettingsResponse.class, d -> {
      Assertions.assertEquals(3, d.getDefaultInputSettings().size());
    });
  }

  @Test
  void getInputSettingsResponse() {
    assertResponse(TYPE, GetInputSettingsResponse.class, d -> {
      Assertions.assertEquals(3, d.getInputSettings().size());
      Assertions.assertEquals("Input Kind", d.getInputKind());
    });
  }

  @Test
  void setInputSettingsResponse() {
    assertResponse(TYPE, SetInputSettingsResponse.class, null);
  }

  @Test
  void getInputMuteResponse() {
    assertResponse(TYPE, GetInputMuteResponse.class, d -> {
      Assertions.assertTrue(d.getInputMuted());
    });
  }

  @Test
  void setInputMuteResponse() {
    assertResponse(TYPE, SetInputMuteResponse.class, null);
  }

  @Test
  void toggleInputMuteResponse() {
    assertResponse(TYPE, ToggleInputMuteResponse.class, d -> {
    Assertions.assertTrue(d.getInputMuted());
    });
  }

  @Test
  void getInputVolumeResponse() {
    assertResponse(TYPE, GetInputVolumeResponse.class, d -> {
      Assertions.assertEquals(2, d.getInputVolumeMul());
      Assertions.assertEquals(12, d.getInputVolumeDb());
    });
  }

  @Test
  void setInputVolumeResponse() {
    assertResponse(TYPE, SetInputVolumeResponse.class, null);
  }

  @Test
  void getInputAudioBalanceResponse() {
    assertResponse(TYPE, GetInputAudioBalanceResponse.class, d -> {
      Assertions.assertEquals(0.5f, d.getInputAudioBalance());
    });
  }

  @Test
  void setInputAudioBalanceResponse() {
    assertResponse(TYPE, SetInputAudioBalanceResponse.class, null);
  }

  @Test
  void getInputAudioSyncOffsetResponse() {
    assertResponse(TYPE, GetInputAudioSyncOffsetResponse.class, d -> {
      Assertions.assertEquals(120, d.getInputAudioSyncOffset());
    });
  }

  @Test
  void setInputAudioSyncOffsetResponse() {
    assertResponse(TYPE, SetInputAudioSyncOffsetResponse.class, null);
  }

  @Test
  void getInputAudioMonitorTypeResponse() {
    assertResponse(TYPE, GetInputAudioMonitorTypeResponse.class, d -> {
      Assertions.assertEquals(MonitorType.MONITOR_AND_OUTPUT, d.getMonitorType());
    });
  }

  @Test
  void setInputAudioMonitorTypeResponse() {
    assertResponse(TYPE, SetInputAudioMonitorTypeResponse.class, null);
  }

  @Test
  void getInputAudioTracksResponse() {
    assertResponse(TYPE, GetInputAudioTracksResponse.class, d -> {
      Assertions.assertNotNull(d.getInputAudioTracks());
      Assertions.assertTrue(d.getInputAudioTracks().getOne());
      Assertions.assertTrue(d.getInputAudioTracks().getTwo());
      Assertions.assertTrue(d.getInputAudioTracks().getThree());
      Assertions.assertTrue(d.getInputAudioTracks().getFour());
      Assertions.assertTrue(d.getInputAudioTracks().getFive());
      Assertions.assertTrue(d.getInputAudioTracks().getSix());
    });
  }

  @Test
  void setInputAudioTracksResponse() {
    assertResponse(TYPE, SetInputAudioTracksResponse.class, null);
  }

  @Test
  void getInputPropertiesListPropertyItemsResponse() {
    assertResponse(TYPE, GetInputPropertiesListPropertyItemsResponse.class, d -> {
      Assertions.assertEquals(2, d.getPropertyItems().size());
    });
  }

  @Test
  void pressInputPropertiesButtonResponse() {
    assertResponse(TYPE, PressInputPropertiesButtonResponse.class, null);
  }
}
