package io.obswebsocket.community.client.message.event.vendors;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.event.vendors.VendorEventEvent.SpecificData;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class VendorEventEvent extends Event<SpecificData> {

  protected VendorEventEvent() {
    super(Intent.Vendors);
  }

  protected VendorEventEvent(SpecificData data) {
    super(Intent.Vendors, data);
  }

  @Getter
  @ToString
  @Builder(access = AccessLevel.PROTECTED)
  public static class SpecificData {

    private String vendorName;
    private String eventType;
    @Singular("dataEntry")
    private Map<String, Object> eventData;
  }
}
