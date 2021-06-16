package net.twasi.obsremotejava.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class CreateSceneResponse extends RequestResponse {
    public CreateSceneResponse() {
        super(Request.Type.CreateScene);
    }
}
