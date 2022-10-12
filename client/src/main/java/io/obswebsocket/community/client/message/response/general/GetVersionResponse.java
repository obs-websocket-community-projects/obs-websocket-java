package io.obswebsocket.community.client.message.response.general;

import java.util.List;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetVersionResponse extends RequestResponse<GetVersionResponse.Data> {
  public GetVersionResponse() {
    super(Request.Data.Type.GetVersion);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Integer rpcVersion;
    private String obsWebSocketVersion;
    private String obsVersion;
    private List<String> availableRequests;
    private List<String> supportedImageFormats;
  }
}
