package io.obswebsocket.community.client.message.request.record;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StartRecordRequest extends Request {

  private final Data requestData;

  @Builder
  private StartRecordRequest(Boolean waitForResult) {
    super(Type.StartRecord);

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
