package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetVersionResponse extends RequestResponse<GetVersionResponse.Data> {
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
