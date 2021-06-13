
# websocket-obs-java
### A java library for the [**OBS-Studio websocket plugin**](https://github.com/Palakis/obs-websocket) by [**Palakis**](https://github.com/Palakis).
---
## Getting started

First include the library in your project using Maven:

```xml
<!-- https://mvnrepository.com/artifact/net.twasi/obs-websocket-java -->
<dependency>
  <groupId>net.twasi</groupId>
  <artifactId>obs-websocket-java</artifactId>
  <version>2.0.0</version>
</dependency>
```

To get started just instantiate the OBSRemoteController:

```java
OBSRemoteController controller = OBSRemoteController.builder().build();

/* These are the default values when built with no arguments like above
OBSRemoteController controller = OBSRemoteController.builder()
  //.secured(false)                 // Palakis OBS Websockets does not support TLS; use a proxy if required for remote connections
  .host("localhost")                // host
  .port(4444)                       // port
  .password("yourpassword")         // connect with a password
  .autoConnect(true)                // will connect when built, otherwise call connect() manually.
  .eventSubscription(Category.All)  // v5 of Palakis OBS Websockets introduces subscription categories for event notifications
  .build();
*/
  
// Block until the controller is ready
if (controller.isFailed()) { // Awaits response from OBS
  // Here you can handle a failed connection request
}
// Now you can start making requests
controller.getVersion(res -> {
  log.info("Connected with version information: " + res);  
})
```

If you don't want to use a blocking operation, then you can register a callback on onIdentified (as
mirrored by the v5 protocol):
```java
controller.registerOnIdentified(identified -> {
	log.debug("Successfully connected and identified by OBS: " + identified);
	// Other requests...
});
```
OBS Websockets will respond to this client with an Identified response regardless if authentication
is required or not. See [OBSCommunicatorSecuredIT](src/integrationTest/java/net/twasi/obsremotejava/test/manual/OBSCommunicatorSecuredIT.java)
for detailed examples.

Note that this is a change from <2.X.X, where onConnect was used instead. This was replaced because
it conflated network reachability with authentication, and was not compatible with the v5 OBS Websocket
API. You can still use onConnect, however it only denotes that OBS could be reached over the network:
```java
controller.registerOnConnect(session -> {
  log.info("Connected to OBS at: " + session.getRemoteAddress());
});
```
After connecting, you would expect OBS Websockets to send a `Hello` response:
```java
controller.registerOnHello(hello -> {
  log.debug(String.format(
    "Negotiated Rpc version %s. Authentication is required: %s",
    hello.getRpcVersion(),
    hello.isAuthenticationRequired()
  ));
})
```
After a `Hello` is received, the client will send an `Identify` request (containing the authentication
response if required) to OBS Websockets. If accepted by OBS Websockets, then it will respond with 
an `Identified`response like shown earlier. See the protocol at 
[Palakis OBS Websockets 5 Protocol](https://github.com/Palakis/obs-websocket/blob/master/docs/generated/protocol.md) 
for more detailed information.

#### Websocket server with authentication

If your OBS websocket server is secured with a password, pass the password as a string to the controller:
```java
OBSRemoteController controller = ObsRemoteController.builder().password("yourpassword").build();
```

Catch any authentication errors by registering a callback for a closed connection; in v5, OBS Websockets
closes the connection with an error code and human-readable reason when a password is not provided 
or is incorrect.
```java
controller.onClose((code, reason) -> {
    log.error("Failed to connect: " + code + " - " + reason);
})
```

---
## Supported requests and events 
// TODO Update once v5 is completed

A list of supported requests and events can be found in the corresponding enum class files:
- [Request.Type class file](src/main/java/net/twasi/obsremotejava/message/request/Request.java)
- [Event.Type class file](src/main/java/net/twasi/obsremotejava/message/event/Event.java)

A description of every request and event can be found in the plugin's [**Protocol.MD**](https://github.com/Palakis/obs-websocket/blob/4.x-current/docs/generated/protocol.md) file.

---
## Examples

Examples can be found [**here**](src/test/java/net/twasi/obsremotejava/test/OBSRemoteControllerTest.java). Just uncomment the requests you want to test or copy.

---

## Logging
This project ships with SLF4J as the logging facade, and uses SLF4J-Simple as the logging implementation
by default (logs are printed directly to the console).

As with any project using SLF4J, you are free to use a different SLF4J logger implementation. There
are many examples of how to do this online; for your convenience we demonstrate below how to 
configure Maven to use Logback instead:
```
<dependencies>
    <dependency>
        <groupId>net.twasi</groupId>
        <artifactId>obs-websocket-java</artifactId>
        <version>1.0.6-tinatiel-1-0-0</version>
        <!-- Exclude the default logging implementation -->
        <exclusions>
            <exclusion>
                <groupId>org.slf4j</groupId>
                <artifactId>slf4j-simple</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    
    <!-- Add your desired logging implementation -->
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.1.7</version>
    </dependency>
</dependencies>
```

## Contributing / Issues

If you want to contribute on this project, we ask you:
 1) File a GitHub Issue to track it, and
 2) Consider forking and making a pull-request.

Any help would be appreciated! Please see [CONTRIBUTING](CONTRIBUTING.md) for more information.

---

**Thanks to Palakis for the great plugin!**
