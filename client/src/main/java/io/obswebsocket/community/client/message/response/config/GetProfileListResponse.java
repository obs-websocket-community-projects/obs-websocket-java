package io.obswebsocket.community.client.message.response.config;

import java.util.List;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Profile;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetProfileListResponse extends RequestResponse<GetProfileListResponse.Data> {
  public GetProfileListResponse() {
    super(Request.Data.Type.GetProfileList);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private List<Profile> profiles;
    private String currentProfileName;
  }
}
