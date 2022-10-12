package io.obswebsocket.community.client.message.event.general;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.event.general.VendorEvent.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class VendorEvent extends Event<Data> {
  protected VendorEvent() {
    super(Intent.Vendors);
  }

  @Getter
  static class Data  {
    private String vendorName;
    private String eventType;
    private JsonObject eventData;
  }
}
