package io.obswebsocket.community.client.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Transition {
  private String transitionName;
  private String transitionKind;
  private Boolean transitionFixed;
}
