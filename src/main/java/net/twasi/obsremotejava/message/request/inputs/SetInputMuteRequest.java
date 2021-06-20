package net.twasi.obsremotejava.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class SetInputMuteRequest extends InputRequest {
    private final Data requestData;

    public SetInputMuteRequest(String inputName, Boolean inputMuted) {
        super(Type.SetInputMute);

        this.requestData = Data.builder().inputName(inputName).inputMuted(inputMuted).build();
    }

    @Getter
    @ToString(callSuper = true)
    static class Data extends InputRequest.Data {
        @NonNull
        private final Boolean inputMuted;

        @Builder
        Data(String inputName, Boolean inputMuted) {
            super(inputName);

            this.inputMuted = inputMuted;
        }
    }
}
