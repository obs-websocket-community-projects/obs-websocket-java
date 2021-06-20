package net.twasi.obsremotejava.message.request.inputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputVolumeRequest extends InputRequest {
    private final Data requestData;

    public GetInputVolumeRequest(String inputName) {
        super(Type.GetInputVolume);

        this.requestData = Data.builder().inputName(inputName).build();
    }
}
