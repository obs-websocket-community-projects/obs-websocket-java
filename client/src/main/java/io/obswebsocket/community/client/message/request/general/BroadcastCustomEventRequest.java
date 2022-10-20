// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.general;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class BroadcastCustomEventRequest extends Request<BroadcastCustomEventRequest.SpecificData> {
  @Builder
  private BroadcastCustomEventRequest(JsonObject eventData) {
    super(RequestType.BroadcastCustomEvent, SpecificData.builder().eventData(eventData).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private JsonObject eventData;
  }
}
