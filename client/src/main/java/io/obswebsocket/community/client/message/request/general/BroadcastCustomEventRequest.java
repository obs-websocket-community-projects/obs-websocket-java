package io.obswebsocket.community.client.message.request.general;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.message.request.general.BroadcastCustomEventRequest.SpecificData;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class BroadcastCustomEventRequest extends Request<SpecificData> {

  @Builder
  private BroadcastCustomEventRequest(JsonObject eventData) {
    super(RequestType.BroadcastCustomEvent, SpecificData.builder().eventData(eventData).build());
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    private JsonObject eventData;
  }
}
