package io.obswebsocket.community.generator;

import com.google.gson.Gson;
import io.obswebsocket.community.generator.model.generated.Protocol;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeneratorMain {

  public static final String PROTOCOL_JSON = "https://raw.githubusercontent.com/obsproject/obs-websocket/master/docs/generated/protocol.json";
  public static final File target = new File(
      "./client/src/main/java/io/obswebsocket/community/client/message/");
  public static final String GENERATED_MSG = "This class is generated, do not edit!";
  private final Gson gson = new Gson();

  public static void main(String... args) throws Exception {
    new GeneratorMain().run();
  }

  private void run() throws IOException {
    Protocol protocol = readProtocol();
    Map<String, String> typeOverrides = readAdditionalTypes();
    new FieldNormalizer(protocol, typeOverrides).normalize();
    new RequestTypeGenerator(protocol).generate();
    new RequestGenerator(protocol).generate();
    new ResponseGenerator(protocol).generate();
    new OBSRemoteControllerBaseGenerator(protocol).generate();
  }

  private Map<String, String> readAdditionalTypes() {
    InputStream additionalTypes = GeneratorMain.class.getResourceAsStream("/additionaltypes.json");
    Objects.requireNonNull(additionalTypes, "Unable to find additionaltypes.json");
    return gson.fromJson(new InputStreamReader(additionalTypes), Map.class);
  }

  private Protocol readProtocol() throws IOException {
    URL url = new URL(PROTOCOL_JSON);
    return gson.fromJson(new InputStreamReader(url.openStream()), Protocol.class);
  }
}
