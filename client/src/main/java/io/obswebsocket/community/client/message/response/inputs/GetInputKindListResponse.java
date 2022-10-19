package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class GetInputKindListResponse extends RequestResponse<GetInputKindListResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Array of input kinds
     */
    @NonNull
    @Singular
    private List<String> inputKinds;
  }
}
