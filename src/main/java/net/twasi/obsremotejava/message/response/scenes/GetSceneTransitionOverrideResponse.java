package net.twasi.obsremotejava.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetSceneTransitionOverrideResponse extends RequestResponse {
    private Data responseData;

    public GetSceneTransitionOverrideResponse() {
        super(Request.Type.GetSceneTransitionOverride);
    }

    @Getter
    @ToString
    public static class Data {
        private String transitionName;
        private Integer transitionDuration;
    }
}
