// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request;

import io.obswebsocket.community.client.message.request.null.OtherTypeRequest;
import io.obswebsocket.community.client.message.request.null.SomeTypeRequest;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.null.OtherTypeResponse;
import io.obswebsocket.community.client.message.response.null.SomeTypeResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RequestType {
  SomeType(SomeTypeRequest.class, SomeTypeResponse.class),

  OtherType(OtherTypeRequest.class, OtherTypeResponse.class);

  private final Class<? extends Request> requestClass;

  private final Class<? extends RequestResponse> requestResponseClass;
}
