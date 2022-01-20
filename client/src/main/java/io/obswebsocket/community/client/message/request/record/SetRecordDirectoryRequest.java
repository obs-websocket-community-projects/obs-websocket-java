package io.obswebsocket.community.client.message.request.record;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetRecordDirectoryRequest extends Request {

  private final Data requestData;

  @Builder
  private SetRecordDirectoryRequest(String recordDirectory, Boolean createIfNotExist) {
    super(Request.Data.Type.SetRecordDirectory);

    this.requestData = Data.builder().recordDirectory(recordDirectory)
        .createIfNotExist(createIfNotExist).build();
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String recordDirectory;
    @NonNull
    private final Boolean createIfNotExist;
  }
}
