package io.obswebsocket.community.client.message.response.mediainputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class NextMediaInputPlaylistItemResponse extends RequestResponse {

  public NextMediaInputPlaylistItemResponse() {
    super(Request.Type.NextMediaInputPlaylistItem);
  }
}