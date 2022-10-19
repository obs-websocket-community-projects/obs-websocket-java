package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class GetSceneCollectionListResponse extends RequestResponse<GetSceneCollectionListResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * The name of the current scene collection
     */
    @NonNull
    private String currentSceneCollectionName;

    /**
     * Array of all available scene collections
     */
    @NonNull
    @Singular
    private List<String> sceneCollections;
  }
}
