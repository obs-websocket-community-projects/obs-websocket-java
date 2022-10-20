package io.obswebsocket.community.client.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class InputLevels extends Input {

  private Double inputVolumeDb;
  private Double inputVolumeMul;
}
