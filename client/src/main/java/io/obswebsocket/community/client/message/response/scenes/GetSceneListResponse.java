package io.obswebsocket.community.client.message.response.scenes;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Scene;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSceneListResponse extends RequestResponse {

  @SerializedName("d")
  private Data messageData;

  public GetSceneListResponse() {
    super(Request.Data.Type.GetSceneList);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends RequestResponse.Data {
    private SpecificData responseData;

    @AllArgsConstructor
    @Getter
    @ToString
    public static class SpecificData {
      private final String currentProgramSceneName;
      private final String currentPreviewSceneName;
      private final List<Scene> scenes;
    }
  }
}
