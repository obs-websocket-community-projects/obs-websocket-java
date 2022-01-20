package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Profile;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetProfileListResponse extends RequestResponse {

  private Data responseData;

  public GetProfileListResponse() {
    super(Request.Data.Type.GetProfileList);
  }

  @Getter
  @ToString
  public static class Data {

    private List<Profile> profiles;
    private String currentProfileName;
  }
}
