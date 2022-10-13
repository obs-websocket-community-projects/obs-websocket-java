package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetPersistentDataResponse extends RequestResponse<Void> {
  public SetPersistentDataResponse() {
    super();
  }

}
