package net.twasi.obsremotejava.message.response.inputs;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetInputMuteResponse extends RequestResponse {
    public SetInputMuteResponse() {
        super(Request.Type.SetInputMute);
    }
}
