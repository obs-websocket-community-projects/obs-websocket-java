package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.Request.Data.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetGroupListRequest extends Request<Void> {

  @Builder
  protected GetGroupListRequest() {
    super(Type.GetGroupList, null);
  }
}
