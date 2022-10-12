package io.obswebsocket.community.client.message.response.filters;

import java.util.List;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Filter;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterListResponse extends RequestResponse<GetSourceFilterListResponse.Data> {
  public GetSourceFilterListResponse() {
    super(Request.Data.Type.GetSourceFilterList);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private List<Filter> filters;
  }
}
