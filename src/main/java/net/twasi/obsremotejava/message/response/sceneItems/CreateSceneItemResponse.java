package net.twasi.obsremotejava.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class CreateSceneItemResponse extends RequestResponse {
    private Data responseData;

    public CreateSceneItemResponse() {
        super(Request.Type.CreateSceneItem);
    }

    @Getter
    @ToString
    public static class Data {
        private Integer sceneItemId;
    }
}
