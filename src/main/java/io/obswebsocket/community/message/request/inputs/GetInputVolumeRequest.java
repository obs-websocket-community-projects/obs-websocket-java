package io.obswebsocket.community.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputVolumeRequest extends InputRequest {
    private final Data requestData;

    @Builder
    private GetInputVolumeRequest(String inputName) {
        super(Type.GetInputVolume);

        this.requestData = Data.builder().inputName(inputName).build();
    }
}
