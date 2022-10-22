package io.obswebsocket.community.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Scene {

  private String sceneName;
  private Integer sceneIndex;
}
