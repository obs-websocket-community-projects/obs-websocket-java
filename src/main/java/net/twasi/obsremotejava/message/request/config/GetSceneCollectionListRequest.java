package net.twasi.obsremotejava.message.request.config;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetSceneCollectionListRequest extends Request {
    public GetSceneCollectionListRequest() {
        super(Type.GetSceneCollectionList);
    }
}
