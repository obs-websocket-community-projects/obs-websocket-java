package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class NextMediaInputPlaylistItemRequest extends MediaInputRequest<MediaInputRequest.Data> {
  @Builder
  private NextMediaInputPlaylistItemRequest(String inputName) {
    super(RequestType.NextMediaInputPlaylistItem, Data.builder().inputName(inputName).build());
  }
}
