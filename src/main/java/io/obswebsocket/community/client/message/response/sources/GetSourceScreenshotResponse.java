package io.obswebsocket.community.client.message.response.sources;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

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
