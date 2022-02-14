package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetVersionResponse extends RequestResponse {

  private Data responseData;

  public GetVersionResponse() {
    super(Request.Type.GetVersion);
  }

  @Getter
  @ToString
  public static class Data {

    private Integer rpcVersion;
    private String obsWebSocketVersion;
    private String obsVersion;
    private List<String> availableRequests;
    private List<String> supportedImageFormats;
  }
}
