package net.twasi.obsremotejava.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetSceneItemEnabledResponse extends RequestResponse {
    private Data responseData;

    public GetSceneItemEnabledResponse() {
        super(Request.Type.GetSceneItemEnabled);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean sceneItemEnabled;
    }
}
