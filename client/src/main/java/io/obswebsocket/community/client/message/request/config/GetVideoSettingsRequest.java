package io.obswebsocket.community.client.message.request.config;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetVideoSettingsRequest extends Request {

  @SerializedName("d")
  private final Data data;

  @Builder
  private GetVideoSettingsRequest() {
    super(Data.Type.GetVideoSettings);

    this.data = Data.builder().requestId(this.getRequestId()).requestType(this.getRequestType())
        .build();
  }
}
