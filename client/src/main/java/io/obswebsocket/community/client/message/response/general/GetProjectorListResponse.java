package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Projector;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetProjectorListResponse extends RequestResponse {

  private Data responseData;

  protected GetProjectorListResponse() {
    super(Request.Data.Type.GetProjectorList);
  }

  @Getter
  @ToString
  public static class Data {

    private List<Projector> projectors;
  }
}
