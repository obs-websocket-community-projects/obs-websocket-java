package io.obswebsocket.community.client.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Monitor {

  private Integer monitorIndex;
  private String monitorName;
  private Integer monitorWidth;
  private Integer monitorHeight;
  private Integer monitorPositionX;
  private Integer monitorPositionY;
}
