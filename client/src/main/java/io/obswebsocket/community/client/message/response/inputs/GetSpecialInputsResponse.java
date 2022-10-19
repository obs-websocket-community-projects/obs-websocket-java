package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class GetSpecialInputsResponse extends RequestResponse<GetSpecialInputsResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the Desktop Audio input
     */
    @NonNull
    private String desktop1;

    /**
     * Name of the Desktop Audio 2 input
     */
    @NonNull
    private String desktop2;

    /**
     * Name of the Mic/Auxiliary Audio input
     */
    @NonNull
    private String mic1;

    /**
     * Name of the Mic/Auxiliary Audio 2 input
     */
    @NonNull
    private String mic2;

    /**
     * Name of the Mic/Auxiliary Audio 3 input
     */
    @NonNull
    private String mic3;

    /**
     * Name of the Mic/Auxiliary Audio 4 input
     */
    @NonNull
    private String mic4;
  }
}
