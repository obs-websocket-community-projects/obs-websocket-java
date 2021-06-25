package io.obswebsocket.community.client.message.response.transitions;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetTransitionSettingsResponse extends RequestResponse {
    private Data responseData;

    public GetTransitionSettingsResponse() {
        super(Request.Type.GetTransitionSettings);
    }

    @Getter
    @ToString
    public static class Data {
        private JsonObject transitionSettings;
    }
}
