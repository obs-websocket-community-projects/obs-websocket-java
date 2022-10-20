// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.ui;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class OpenInputPropertiesDialogRequest extends Request<OpenInputPropertiesDialogRequest.SpecificData> {
  @Builder
  private OpenInputPropertiesDialogRequest(String inputName) {
    super(RequestType.OpenInputPropertiesDialog, SpecificData.builder().inputName(inputName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;
  }
}
