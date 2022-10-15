package io.obswebsocket.community.client.message.event.vendors;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.internal.LazilyParsedNumber;
import io.obswebsocket.community.client.message.event.AbstractEventSerializationTest;
import io.obswebsocket.community.client.message.event.vendors.VendorEventEvent.SpecificData;
import org.junit.jupiter.api.Test;

class VendorsEventsSerializationTest extends AbstractEventSerializationTest {

  private static final String TYPE = "vendors";

  @Test
  void vendorEventEvent() {
    JsonObject data = new JsonObject();
    data.addProperty("boolean", true);
    data.addProperty("string", "String");
    data.addProperty("number", new LazilyParsedNumber("123"));

    JsonObject objectData = new JsonObject();
    objectData.addProperty("key", "value");

    JsonArray arrayData = new JsonArray();
    arrayData.add("A");
    arrayData.add("B");
    arrayData.add(new LazilyParsedNumber("3"));

    data.add("object", objectData);
    data.add("array", arrayData);

    assertEventType(TYPE, new VendorEventEvent(SpecificData.builder()
        .vendorName("SomeVendor")
        .eventType("SomeType")
        .eventData(data)
        .build()));
  }
}
