package io.obswebsocket.community.client.message.event.general;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class VendorEvent extends Event<VendorEvent.Data> {

  protected VendorEvent() {
    super(Intent.Vendors);
  }

  @Getter
  @ToString
  public static class Data {

    private String vendorName;
    private String eventType;
    private JsonObject eventData;
  }
}
