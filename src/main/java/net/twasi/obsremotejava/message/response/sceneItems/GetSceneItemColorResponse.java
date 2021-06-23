package net.twasi.obsremotejava.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetSceneItemColorResponse extends RequestResponse {
    private Data responseData;

    public GetSceneItemColorResponse() {
        super(Request.Type.SetSceneItemLocked);
    }

    @Getter
    @ToString
    public static class Data {
        private Integer sceneItemColor;
    }
}
