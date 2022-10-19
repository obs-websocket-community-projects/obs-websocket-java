package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetRecordDirectoryRequest extends Request<SetRecordDirectoryRequest.Data> {
  @Builder
  private SetRecordDirectoryRequest(String recordDirectory, Boolean createIfNotExist) {
    super(RequestType.SetRecordDirectory, Data.builder().recordDirectory(recordDirectory)
        .createIfNotExist(createIfNotExist).build());
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
