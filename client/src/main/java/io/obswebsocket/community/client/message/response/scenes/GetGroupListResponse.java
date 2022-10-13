package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetGroupListResponse extends RequestResponse<GetGroupListResponse.Data> {
  public GetGroupListResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private String[] groups;
  }
}
