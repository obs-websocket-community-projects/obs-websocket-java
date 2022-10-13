package io.obswebsocket.community.client.message.response.sources;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Source;
import java.util.ArrayList;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSourceListResponse extends RequestResponse<GetSourceListResponse.Data> {

  public GetSourceListResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {

    private ArrayList<Source> sources;
  }
}
