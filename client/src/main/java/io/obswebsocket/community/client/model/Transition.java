package io.obswebsocket.community.client.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
public class Transition {
  private String transitionName;
  private String transitionKind;
  private Boolean transitionFixed;
}
