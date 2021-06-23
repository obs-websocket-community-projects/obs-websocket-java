package net.twasi.obsremotejava.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class DuplicateSceneItemResponse extends RequestResponse {
    private Data responseData;

    public DuplicateSceneItemResponse() {
        super(Request.Type.DuplicateSceneItem);
    }

    @Getter
    @ToString
    public static class Data {
        private Integer sceneItemId;
    }
}
