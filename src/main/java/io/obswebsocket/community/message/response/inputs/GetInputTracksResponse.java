package io.obswebsocket.community.message.response.inputs;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

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
