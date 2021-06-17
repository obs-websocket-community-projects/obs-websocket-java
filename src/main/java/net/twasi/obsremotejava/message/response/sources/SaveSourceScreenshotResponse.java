package net.twasi.obsremotejava.message.response.sources;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SaveSourceScreenshotResponse extends RequestResponse {
    public SaveSourceScreenshotResponse() {
        super(Request.Type.SaveSourceScreenshot);
    }
}
