package io.obswebsocket.community.client.message.request.record;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetRecordDirectoryRequest extends Request<SetRecordDirectoryRequest.Data> {
  @Builder
  private SetRecordDirectoryRequest(String recordDirectory, Boolean createIfNotExist) {
    super(Request.Data.Type.SetRecordDirectory, Data.builder().recordDirectory(recordDirectory)
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
