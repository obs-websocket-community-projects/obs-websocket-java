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
  public static class Transform { // TODO: SceneItem.Transform https://github.com/obsproject/obs-websocket/blob/265899f76f88a5be74747308fff3d35347ce43c5/src/utils/Obs_ObjectHelper.cpp#L47
    private Integer sourceWidth;
    private Integer sourceHeight;

    private Integer positionX;
    private Integer positionY;

    private Integer rotation;

    private Float scaleX;
    private Float scaleY;

    private Integer width;
    private Integer height;

    private String alignment;

    private String boundsType;
    private String boundsAlignment;
    private Integer boundsWidth;
    private Integer boundsHeight;

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
