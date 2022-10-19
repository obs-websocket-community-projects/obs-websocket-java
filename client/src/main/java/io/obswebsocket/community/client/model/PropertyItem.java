package io.obswebsocket.community.client.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PropertyItem {

  private String itemName;
  private String itemValue;
  private Boolean itemEnabled;
}
