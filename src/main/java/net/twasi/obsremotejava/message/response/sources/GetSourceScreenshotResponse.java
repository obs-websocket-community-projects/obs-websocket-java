package net.twasi.obsremotejava.message.response.sources;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

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
