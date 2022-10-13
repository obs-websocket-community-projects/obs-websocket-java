package io.obswebsocket.community.client.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Source {

  private String sourceName;
  private String sourceType;
  private String inputKind;
}
