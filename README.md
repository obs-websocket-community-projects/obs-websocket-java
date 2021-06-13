
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
- [RequestType class file](src/main/java/net/twasi/obsremotejava/requests/RequestType.java)
- [EventType class file](src/main/java/net/twasi/obsremotejava/events/EventType.java)

A description of every request and event can be found in the plugin's [**Protocol.MD**](https://github.com/Palakis/obs-websocket/blob/4.x-current/docs/generated/protocol.md) file.

---
## Examples

Examples can be found [**here**](src/test/java/net/twasi/obsremotejava/test/OBSRemoteControllerTest.java). Just uncomment the requests you want to test or copy.

---

## Logging
This project ships with SLF4J as the logging facade, and uses SLF4J-Simple as the logging implementation
by default (logs are printed directly to the console).

As with any project using SLF4J, you are free to use a different SLF4J logger implementation. There
are many examples of how to do this; below, we show how to configure Maven to use Logback instead:
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

## Contribution

If you miss an endpoint feel free to make a pull request. Any help is appreciated.

### Building

If you've forked the repository and want to run the install goal to use your fork in your own project, please be aware
the artifacts generated require being signed via GPG. 

Once you've installed GPG and created a key-pair, you'll be prompted for your passphrase everytime you run the build. 
You can automate this by supplying `gpg.passphrase` property during the build, for example:

```
mvn verify -Dgpg.passphrase=YOURPASSPHRASE
```
   
In IntelliJ, you can supply the property via `File > Settings > Build, Execution, Deployment > Maven > Runner > Properties`.
Once the `gpg.passphrase` property has been set there, you won't be prompted everytime you run the build.

---
**Thanks to Palakis for the great plugin!**
