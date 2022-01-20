package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class PressInputPropertiesButtonRequest extends InputRequest {

  private final Data requestData;

  @Builder
  private PressInputPropertiesButtonRequest(String inputName, String propertyName) {
    super(Request.Data.Type.PressInputPropertiesButton);

    this.requestData = Data.builder().inputName(inputName).propertyName(propertyName).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends InputRequest.Data {

    @NonNull
    private final String propertyName;
  }
}
