package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetInputNameRequest extends InputRequest<SetInputNameRequest.Data> {
  @Builder
  private SetInputNameRequest(String inputName, String newInputName) {
    super(RequestType.SetInputName,
        Data.builder().inputName(inputName).newInputName(newInputName).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends InputRequest.Data {

    @NonNull
    private final String newInputName;
  }
}
