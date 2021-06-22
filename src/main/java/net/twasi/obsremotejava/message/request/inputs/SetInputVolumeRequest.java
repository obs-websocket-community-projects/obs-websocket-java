package net.twasi.obsremotejava.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

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
        @NonNull
        private final float inputVolumeDb;
        private final float inputVolumeMul;
    }
}
