package net.twasi.obsremotejava.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
abstract class CurrentSceneResponse extends RequestResponse {
    CurrentSceneResponse(Request.Type requestType) {
        super(requestType);
    }

    @Getter
    @ToString
    static class Data {
        private String sceneName;
    }
}
