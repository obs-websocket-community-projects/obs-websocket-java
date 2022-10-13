package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Projector;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetProjectorListResponse extends RequestResponse<GetProjectorListResponse.Data> {

  @Getter
  @ToString
  public static class Data {

    private List<Projector> projectors;
  }
}
