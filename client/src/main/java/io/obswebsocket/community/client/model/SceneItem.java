package io.obswebsocket.community.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SceneItem {

  private Integer sceneItemId;
  private Integer sceneItemIndex;
  private String sourceName;
  private String sourceType;
  private String inputKind;

  // TODO: v4.x SceneItem fields. Not sure how they will be serialized in v5.x
//    private double cy;
//    private double cx;
//    private long alignment;
//    private boolean render;
//    private boolean muted;
//    private boolean locked;
//    private int source_cx;
//    private int source_cy;
//    private double volume;
//    private double x;
//    private double y;
//    private String parentGroupName;
//    private List<SceneItem> groupChildren;

  public enum BlendMode {
    @SerializedName("OBS_BLEND_NORMAL")
    NORMAL,
    @SerializedName("OBS_BLEND_ADDITIVE")
    ADDITIVE,
    @SerializedName("OBS_BLEND_SUBTRACT")
    SUBTRACT,
    @SerializedName("OBS_BLEND_SCREEN")
    SCREEN,
    @SerializedName("OBS_BLEND_MULTIPLY")
    MULTIPLY,
    @SerializedName("OBS_BLEND_LIGHTEN")
    LIGHTEN,
    @SerializedName("OBS_BLEND_DARKEN")
    DARKEN
  }
}
