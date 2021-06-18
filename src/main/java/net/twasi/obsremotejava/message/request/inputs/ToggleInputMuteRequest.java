package net.twasi.obsremotejava.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class ToggleInputMuteRequest extends Request {
    private final Data requestData;

    public ToggleInputMuteRequest(String inputName) {
        super(Type.ToggleInputMute);

        this.requestData = Data.builder().inputName(inputName).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final String inputName;
    }
}
