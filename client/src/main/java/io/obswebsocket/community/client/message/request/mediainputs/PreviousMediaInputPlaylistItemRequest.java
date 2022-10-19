package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class PreviousMediaInputPlaylistItemRequest extends MediaInputRequest<MediaInputRequest.Data> {
  @Builder
  private PreviousMediaInputPlaylistItemRequest(String inputName) {
    super(RequestType.PreviousMediaInputPlaylistItem, Data.builder().inputName(inputName).build());
  }
}
