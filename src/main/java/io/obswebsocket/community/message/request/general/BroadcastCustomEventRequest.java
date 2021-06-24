package io.obswebsocket.community.message.request.general;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
public class BroadcastCustomEventRequest extends Request {
    @NonNull
    private final JsonObject requestData;

    @Builder
    private BroadcastCustomEventRequest(JsonObject requestData) {
        super(Type.BroadcastCustomEvent);

        this.requestData = requestData;
    }
}
