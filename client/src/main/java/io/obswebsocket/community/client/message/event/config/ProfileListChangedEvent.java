package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ProfileListChangedEvent extends Event<ProfileListChangedEvent.SpecificData> {

  protected ProfileListChangedEvent() {
    super(Intent.Config);
  }

  protected ProfileListChangedEvent(SpecificData data) {
    super(Intent.Config, data);
  }

  @Getter
  @ToString
  @Builder(access = AccessLevel.PROTECTED)
  public static class SpecificData {

    @Singular
    private List<String> profiles;
  }
}
