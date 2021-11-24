package io.obswebsocket.community.client.message.event.config;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class CurrentProfileChangedEvent extends Event {

  @SerializedName("d")
  private Data messageData;


  protected CurrentProfileChangedEvent() {
    super(Type.CurrentProfileChanged, Intent.Config);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData {

    private String currentProfileName;
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends Event.Data {

    protected SpecificData eventData;
  }
}
