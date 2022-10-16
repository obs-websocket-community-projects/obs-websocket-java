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

  @Getter
  @Setter
  @ToString
  public static class Transform {
    private Float sourceWidth;
    private Float sourceHeight;

    private Float positionX;
    private Float positionY;

    private Float rotation;

    private Float scaleX;
    private Float scaleY;

    private Float width;
    private Float height;

    private Integer alignment;

    private String boundsType;
    private Integer boundsAlignment;
    private Float boundsWidth;
    private Float boundsHeight;

    private Integer cropLeft;
    private Integer cropRight;
    private Integer cropTop;
    private Integer cropBottom;
  }

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
