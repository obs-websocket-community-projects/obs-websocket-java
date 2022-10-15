package io.obswebsocket.community.client.message.event.vendors;

import io.obswebsocket.community.client.message.event.AbstractEventSerializationTest;
import io.obswebsocket.community.client.message.event.vendors.VendorEventEvent.SpecificData;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class VendorsEventsSerializationTest extends AbstractEventSerializationTest {

  private static final String TYPE = "vendors";

  @Test
  void vendorEventEvent() {
    Map<String, Object> objectMap = new HashMap<>();
    objectMap.put("key", "value");

    assertEventType(TYPE, new VendorEventEvent(SpecificData.builder()
        .vendorName("SomeVendor")
        .eventType("SomeType")
        .dataEntry("boolean", true)
        .dataEntry("string", "String")
        .dataEntry("number", 123d)
        .dataEntry("object", objectMap)
        .dataEntry("array", Arrays.asList(1d, 2d, 3d))
        .build()));
  }
}
