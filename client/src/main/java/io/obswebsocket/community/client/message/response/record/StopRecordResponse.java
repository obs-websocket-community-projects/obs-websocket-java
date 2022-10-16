package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.record.StopRecordResponse.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StopRecordResponse extends RequestResponse<Data> {

  public StopRecordResponse() {
    super();
  }

  @Getter
  @ToString
  public class Data {

    private String outputPath;
  }
}
