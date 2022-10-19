package io.obswebsocket.community.client.message.request.ui;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class OpenInputInteractDialogRequest extends Request<OpenInputInteractDialogRequest.Data> {

  @Builder
  private OpenInputInteractDialogRequest(String inputName) {
    super(RequestType.OpenInputInteractDialog, Data.builder().inputName(inputName).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String inputName;
  }
}
