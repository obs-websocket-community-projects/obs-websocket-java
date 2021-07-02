package io.obswebsocket.community.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Projector {

  private String projectorName;
  private Type projectorType;
  private Integer projectorMonitor;
  private String projectorGeometry;
  private String sourceName;

  public enum Type {
    PREVIEW,
    SOURCE,
    SCENE,
    @SerializedName("STUDIOPROGRAM")
    STUDIO_PROGRAM,
    MULTIVIEW
  }
}
