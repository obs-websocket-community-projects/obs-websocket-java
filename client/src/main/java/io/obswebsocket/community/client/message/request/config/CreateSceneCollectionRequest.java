package io.obswebsocket.community.client.message.request.config;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateSceneCollectionRequest extends SceneCollectionRequest {

  @SerializedName("d")
  private final Data data;

  @Builder
  private CreateSceneCollectionRequest(String sceneCollectionName) {
    super(Request.Data.Type.SetCurrentSceneCollection);

    this.data = Data.builder().requestId(this.getRequestId()).requestType(this.getRequestType())
        .requestData(SpecificData.builder().sceneCollectionName(sceneCollectionName).build())
        .build();
  }
}
