package net.twasi.obsremotejava.message.request.inputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ToggleInputMuteRequest extends InputRequest {
    private final Data requestData;

    public ToggleInputMuteRequest(String inputName) {
        super(Type.ToggleInputMute);

        this.requestData = Data.builder().inputName(inputName).build();
    }
}
