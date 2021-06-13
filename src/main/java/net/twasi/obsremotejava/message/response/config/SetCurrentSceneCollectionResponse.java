package net.twasi.obsremotejava.message.response.config;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.objects.SceneCollection;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class SetCurrentSceneCollectionResponse extends RequestResponse {
    public SetCurrentSceneCollectionResponse() {
        super(Request.Type.SetCurrentSceneCollection);
    }
}
