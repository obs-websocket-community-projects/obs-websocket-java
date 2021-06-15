package net.twasi.obsremotejava.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.model.Scene;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetCurrentProgramSceneResponse extends RequestResponse {
    private Data responseData;

    public GetCurrentProgramSceneResponse() {
        super(Request.Type.GetCurrentProgramScene);
    }

    @Getter
    @ToString
    public static class Data {
        private String sceneName;
    }
}
