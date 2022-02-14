package io.obswebsocket.community.client.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetInputNameRequest extends InputRequest {

  private final Data requestData;

  @Builder
  private SetInputNameRequest(String inputName, String newInputName) {
    super(Type.SetInputName);

    this.requestData = Data.builder().inputName(inputName).newInputName(newInputName).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends InputRequest.Data {

    @NonNull
    private final String newInputName;
  }
}
