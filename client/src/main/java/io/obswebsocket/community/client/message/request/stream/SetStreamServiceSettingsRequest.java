package io.obswebsocket.community.client.message.request.stream;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetStreamServiceSettingsRequest extends Request {

  private final Data requestData;

  @Builder
  private SetStreamServiceSettingsRequest(String streamServiceType, JsonObject serviceSettings) {
    super(Type.SetStreamServiceSettings);

    this.requestData = Data.builder().streamServiceType(streamServiceType).serviceSettings(serviceSettings).build();
  }

  @Getter
  @ToString
  @Builder
  public static class Data {

    @NonNull
    private final String streamServiceType;
    @NonNull
    private final JsonObject serviceSettings;
  }
}
