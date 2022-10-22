package io.obswebsocket.community.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.obswebsocket.community.generator.model.generated.Event;
import io.obswebsocket.community.generator.model.generated.Protocol;
import io.obswebsocket.community.generator.model.generated.Request;
import io.obswebsocket.community.generator.model.generated.RequestField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ProtocolNormalizerTest {

  @Test
  void normalize() {
    // Setup
    Protocol protocol = Protocol.builder()
        .request(
            Request.builder().category("some category").requestType("SomeType")
                .description("Description")
                .build())
        .request(Request.builder().category("category").requestType("ToReplaceType")
            .description("Description").build())
        .request(
            Request.builder().category("category").requestType("RequestFields")
                .description("Other description").requestFields(buildToChangeData()).build())
        .event(
            Event.builder().category("category").eventType("EventFields")
                .dataFields(buildToChangeData()).build()).build();

    Protocol protocolOverride = Protocol.builder()
        .request(
            Request.builder().category("category").requestType("ToReplaceType")
                .description("New description").build())
        .request(
            Request.builder().category("category").requestType("AddedType")
                .description("Added description").build()).build();

    Map<String, String> overrides = new HashMap<>();
    overrides.put("RequestFields.firstObject", "No");
    overrides.put("RequestFields.string", "No");
    overrides.put("RequestFields.secondObject", "No");
    overrides.put("EventFields.firstObject", "No");
    overrides.put("EventFields.string", "No");
    overrides.put("EventFields.secondObject", "No");

    // Test
    new ProtocolNormalizer(protocol, protocolOverride, overrides).normalize();

    // Verify
    List<RequestField> expectedRequestFields = buildReplacedChangeData();
    List<RequestField> expectedEventFields = buildReplacedChangeData();
    Protocol expectedProtocol = Protocol.builder()
        .request(
            Request.builder().category("somecategory").requestType("SomeType")
                .description("Description")
                .build())
        .request(Request.builder().category("category").requestType("ToReplaceType")
            .description("New description").build())
        .request(
            Request.builder().category("category").requestType("RequestFields")
                .description("Other description").requestFields(expectedRequestFields).build())
        .event(
            Event.builder().category("category").eventType("EventFields")
                .dataFields(expectedEventFields).build()).build();

    assertEquals(expectedProtocol.toString(), protocol.toString());
  }

  private List<RequestField> buildToChangeData() {
    return buildToChangeData("Object", "String", "Any", "Object");
  }

  private List<RequestField> buildReplacedChangeData() {
    return buildToChangeData("No", "No", "JsonObject", "No");
  }

  private List<RequestField> buildToChangeData(String notPresent, String string, String any,
      String toReplace) {
    List<RequestField> result = new ArrayList<>();
    result.add(RequestField.builder().valueType(notPresent).valueName("firstObject").build());
    result.add(RequestField.builder().valueType(string).valueName("string").build());
    result.add(RequestField.builder().valueType(any).valueName("any").build());
    result.add(RequestField.builder().valueType(toReplace).valueName("secondObject").build());
    return result;
  }
}
