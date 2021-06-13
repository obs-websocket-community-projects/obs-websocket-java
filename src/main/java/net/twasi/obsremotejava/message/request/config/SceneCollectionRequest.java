package net.twasi.obsremotejava.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public abstract class SceneCollectionRequest extends Request {
    private final Data requestData;

    public SceneCollectionRequest(Request.Type requestType, String sceneCollectionName) {
        super(requestType);

        this.requestData = Data.builder().sceneCollectionName(sceneCollectionName).build();
    }

    @ToString
    @Builder
    public static class Data {
        private final String sceneCollectionName;
    }
}
