// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.category;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.model.Input;
import io.obswebsocket.community.client.model.Scene;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class TypeRequest extends Request<TypeRequest.SpecificData> {
  @Builder
  private TypeRequest(String stringField, Boolean booleanField, List<Boolean> booleanList,
      List<String> stringList, Input.AudioTracks audioTracks, JsonObject jsonObject,
      List<Scene> sceneList) {
    super(RequestType.Type, SpecificData.builder().stringField(stringField).booleanField(booleanField).booleanList(booleanList).stringList(stringList).audioTracks(audioTracks).jsonObject(jsonObject).sceneList(sceneList).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String stringField;

    @NonNull
    private Boolean booleanField;

    @NonNull
    private List<Boolean> booleanList;

    @NonNull
    private List<String> stringList;

    @NonNull
    private Input.AudioTracks audioTracks;

    @NonNull
    private JsonObject jsonObject;

    @NonNull
    private List<Scene> sceneList;
  }
}
