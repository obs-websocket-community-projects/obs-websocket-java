package net.twasi.obsremotejava.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.model.SceneItem;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetSceneItemListResponse extends RequestResponse {
    private Data responseData;

    public GetSceneItemListResponse() {
        super(Request.Type.GetSceneItemList);
    }

    @Getter
    @ToString
    public static class Data {
        private List<SceneItem> sceneItems;
    }
}
