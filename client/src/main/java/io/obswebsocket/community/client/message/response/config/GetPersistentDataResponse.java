package io.obswebsocket.community.client.message.response.config;

import com.google.gson.JsonObject;
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
public class GetPersistentDataResponse extends RequestResponse<GetPersistentDataResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Value associated with the slot. `null` if not set
     */
    @NonNull
    private JsonObject slotValue;
  }
}
