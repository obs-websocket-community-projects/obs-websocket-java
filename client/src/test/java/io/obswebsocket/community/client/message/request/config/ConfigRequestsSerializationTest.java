package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.AbstractRequestSerializationTest;
import io.obswebsocket.community.client.message.request.config.PersistentDataRequest.SpecificData.Realm;
import org.junit.jupiter.api.Test;

public class ConfigRequestsSerializationTest extends AbstractRequestSerializationTest {

  @Test
  void getPersistentDataRequest() {
    GetPersistentDataRequest getPersistentDataRequest = GetPersistentDataRequest
        .builder().realm(Realm.GLOBAL).slotName("Slot Name").build();

    assertRequest("config", getPersistentDataRequest);
  }

  @Test
  void setPersistentDataRequest() {
    SetPersistentDataRequest setPersistentDataRequest = SetPersistentDataRequest
        .builder().realm(Realm.PROFILE).slotName("Slot Name").slotValue("Slot Value").build();

    assertRequest("config", setPersistentDataRequest);
  }

  @Test
  void getSceneCollectionListRequest() {
    GetSceneCollectionListRequest getSceneCollectionListRequest = GetSceneCollectionListRequest
        .builder().build();

    assertRequest("config", getSceneCollectionListRequest);
  }

  @Test
  void createSceneCollectionRequest() {
    CreateSceneCollectionRequest createSceneCollectionRequest = CreateSceneCollectionRequest
        .builder().sceneCollectionName("Collection Name").build();

    assertRequest("config", createSceneCollectionRequest);
  }

  @Test
  void getProfileListRequest() {
    GetProfileListRequest getProfileListRequest = GetProfileListRequest.builder().build();

    assertRequest("config", getProfileListRequest);
  }

  @Test
  void setCurrentProfileRequest() {
    SetCurrentProfileRequest setCurrentProfileRequest = SetCurrentProfileRequest.builder()
        .profileName("Profile Name")
        .build();

    assertRequest("config", setCurrentProfileRequest);
  }

  @Test
  void createProfileRequest() {
    CreateProfileRequest createProfileRequest = CreateProfileRequest.builder()
        .profileName("Profile Name")
        .build();

    assertRequest("config", createProfileRequest);
  }

  @Test
  void removeProfileRequest() {
    RemoveProfileRequest removeProfileRequest = RemoveProfileRequest.builder()
        .profileName("Profile Name")
        .build();

    assertRequest("config", removeProfileRequest);
  }

  @Test
  void getProfileParameterRequest() {
    GetProfileParameterRequest getProfileParameterRequest = GetProfileParameterRequest.builder()
        .parameterCategory("Category Name")
        .parameterName("Parameter Name")
        .build();

    assertRequest("config", getProfileParameterRequest);
  }

  @Test
  void setProfileParameterRequest() {
    SetProfileParameterRequest setProfileParameterRequest = SetProfileParameterRequest.builder()
        .parameterCategory("Category Name")
        .parameterName("Parameter Name")
        .parameterValue("New Value")
        .build();

    assertRequest("config", setProfileParameterRequest);
  }

  @Test
  void getVideoSettingsRequest() {
    GetVideoSettingsRequest getVideoSettingsRequest = GetVideoSettingsRequest.builder().build();

    assertRequest("config", getVideoSettingsRequest);
  }

  @Test
  void setVideoSettingsRequest() {
    SetVideoSettingsRequest setVideoSettingsRequest = SetVideoSettingsRequest.builder()
        .fpsNumerator(1)
        .fpsDenominator(1)
        .baseWidth(1)
        .baseHeight(1)
        .outputWidth(1)
        .outputHeight(1)
        .build();

    assertRequest("config", setVideoSettingsRequest);
  }

  @Test
  void removeSceneCollectionRequest() {
    RemoveSceneCollectionRequest removeSceneCollectionRequest = RemoveSceneCollectionRequest
        .builder()
        .sceneCollectionName("Collection Name")
        .build();

    assertRequest("config", removeSceneCollectionRequest);
  }

  @Test
  void setCurrentSceneCollectionRequest() {
    SetCurrentSceneCollectionRequest setCurrentSceneCollectionRequest = SetCurrentSceneCollectionRequest
        .builder()
        .sceneCollectionName("Collection Name")
        .build();

    assertRequest("config", setCurrentSceneCollectionRequest);
  }
}
