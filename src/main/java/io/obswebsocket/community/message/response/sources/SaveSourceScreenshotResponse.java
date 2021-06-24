package io.obswebsocket.community.message.response.sources;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SaveSourceScreenshotResponse extends RequestResponse {
    public SaveSourceScreenshotResponse() {
        super(Request.Type.SaveSourceScreenshot);
    }
}
