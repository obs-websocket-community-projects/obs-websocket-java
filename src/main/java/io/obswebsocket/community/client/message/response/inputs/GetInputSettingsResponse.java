package io.obswebsocket.community.client.message.response.inputs;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetInputSettingsResponse extends RequestResponse {
    private Data responseData;

    public GetInputSettingsResponse() {
        super(Request.Type.GetInputSettings);
    }

    @Getter
    @ToString
    public static class Data {
        private JsonObject inputSettings;
        private String inputKind;
    }
}
