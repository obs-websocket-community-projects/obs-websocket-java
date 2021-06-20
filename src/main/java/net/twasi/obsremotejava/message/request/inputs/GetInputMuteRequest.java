package net.twasi.obsremotejava.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputMuteRequest extends InputRequest {
    private final Data requestData;

    @Builder
    private GetInputMuteRequest(String inputName) {
        super(Type.GetInputMute);

        this.requestData = Data.builder().inputName(inputName).build();
    }
}
