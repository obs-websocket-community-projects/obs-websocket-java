// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.category;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Input;
import io.obswebsocket.community.client.model.Scene;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class TypeResponse extends RequestResponse<TypeResponse.SpecificData> {
  /**
   * stringField description
   *
   * @return the stringField
   */
  public String getStringField() {
    return getMessageData().getResponseData().getStringField();
  }

  /**
   * booleanField description
   *
   * @return the booleanField
   */
  public Boolean getBooleanField() {
    return getMessageData().getResponseData().getBooleanField();
  }

  /**
   * booleanList description
   *
   * @return the booleanList
   */
  public List<Boolean> getBooleanList() {
    return getMessageData().getResponseData().getBooleanList();
  }

  /**
   * stringList description
   *
   * @return the stringList
   */
  public List<String> getStringList() {
    return getMessageData().getResponseData().getStringList();
  }

  /**
   * audioTracks description
   *
   * @return the audioTracks
   */
  public Input.AudioTracks getAudioTracks() {
    return getMessageData().getResponseData().getAudioTracks();
  }

  /**
   * jsonObject description
   *
   * @return the jsonObject
   */
  public JsonObject getJsonObject() {
    return getMessageData().getResponseData().getJsonObject();
  }

  /**
   * sceneList description
   *
   * @return the sceneList
   */
  public List<Scene> getSceneList() {
    return getMessageData().getResponseData().getSceneList();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * stringField description
     */
    private String stringField;

    /**
     * booleanField description
     */
    private Boolean booleanField;

    /**
     * booleanList description
     */
    private List<Boolean> booleanList;

    /**
     * stringList description
     */
    private List<String> stringList;

    /**
     * audioTracks description
     */
    private Input.AudioTracks audioTracks;

    /**
     * jsonObject description
     */
    private JsonObject jsonObject;

    /**
     * sceneList description
     */
    private List<Scene> sceneList;
  }
}
