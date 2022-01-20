package io.obswebsocket.community.client.message.request.filters;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSourceFilterSettingsRequest extends FilterRequest {

  private final Data requestData;

  @Builder
  private SetSourceFilterSettingsRequest(String sourceName, String filterName,
      JsonObject filterSettings) {
    super(Request.Data.Type.SetSourceFilterSettings);

    this.requestData = Data.builder().sourceName(sourceName).filterName(filterName)
        .filterSettings(filterSettings).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends FilterRequest.Data {

    @NonNull
    private final String filterName;
    @NonNull
    private final JsonObject filterSettings;
  }
}
