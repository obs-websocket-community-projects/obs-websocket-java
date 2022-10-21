// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.category;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Input;
import io.obswebsocket.community.client.model.Scene;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * Description
 */
@Getter
@ToString(
    callSuper = true
)
public class TypeEvent extends Event<TypeEvent.SpecificData> {
  protected TypeEvent() {
    super(Intent.subscription);
  }

  protected TypeEvent(TypeEvent.SpecificData data) {
    super(Intent.subscription, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * stringField description
     */
    @NonNull
    private String stringField;

    /**
     * booleanField description
     */
    @NonNull
    private Boolean booleanField;

    /**
     * booleanList description
     */
    @NonNull
    private List<Boolean> booleanList;

    /**
     * stringList description
     */
    @NonNull
    private List<String> stringList;

    /**
     * audioTracks description
     */
    @NonNull
    private Input.AudioTracks audioTracks;

    /**
     * jsonObject description
     */
    @NonNull
    private JsonObject jsonObject;

    /**
     * sceneList description
     */
    @NonNull
    private List<Scene> sceneList;
  }
}
