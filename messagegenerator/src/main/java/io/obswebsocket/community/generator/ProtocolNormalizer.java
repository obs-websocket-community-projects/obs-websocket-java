package io.obswebsocket.community.generator;

import io.obswebsocket.community.generator.model.generated.Event;
import io.obswebsocket.community.generator.model.generated.Protocol;
import io.obswebsocket.community.generator.model.generated.Request;
import io.obswebsocket.community.generator.model.generated.RequestField;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ProtocolNormalizer {

  private final Protocol protocol;
  private final Protocol protocolOverride;
  private final Map<String, String> typeOverrides;
  private final Set<String> allKeys = new HashSet<>();

  public void normalize() {
    overrideProtocol();

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

  private void overrideProtocol() {
    replaceType(Protocol::getRequests, Request::getRequestType);
    replaceType(Protocol::getEvents, Event::getEventType);
  }

  private <T> void replaceType(Function<Protocol, List<T>> getter, Function<T, Object> keyGetter) {
    List<T> overrideList = getter.apply(protocolOverride);
    List<T> protocolList = getter.apply(protocol);
    if (overrideList != null) {
      Map<T, T> toReplace = new HashMap<>();

      overrideList.forEach(override -> {
        protocolList.stream()
            .filter(r -> keyGetter.apply(r).equals(keyGetter.apply(override)))
            .findFirst().ifPresent(original -> toReplace.put(original, override));
      });

      for (Map.Entry<T, T> entry : toReplace.entrySet()) {
        int idx = protocolList.indexOf(entry.getKey());
        protocolList.set(idx, entry.getValue());
      }
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
