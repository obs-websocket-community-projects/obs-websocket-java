package net.twasi.obsremotejava.message.response.scenes;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.model.Scene;

@Getter
@ToString(callSuper = true)
public class GetSceneListResponse extends RequestResponse {

    private Data responseData;

    public GetSceneListResponse() {
        super(Request.Type.GetSceneList);
    }

    @AllArgsConstructor
    @Getter
    @ToString
    public static class Data {
        private String currentProgramSceneName;
        private String currentPreviewSceneName;
        private List<Scene> scenes;
    }
}
