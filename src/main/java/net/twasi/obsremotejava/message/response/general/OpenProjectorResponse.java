package net.twasi.obsremotejava.message.response.general;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class OpenProjectorResponse extends RequestResponse {
    public OpenProjectorResponse() {
        super(Request.Type.OpenProjector);
    }
}
