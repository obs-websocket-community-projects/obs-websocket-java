package io.obswebsocket.community.client.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetInputVolumeRequest extends InputRequest {
    private final Data requestData;

    @Builder
    private SetInputVolumeRequest(String inputName, float inputVolumeDb, float inputVolumeMul) {
        super(Type.SetInputVolume);

        this.requestData = Data.builder().inputName(inputName).inputVolumeDb(inputVolumeDb).inputVolumeMul(inputVolumeMul).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends InputRequest.Data {
        private final float inputVolumeDb;
        private final float inputVolumeMul;
    }
}
