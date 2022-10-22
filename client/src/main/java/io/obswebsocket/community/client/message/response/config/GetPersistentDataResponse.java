// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.config;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetPersistentDataResponse extends RequestResponse<GetPersistentDataResponse.SpecificData> {
  /**
   * Value associated with the slot. `null` if not set
   *
   * @return the slotValue
   */
  public JsonObject getSlotValue() {
    return getMessageData().getResponseData().getSlotValue();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Value associated with the slot. `null` if not set
     */
    private JsonObject slotValue;
  }
}
