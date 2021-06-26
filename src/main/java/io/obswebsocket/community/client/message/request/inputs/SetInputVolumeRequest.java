package io.obswebsocket.community.client.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetInputVolumeRequest extends InputRequest {
    private final Data requestData;

    @Builder
    private SetInputVolumeRequest(String inputName, Float inputVolumeDb, Float inputVolumeMul) {
        super(Type.SetInputVolume);

        this.requestData = Data.builder().inputName(inputName).inputVolumeDb(inputVolumeDb).inputVolumeMul(inputVolumeMul).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends InputRequest.Data {
        private Float inputVolumeDb;
        private Float inputVolumeMul;
    }
}
