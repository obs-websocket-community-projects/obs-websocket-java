package io.obswebsocket.community.client.translator.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.obswebsocket.community.client.model.SceneItem.Transform.Alignment;
import java.lang.reflect.Type;
import java.util.Arrays;

public class SceneItemTransformAlignmentSerialization implements JsonDeserializer<Alignment>,
    JsonSerializer<Alignment> {

  @Override
  public Alignment deserialize(JsonElement jsonElement, Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {
    int rawAlignment = jsonElement.getAsInt();
    return Arrays.stream(Alignment.values())
        .filter(alignment -> alignment.getValue() == rawAlignment)
        .findFirst().orElse(null);
  }

  @Override
  public JsonElement serialize(Alignment src, Type typeOfSrc, JsonSerializationContext context) {
    return new JsonPrimitive(src.getValue());
  }
}
