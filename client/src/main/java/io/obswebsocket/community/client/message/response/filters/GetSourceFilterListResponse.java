package io.obswebsocket.community.client.message.response.filters;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Filter;
import java.util.List;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterListResponse extends RequestResponse<GetSourceFilterListResponse.Data> {
  public GetSourceFilterListResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private List<Filter> filters;
  }
}
