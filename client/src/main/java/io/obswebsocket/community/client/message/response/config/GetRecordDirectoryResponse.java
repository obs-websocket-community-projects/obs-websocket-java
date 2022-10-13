package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import java.io.File;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetRecordDirectoryResponse extends RequestResponse<GetRecordDirectoryResponse.Data> {
  public GetRecordDirectoryResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private File recordDirectory;
  }
}
