package io.obswebsocket.community.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
public class SetInputVolumeRequest extends Request {
    private final Data requestData;

    @Builder
    private SetInputVolumeRequest(float inputVolumeDb, float inputVolumeMul) {
        super(Type.SetInputVolume);

        this.requestData = Data.builder().inputVolumeDb(inputVolumeDb).inputVolumeMul(inputVolumeMul).build();
    }

    @Getter
    @ToString(callSuper = true)
    @Builder
    static class Data {
        private final float inputVolumeDb;
        private final float inputVolumeMul;
    }
}
