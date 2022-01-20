package io.obswebsocket.community.client.message.request.general;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class BroadcastCustomEventRequest extends Request {

  @NonNull
  private final JsonObject requestData;

  @Builder
  private BroadcastCustomEventRequest(JsonObject requestData) {
    super(Data.Type.BroadcastCustomEvent);

    this.requestData = requestData;
  }
}
