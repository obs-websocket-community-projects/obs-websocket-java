package io.obswebsocket.community.client.message.response.general;

import java.util.List;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Projector;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetProjectorListResponse extends RequestResponse<GetProjectorListResponse.Data> {
  protected GetProjectorListResponse() {
    super(Request.Data.Type.GetProjectorList);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private List<Projector> projectors;
  }
}
