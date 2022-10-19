package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.AbstractResponseSerializationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConfigResponseSerializationTest extends AbstractResponseSerializationTest {

  private static final String TYPE = "config";

  @Test
  void getPersistentDataResponse() {
    assertResponse(TYPE, GetPersistentDataResponse.class, data -> {
      Assertions.assertEquals("Slot Value", data.getSlotValue());
    });
  }

  @Test
  void setPersistentDataResponse() {
    assertResponse(TYPE, SetPersistentDataResponse.class, data -> {});
  }

  @Test
  void getSceneCollectionListResponse() {
    assertResponse(TYPE, GetSceneCollectionListResponse.class, data -> {
      Assertions.assertEquals(2, data.getSceneCollections().size());
      Assertions.assertEquals("Collection 1", data.getCurrentSceneCollectionName());
    });
  }

  @Test
  void setCurrentSceneCollectionResponse() {
    assertResponse(TYPE, SetCurrentSceneCollectionResponse.class, data -> {});
  }

  @Test
  void createSceneCollectionResponse() {
    assertResponse(TYPE, CreateSceneCollectionResponse.class, data -> {});
  }

  @Test
  void removeSceneCollectionResponse() {
    assertResponse(TYPE, RemoveSceneCollectionResponse.class, data -> {});
  }

  @Test
  void getProfileListResponse() {
    assertResponse(TYPE, GetProfileListResponse.class, data -> {
      Assertions.assertEquals(2, data.getProfiles().size());
      Assertions.assertEquals("Profile 1", data.getCurrentProfileName());
    });
  }

  @Test
  void setCurrentProfileResponse() {
    assertResponse(TYPE, SetCurrentProfileResponse.class, data -> {});
  }

  @Test
  void createProfileResponse() {
    assertResponse(TYPE, CreateProfileResponse.class, data -> {});
  }

  @Test
  void removeProfileResponse() {
    assertResponse(TYPE, RemoveProfileResponse.class, data -> {});
  }

  @Test
  void getProfileParameterResponse() {
    assertResponse(TYPE, GetProfileParameterResponse.class, data -> {
      Assertions.assertEquals("Profile Parameter Value", data.getParameterValue());
      Assertions.assertEquals("Default Profile Parameter Value", data.getDefaultParameterValue());
    });
  }

  @Test
  void setProfileParameterResponse() {
    assertResponse(TYPE, SetProfileParameterResponse.class, data -> {});
  }

  @Test
  void getVideoSettingsResponse() {
    assertResponse(TYPE, GetVideoSettingsResponse.class, data -> {
      Assertions.assertEquals(30, data.getFpsNumerator());
      Assertions.assertEquals(100, data.getFpsDenominator());
      Assertions.assertEquals(1920, data.getBaseWidth());
      Assertions.assertEquals(1080, data.getBaseHeight());
      Assertions.assertEquals(1920, data.getOutputWidth());
      Assertions.assertEquals(1080, data.getOutputHeight());
    });
  }

  @Test
  void setVideoSettingsResponse() {
    assertResponse(TYPE, SetVideoSettingsResponse.class, data -> {});
  }

  @Test
  void getStreamServiceSettingsResponse() {
    assertResponse(TYPE, GetStreamServiceSettingsResponse.class, data -> {
      Assertions.assertEquals("rtmp_custom", data.getStreamServiceType());
      Assertions.assertEquals(2, data.getStreamServiceSettings().size());
    });
  }

  @Test
  void setStreamServiceSettingsResponse() {
    assertResponse(TYPE, SetStreamServiceSettingsResponse.class, data -> {});
  }

  @Test
  void getRecordDirectoryResponse() {
    assertResponse(TYPE, GetRecordDirectoryResponse.class, data -> {
      Assertions.assertEquals("/output/directory", data.getRecordDirectory());
    });
  }
}
