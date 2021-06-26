package io.obswebsocket.community.client.message.response.inputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputTracksResponse extends RequestResponse {
    private Data responseData;

    public GetInputTracksResponse() {
        super(Request.Type.GetInputTracks);
    }

    @Getter
    @ToString
    public static class Data {
        // TODO: investigate exact type
        private JsonObject inputAudioTracks;
    }
}
