package io.obswebsocket.community.client.message.response.mediainputs;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetMediaInputStatusResponse extends RequestResponse<GetMediaInputStatusResponse.Data> {
  public GetMediaInputStatusResponse() {
    super();
  }

  public enum MediaState {
    @SerializedName("none")
    NONE,
    @SerializedName("playing")
    PLAYING,
    @SerializedName("opening")
    OPENING,
    @SerializedName("buffering")
    BUFFERING,
    @SerializedName("paused")
    PAUSED,
    @SerializedName("stopped")
    STOPPED,
    @SerializedName("ended")
    ENDED,
    @SerializedName("error")
    ERROR,
    @SerializedName("unknown")
    UNKNOWN
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private MediaState mediaState;
    private Long mediaDuration; // optional
    private Long mediaTimestamp; // optional
  }
}
