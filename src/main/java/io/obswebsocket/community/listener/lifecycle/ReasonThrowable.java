package io.obswebsocket.community.listener.lifecycle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class ReasonThrowable {

  private final String reason;
  private final Throwable throwable;
}
