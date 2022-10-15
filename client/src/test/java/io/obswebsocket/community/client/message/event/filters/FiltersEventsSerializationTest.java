package io.obswebsocket.community.client.message.event.filters;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.event.AbstractEventSerializationTest;
import io.obswebsocket.community.client.model.Filter;
import org.junit.jupiter.api.Test;

public class FiltersEventsSerializationTest extends AbstractEventSerializationTest {

  private static final String TYPE = "filters";

  @Test
  void sourceFilterListReindexedEvent() {
    Filter filter = new Filter();
    filter.setFilterName("SomeName");
    filter.setFilterEnabled(true);
    filter.setFilterIndex(1);
    filter.setFilterKind("SomeKind");
    JsonObject settings = new JsonObject();
    settings.addProperty("string", "string");
    filter.setFilterSettings(settings);

    assertEventType(TYPE, new SourceFilterListReindexedEvent(
        SourceFilterListReindexedEvent.SpecificData.builder()
            .sourceName("SomeName")
            .filter(filter)
            .build()));
  }
}
