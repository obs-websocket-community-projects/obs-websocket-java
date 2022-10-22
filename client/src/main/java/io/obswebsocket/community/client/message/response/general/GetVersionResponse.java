// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetVersionResponse extends RequestResponse<GetVersionResponse.SpecificData> {
  /**
   * Current OBS Studio version
   *
   * @return the obsVersion
   */
  public String getObsVersion() {
    return getMessageData().getResponseData().getObsVersion();
  }

  /**
   * Current obs-websocket version
   *
   * @return the obsWebSocketVersion
   */
  public String getObsWebSocketVersion() {
    return getMessageData().getResponseData().getObsWebSocketVersion();
  }

  /**
   * Current latest obs-websocket RPC version
   *
   * @return the rpcVersion
   */
  public Number getRpcVersion() {
    return getMessageData().getResponseData().getRpcVersion();
  }

  /**
   * Array of available RPC requests for the currently negotiated RPC version
   *
   * @return the availableRequests
   */
  public List<String> getAvailableRequests() {
    return getMessageData().getResponseData().getAvailableRequests();
  }

  /**
   * Image formats available in `GetSourceScreenshot` and `SaveSourceScreenshot` requests.
   *
   * @return the supportedImageFormats
   */
  public List<String> getSupportedImageFormats() {
    return getMessageData().getResponseData().getSupportedImageFormats();
  }

  /**
   * Name of the platform. Usually `windows`, `macos`, or `ubuntu` (linux flavor). Not guaranteed to be any of those
   *
   * @return the platform
   */
  public String getPlatform() {
    return getMessageData().getResponseData().getPlatform();
  }

  /**
   * Description of the platform, like `Windows 10 (10.0)`
   *
   * @return the platformDescription
   */
  public String getPlatformDescription() {
    return getMessageData().getResponseData().getPlatformDescription();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Current OBS Studio version
     */
    private String obsVersion;

    /**
     * Current obs-websocket version
     */
    private String obsWebSocketVersion;

    /**
     * Current latest obs-websocket RPC version
     */
    private Number rpcVersion;

    /**
     * Array of available RPC requests for the currently negotiated RPC version
     */
    @Singular
    private List<String> availableRequests;

    /**
     * Image formats available in `GetSourceScreenshot` and `SaveSourceScreenshot` requests.
     */
    @Singular
    private List<String> supportedImageFormats;

    /**
     * Name of the platform. Usually `windows`, `macos`, or `ubuntu` (linux flavor). Not guaranteed to be any of those
     */
    private String platform;

    /**
     * Description of the platform, like `Windows 10 (10.0)`
     */
    private String platformDescription;
  }
}
