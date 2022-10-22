// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSpecialInputsResponse extends RequestResponse<GetSpecialInputsResponse.SpecificData> {
  /**
   * Name of the Desktop Audio input
   *
   * @return the desktop1
   */
  public String getDesktop1() {
    return getMessageData().getResponseData().getDesktop1();
  }

  /**
   * Name of the Desktop Audio 2 input
   *
   * @return the desktop2
   */
  public String getDesktop2() {
    return getMessageData().getResponseData().getDesktop2();
  }

  /**
   * Name of the Mic/Auxiliary Audio input
   *
   * @return the mic1
   */
  public String getMic1() {
    return getMessageData().getResponseData().getMic1();
  }

  /**
   * Name of the Mic/Auxiliary Audio 2 input
   *
   * @return the mic2
   */
  public String getMic2() {
    return getMessageData().getResponseData().getMic2();
  }

  /**
   * Name of the Mic/Auxiliary Audio 3 input
   *
   * @return the mic3
   */
  public String getMic3() {
    return getMessageData().getResponseData().getMic3();
  }

  /**
   * Name of the Mic/Auxiliary Audio 4 input
   *
   * @return the mic4
   */
  public String getMic4() {
    return getMessageData().getResponseData().getMic4();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the Desktop Audio input
     */
    private String desktop1;

    /**
     * Name of the Desktop Audio 2 input
     */
    private String desktop2;

    /**
     * Name of the Mic/Auxiliary Audio input
     */
    private String mic1;

    /**
     * Name of the Mic/Auxiliary Audio 2 input
     */
    private String mic2;

    /**
     * Name of the Mic/Auxiliary Audio 3 input
     */
    private String mic3;

    /**
     * Name of the Mic/Auxiliary Audio 4 input
     */
    private String mic4;
  }
}
