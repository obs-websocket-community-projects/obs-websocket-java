package io.obswebsocket.community.client.message.model;

import lombok.Builder;

@Builder
public class KeyModifiers {

  private final boolean shift;
  private final boolean alt;
  private final boolean control;
  private final boolean command;
}
