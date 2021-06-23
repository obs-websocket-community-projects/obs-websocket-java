package net.twasi.obsremotejava.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetSceneItemLockedResponse extends RequestResponse {
    private Data responseData;

    public GetSceneItemLockedResponse() {
        super(Request.Type.GetSceneItemLocked);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean sceneItemLocked;
    }
}
