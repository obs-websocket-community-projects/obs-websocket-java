package io.obswebsocket.community.client.message.response.sources;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetSourceScreenshotResponse extends RequestResponse {
    private Data responseData;

    public GetSourceScreenshotResponse() {
        super(Request.Type.GetSourceScreenshot);
    }

    @Getter
    @ToString
    public static class Data {
        private String imageData;
    }
}
