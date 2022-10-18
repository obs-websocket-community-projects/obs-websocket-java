package io.obswebsocket.community.generator;

import io.obswebsocket.community.generator.model.generated.Protocol;
import io.obswebsocket.community.generator.model.generated.Request;
import io.obswebsocket.community.generator.model.generated.RequestField;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FieldNormalizer {

  private final Protocol protocol;
  private final Map<String, String> typeOverrides;

  public void normalize() {
    protocol.getRequests().forEach(req -> {
      req.setRequestFields(req.getRequestFields().stream().filter(rf -> normalize(req, rf))
          .collect(Collectors.toList()));

      req.setResponseFields(req.getResponseFields().stream().filter(rf -> normalize(req, rf))
          .collect(Collectors.toList()));
    });
  }

  private boolean normalize(Request request, RequestField rf) {
    if (rf.getValueName().contains(".")) {
      return false;
    }

    String overrideKey = request.getRequestType() + ":" + rf.getValueName();
    String type = typeOverrides.getOrDefault(overrideKey, rf.getValueType());
    rf.setValueType(type);

    if ("any".equalsIgnoreCase(rf.getValueType())) {
      rf.setValueType("JsonObject");
    }

    return true;
  }
}
