package io.obswebsocket.community.generator;

import io.obswebsocket.community.generator.model.generated.Protocol;
import io.obswebsocket.community.generator.model.generated.RequestField;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class FieldNormalizer {

  private final Protocol protocol;
  private final Map<String, String> typeOverrides;
  private final Set<String> allKeys = new HashSet<>();

  public void normalize() {
    allKeys.addAll(typeOverrides.keySet());
    protocol.getRequests().forEach(req -> {
      req.setCategory(req.getCategory().replace(" ", ""));
      req.setRequestFields(
          req.getRequestFields().stream().filter(rf -> normalize(req.getRequestType(), rf))
              .collect(Collectors.toList()));

      req.setResponseFields(
          req.getResponseFields().stream().filter(rf -> normalize(req.getRequestType(), rf))
              .collect(Collectors.toList()));
    });

    protocol.getEvents().forEach(event -> {
      event.setCategory(event.getCategory().replace(" ", ""));
      event.setDataFields(
          event.getDataFields().stream().filter(rf -> normalize(event.getEventType(), rf))
              .collect(Collectors.toList()));
    });

    if (!allKeys.isEmpty()) {
      log.warn("Unused type overrides: {}", allKeys);
    }
  }

  private boolean normalize(String msgType, RequestField rf) {
    if (rf.getValueName().contains(".")) {
      return false;
    }

    String overrideKey = msgType + "." + rf.getValueName();
    allKeys.remove(overrideKey);
    String type = typeOverrides.getOrDefault(overrideKey, rf.getValueType());
    rf.setValueType(type);

    if ("any".equalsIgnoreCase(rf.getValueType())) {
      rf.setValueType("JsonObject");
    }

    return true;
  }
}
