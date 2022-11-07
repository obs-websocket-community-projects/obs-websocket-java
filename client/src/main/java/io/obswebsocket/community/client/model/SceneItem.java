package io.obswebsocket.community.client.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.translator.serialization.SceneItemTransformAlignmentSerialization;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SceneItem extends Source {

  private Integer sceneItemId;
  private Integer sceneItemIndex;
  private BlendMode sceneItemBlendMode;
  private Boolean sceneItemEnabled;
  private Boolean sceneItemLocked;
  private Transform sceneItemTransform;
  private Boolean isGroup;

  @Getter
  @Setter
  @ToString
  @Builder(toBuilder = true)
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

    private Alignment alignment;

    private String boundsType;
    private Integer boundsAlignment;
    private Float boundsWidth;
    private Float boundsHeight;

    private Integer cropLeft;
    private Integer cropRight;
    private Integer cropTop;
    private Integer cropBottom;

    @JsonAdapter(SceneItemTransformAlignmentSerialization.class)
    public enum Alignment {
      CENTER(0),
      CENTER_LEFT(1),
      CENTER_RIGHT(2),

      TOP_CENTER(4),
      TOP_LEFT(5),
      TOP_RIGHT(6),

      BOTTOM_CENTER(8),
      BOTTOM_LEFT(9),
      BOTTOM_RIGHT(10);

      private final int value;

      Alignment(int value) {
        this.value = value;
      }

      public int getValue() {
        return this.value;
      }
    }
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
