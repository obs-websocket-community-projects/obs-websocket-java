package io.obswebsocket.community.client.message.request.config;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveSceneCollectionRequest extends SceneCollectionRequest {

  @SerializedName("d")
  private final Data data;

  @Builder
  private RemoveSceneCollectionRequest(String sceneCollectionName) {
    super(Request.Data.Type.RemoveSceneCollection);

    this.data = Data.builder().requestId(this.getRequestId()).requestType(this.getRequestType())
        .requestData(SpecificData.builder().sceneCollectionName(sceneCollectionName).build())
        .build();
  }
}
