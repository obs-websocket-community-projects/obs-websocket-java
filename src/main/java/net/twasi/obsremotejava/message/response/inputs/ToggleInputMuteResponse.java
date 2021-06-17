package net.twasi.obsremotejava.message.response.inputs;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class ToggleInputMuteResponse extends RequestResponse {
    private Data responseData;

    public ToggleInputMuteResponse() {
        super(Request.Type.ToggleInputMute);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean inputMuted;
    }
}
