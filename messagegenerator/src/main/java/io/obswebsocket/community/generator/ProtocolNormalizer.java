package io.obswebsocket.community.generator;

import io.obswebsocket.community.generator.model.generated.Event;
import io.obswebsocket.community.generator.model.generated.Protocol;
import io.obswebsocket.community.generator.model.generated.Request;
import io.obswebsocket.community.generator.model.generated.RequestField;
import java.util.ArrayList;
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
    this.ensureMutable();
    this.overrideProtocol();

    this.allKeys.addAll(this.typeOverrides.keySet());
    this.protocol.getRequests().forEach(req -> {
      req.setCategory(req.getCategory().replace(" ", ""));
      req.setDescription(req.getDescription()
          .replace("\\u", "\\\\u")
          .replaceAll("<", "&lt;")
          .replaceAll(">", "&gt;"));
      req.setRequestFields(
          req.getRequestFields().stream().filter(rf -> this.normalize(req.getRequestType(), rf))
              .collect(Collectors.toList()));

      req.setResponseFields(
          req.getResponseFields().stream().filter(rf -> this.normalize(req.getRequestType(), rf))
              .collect(Collectors.toList()));
    });

    this.protocol.getEvents().forEach(event -> {
      event.setCategory(event.getCategory().replace(" ", ""));
      if (event.getDescription() != null) {
        event.setDescription(event.getDescription()
            .replace("\\u", "\\\\u")
            .replaceAll("<", "&lt;")
            .replaceAll(">", "&gt;"));
      }
      event.setDataFields(
          event.getDataFields().stream().filter(rf -> this.normalize(event.getEventType(), rf))
              .collect(Collectors.toList()));
    });

    if (!this.allKeys.isEmpty()) {
      log.warn("Unused type overrides: {}", this.allKeys);
    }
  }

  /**
   * Mostly for testing, but gson might decide to use immutable lists at some point too
   */
  private void ensureMutable() {
    this.protocol.setRequests(new ArrayList<>(this.protocol.getRequests()));
    this.protocol.setEvents(new ArrayList<>(this.protocol.getEvents()));
  }

  private void overrideProtocol() {
    this.replaceType(Protocol::getRequests, Request::getRequestType);
    this.replaceType(Protocol::getEvents, Event::getEventType);
  }

  private <T> void replaceType(Function<Protocol, List<T>> getter, Function<T, Object> keyGetter) {
    List<T> overrideList = getter.apply(this.protocolOverride);
    List<T> protocolList = getter.apply(this.protocol);
    if (overrideList != null) {
      Map<T, T> toReplace = new HashMap<>();

      overrideList.forEach(override ->
          protocolList.stream()
              .filter(r -> keyGetter.apply(r).equals(keyGetter.apply(override)))
              .findFirst().ifPresent(original -> toReplace.put(original, override)));

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
    this.allKeys.remove(overrideKey);
    String type = this.typeOverrides.getOrDefault(overrideKey, rf.getValueType());
    rf.setValueType(type);

    if ("any".equalsIgnoreCase(rf.getValueType())) {
      rf.setValueType("JsonObject");
    }

    if (rf.getValueDescription() != null) {
      rf.setValueDescription(rf.getValueDescription()
          .replace("\\u", "\\\\u")
          .replaceAll("<", "&lt;")
          .replaceAll(">", "&gt;"));
    }

    return true;
  }
}
