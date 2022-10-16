package io.obswebsocket.community.client.message.request.ui;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class OpenVideoMixProjectorRequest extends Request<OpenVideoMixProjectorRequest.Data> {

  @Builder
  private OpenVideoMixProjectorRequest(VideoMixType videoMixType, Integer monitorIndex,
      String projectorGeometry) {
    super(Request.Data.Type.OpenVideoMixProjector, Data.builder()
        .videoMixType(videoMixType)
        .monitorIndex(monitorIndex)
        .projectorGeometry(projectorGeometry)
        .build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final VideoMixType videoMixType;
    private final Integer monitorIndex;
    private final String projectorGeometry;
  }

  public enum VideoMixType {
    @SerializedName("OBS_WEBSOCKET_VIDEO_MIX_TYPE_PREVIEW")
    Preview,
    @SerializedName("OBS_WEBSOCKET_VIDEO_MIX_TYPE_PROGRAM")
    Program,
    @SerializedName("OBS_WEBSOCKET_VIDEO_MIX_TYPE_MULTIVIEW")
    Multiview
  }
}
