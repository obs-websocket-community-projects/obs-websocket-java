package net.twasi.obsremotejava.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class SetInputMuteRequest extends Request {
    private final Data requestData;

    public SetInputMuteRequest(String inputName, boolean inputMuted) {
        super(Type.SetInputMute);

        this.requestData = Data.builder().inputName(inputName).inputMuted(inputMuted).build();
    }

    @Getter
    @ToString
    @Builder
    public static class Data {
        private final String inputName;
        private final boolean inputMuted;
    }
}
