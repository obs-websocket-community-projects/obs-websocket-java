package io.obswebsocket.community.client.message.response.transitions;

import java.util.List;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Transition;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetTransitionListResponse extends RequestResponse<GetTransitionListResponse.Data> {
  public GetTransitionListResponse() {
    super(Request.Data.Type.GetTransitionList);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private String currentTransitionName;
    private List<Transition> transitions;
  }
}
