package io.obswebsocket.community.client.message.response.record;

import java.io.File;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetRecordDirectoryResponse extends RequestResponse<GetRecordDirectoryResponse.Data> {
  public GetRecordDirectoryResponse() {
    super(Request.Data.Type.GetRecordDirectory);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private File recordDirectory;
  }
}
