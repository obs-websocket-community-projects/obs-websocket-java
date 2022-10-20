// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetVersionResponse extends RequestResponse<GetVersionResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Current OBS Studio version
     */
    @NonNull
    private String obsVersion;

    /**
     * Current obs-websocket version
     */
    @NonNull
    private String obsWebSocketVersion;

    /**
     * Current latest obs-websocket RPC version
     */
    @NonNull
    private Number rpcVersion;

    /**
     * Array of available RPC requests for the currently negotiated RPC version
     */
    @NonNull
    @Singular
    private List<String> availableRequests;

    /**
     * Image formats available in `GetSourceScreenshot` and `SaveSourceScreenshot` requests.
     */
    @NonNull
    @Singular
    private List<String> supportedImageFormats;

    /**
     * Name of the platform. Usually `windows`, `macos`, or `ubuntu` (linux flavor). Not guaranteed to be any of those
     */
    @NonNull
    private String platform;

    /**
     * Description of the platform, like `Windows 10 (10.0)`
     */
    @NonNull
    private String platformDescription;
  }
}
