package io.obswebsocket.community.client.message.event.vendors;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import io.obswebsocket.community.client.message.event.vendors.VendorEventEvent.SpecificData;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class VendorsEventsSerializationTest extends AbstractSerializationTest {

  @Test
  void vendorEventEvent() {
    Map<String, Object> objectMap = new HashMap<>();
    objectMap.put("key", "value");

    VendorEventEvent streamStateChangedEvent = new VendorEventEvent(SpecificData.builder()
        .vendorName("SomeVendor")
        .eventType("SomeType")
        .dataEntry("boolean", true)
        .dataEntry("string", "String")
        .dataEntry("number", 123d)
        .dataEntry("object", objectMap)
        .dataEntry("array", Arrays.asList(1d, 2d, 3d))
        .build());

    String json = this.readResourceFile("events/vendors/VendorEvent.json");

    assertSerializationAndDeserialization(json, streamStateChangedEvent);
  }
}
