package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetProfileListResponse extends RequestResponse<GetProfileListResponse.Data> {
  public GetProfileListResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private List<String> profiles;
    private String currentProfileName;
  }
}
