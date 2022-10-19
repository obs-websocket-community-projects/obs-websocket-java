package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetGroupListRequest extends Request<Void> {

  @Builder
  protected GetGroupListRequest() {
    super(RequestType.GetGroupList, null);
  }
}
