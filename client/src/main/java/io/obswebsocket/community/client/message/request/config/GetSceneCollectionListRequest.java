package io.obswebsocket.community.client.message.request.config;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneCollectionListRequest extends Request {

  @SerializedName("d")
  private final Data data;

  @Builder
  private GetSceneCollectionListRequest() {
    super(Data.Type.GetSceneCollectionList);

    this.data = Data.builder().requestId(this.getRequestId()).requestType(this.getRequestType())
        .build();
  }
}
