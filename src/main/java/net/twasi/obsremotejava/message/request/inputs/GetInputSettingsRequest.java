package net.twasi.obsremotejava.message.request.inputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputSettingsRequest extends InputRequest {
    private final Data requestData;

    public GetInputSettingsRequest(String inputName) {
        super(Type.GetInputSettings);

        this.requestData = Data.builder().inputName(inputName).build();
    }
}
