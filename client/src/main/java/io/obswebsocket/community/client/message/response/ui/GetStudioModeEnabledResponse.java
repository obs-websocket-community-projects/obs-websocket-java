package io.obswebsocket.community.client.message.response.ui;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetStudioModeEnabledResponse extends RequestResponse<GetStudioModeEnabledResponse.Data> {
  @Getter
  @ToString
  public static class Data {
    private Boolean studioModeEnabled;
  }
}
