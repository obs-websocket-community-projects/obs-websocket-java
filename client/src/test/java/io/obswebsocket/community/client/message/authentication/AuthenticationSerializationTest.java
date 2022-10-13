package io.obswebsocket.community.client.message.authentication;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class AuthenticationSerializationTest extends AbstractSerializationTest {

  @Test
  void hello() {
    String json = "{\n"
        + "  'op': 0,\n"
        + "  'd': {\n"
        + "    'obsWebSocketVersion': '5.0.0',\n"
        + "    'rpcVersion': 1,\n"
        + "    'authentication': {\n"
        + "      'challenge': '+IxH4CnCiqpX1rM9scsNynZzbOe4KhDeYcTNS3PDaeY=',\n"
        + "      'salt': 'lM1GncleQOaCu9lT1yeUZhFYnqhsLLP1G5lAGo3ixaI='\n"
        + "    }\n"
        + "  }\n"
        + "}";

    Hello obj = Hello.builder()
        .obsWebSocketVersion("5.0.0")
        .rpcVersion(1)
        .authentication(Hello.Data.Authentication.builder()
            .challenge("+IxH4CnCiqpX1rM9scsNynZzbOe4KhDeYcTNS3PDaeY=")
            .salt("lM1GncleQOaCu9lT1yeUZhFYnqhsLLP1G5lAGo3ixaI=")
            .build())
        .build();

    assertSerializationAndDeserialization(json, obj);

  }

  @Test
  void identify() {
    String json = "{\n"
        + "  'op': 1,\n"
        + "  'd': {\n"
        + "    'rpcVersion': 1,\n"
        + "    'authentication': 'Dj6cLS+jrNA0HpCArRg0Z/Fc+YHdt2FQfAvgD1mip6Y=',\n"
        + "    'ignoreInvalidMessages': true,\n"
        + "    'eventSubscriptions': 33\n"
        + "  }"
        + "}";

    Identify obj = Identify.builder()
        .rpcVersion(1)
        .authentication("Dj6cLS+jrNA0HpCArRg0Z/Fc+YHdt2FQfAvgD1mip6Y=")
        .ignoreInvalidMessages(true)
        .eventSubscriptions(33)
        .build();

    assertSerializationAndDeserialization(json, obj);
  }

  @Test
  void identified() {
    String json = "{\n"
        + "  'op': 2,\n"
        + "  'd': {\n"
        + "    'negotiatedRpcVersion': 1"
        + "  }"
        + "}";
    Identified obj = Identified.builder()
        .negotiatedRpcVersion(1)
        .build();

    assertSerializationAndDeserialization(json, obj);
  }

  @Test
  void reidentify() {
    String json = "{\n"
        + "  'op': 3,\n"
        + "  'd': {\n"
        + "    'ignoreInvalidMessages': true,\n"
        + "    'eventSubscriptions': 33\n"
        + "  }"
        + "}";
    Reidentify obj = Reidentify.builder()
        .ignoreInvalidMessages(true)
        .eventSubscriptions(33)
        .build();

    assertSerializationAndDeserialization(json, obj);
  }

}
