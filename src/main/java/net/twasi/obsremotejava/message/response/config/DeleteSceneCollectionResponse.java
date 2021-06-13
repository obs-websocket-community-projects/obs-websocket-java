package net.twasi.obsremotejava.message.response.config;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class DeleteSceneCollectionResponse extends RequestResponse {
    public DeleteSceneCollectionResponse() {
        super(Request.Type.DeleteSceneCollection);
    }
}
