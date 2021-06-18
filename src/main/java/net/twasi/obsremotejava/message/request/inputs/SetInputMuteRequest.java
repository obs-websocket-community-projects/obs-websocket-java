package net.twasi.obsremotejava.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class SetInputMuteRequest extends Request {
    private final Data requestData;

    public SetInputMuteRequest(String inputName, Boolean inputMuted) {
        super(Type.SetInputMute);

        this.requestData = Data.builder().inputName(inputName).inputMuted(inputMuted).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final String inputName;
        @NonNull
        private final Boolean inputMuted;
    }
}
