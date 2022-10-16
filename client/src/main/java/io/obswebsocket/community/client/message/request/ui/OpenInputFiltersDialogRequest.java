package io.obswebsocket.community.client.message.request.ui;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class OpenInputFiltersDialogRequest extends Request<OpenInputFiltersDialogRequest.Data> {

  @Builder
  private OpenInputFiltersDialogRequest(String inputName) {
    super(Request.Data.Type.OpenInputFiltersDialog, Data.builder().inputName(inputName).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String inputName;
  }
}
