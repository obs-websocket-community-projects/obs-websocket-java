package io.obswebsocket.community.client.message.response.sceneitems;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetGroupSceneItemListResponse extends GetSceneItemListResponse {

  public GetGroupSceneItemListResponse() {
    super();
  }
}
