package io.obswebsocket.community.client.message.response;

import io.obswebsocket.community.client.message.Message;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RequestBatchResponse extends Message {

  protected String requestId;
  protected List<RequestResponse> results;

  protected RequestBatchResponse() {
    super(Type.RequestBatchResponse);
  }

  public boolean isSuccessful() {
    return this.results != null && this.results.stream().allMatch(RequestResponse::isSuccessful);
  }
}
