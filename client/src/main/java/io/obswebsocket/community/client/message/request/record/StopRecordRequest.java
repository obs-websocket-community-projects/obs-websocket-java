package io.obswebsocket.community.client.message.request.record;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StopRecordRequest extends Request {

  private final Data requestData;

  @Builder
  private StopRecordRequest(Boolean waitForResult) {
    super(Request.Data.Type.StopRecord);

    this.requestData = Data.builder().waitForResult(waitForResult).build();
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final Boolean waitForResult;
  }
}
