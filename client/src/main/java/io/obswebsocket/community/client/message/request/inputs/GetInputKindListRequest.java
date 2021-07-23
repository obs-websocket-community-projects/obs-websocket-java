package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputKindListRequest extends Request {

  private final Data requestData;

  @Builder
  private GetInputKindListRequest(Boolean unversioned, Boolean includeDisabled) {
    super(Type.GetInputKindList);

    this.requestData = Data.builder().unversioned(unversioned).includeDisabled(includeDisabled).build();
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    private final Boolean unversioned;
    private final Boolean includeDisabled;
  }
}
