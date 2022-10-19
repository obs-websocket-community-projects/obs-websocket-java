package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetInputVolumeRequest extends InputRequest<SetInputVolumeRequest.Data> {

  @Builder
  private SetInputVolumeRequest(String inputName, Float inputVolumeDb, Float inputVolumeMul) {
    super(RequestType.SetInputVolume,
        Data.builder().inputName(inputName).inputVolumeDb(inputVolumeDb)
            .inputVolumeMul(inputVolumeMul).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends InputRequest.Data {

    private Float inputVolumeDb;
    private Float inputVolumeMul;
  }
}
