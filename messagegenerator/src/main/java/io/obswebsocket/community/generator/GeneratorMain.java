package io.obswebsocket.community.generator;

import com.google.gson.Gson;
import io.obswebsocket.community.generator.model.TypeOverride;
import io.obswebsocket.community.generator.model.generated.Protocol;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeneratorMain {

  public static final String PROTOCOL_JSON = "https://raw.githubusercontent.com/obsproject/obs-websocket/master/docs/generated/protocol.json";
  public static final File target = new File("./client/src/main/java/io/obswebsocket/community/client/message/");
  private final Gson gson = new Gson();

  public static void main(String... args) throws Exception {
    new GeneratorMain().run();
  }

  private void run() throws IOException {
    Protocol protocol = readProtocol();
    Map<String, String> typeOverrides = readAdditionalTypes();
    new FieldNormalizer(protocol, typeOverrides).normalize();

    new RequestGenerator(protocol).generate();
  }

  private Map<String, String> readAdditionalTypes() {
    InputStream additionalTypes = GeneratorMain.class.getResourceAsStream("/additionaltypes.json");
    Objects.requireNonNull(additionalTypes, "Unable to find additionaltypes.json");
    TypeOverride[] typeArr = gson.fromJson(new InputStreamReader(additionalTypes), TypeOverride[].class);

    return Stream.of(typeArr)
        .collect(Collectors.toMap(TypeOverride::getKey, TypeOverride::getType));
  }

  private Protocol readProtocol() throws IOException {
    URL url = new URL(PROTOCOL_JSON);
    return gson.fromJson(new InputStreamReader(url.openStream()), Protocol.class);
  }
}
