package io.obswebsocket.community.client.message.response.transitions;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Transition;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetTransitionListResponse extends RequestResponse<GetTransitionListResponse.Data> {
  public GetTransitionListResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private String currentTransitionName;
    private List<Transition> transitions;
  }
}
