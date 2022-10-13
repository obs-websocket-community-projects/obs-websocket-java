package io.obswebsocket.community.client.message.response.mediainputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class PreviousMediaInputPlaylistItemResponse extends RequestResponse<Void> {
  public PreviousMediaInputPlaylistItemResponse() {
    super();
  }
}
