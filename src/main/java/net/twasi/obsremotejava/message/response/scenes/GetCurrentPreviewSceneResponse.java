package net.twasi.obsremotejava.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetCurrentPreviewSceneResponse extends RequestResponse {
    private Data responseData;

    public GetCurrentPreviewSceneResponse() {
        super(Request.Type.GetCurrentPreviewScene);
    }

    @Getter
    @ToString
    public static class Data {
        private String sceneName;
    }
}
