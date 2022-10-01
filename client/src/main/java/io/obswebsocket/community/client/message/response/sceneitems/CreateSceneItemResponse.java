package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class CreateSceneItemResponse extends RequestResponse<CreateSceneItemResponse.Data> {
  public CreateSceneItemResponse() {
    super(Request.Data.Type.CreateSceneItem);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Integer sceneItemId;
  }
}
