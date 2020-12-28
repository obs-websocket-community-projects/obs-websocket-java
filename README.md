
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
    <version>1.0.5</version>
</dependency>
```

To get started just instantiate the OBSRemoteController:

```java
OBSRemoteController controller = new OBSRemoteController("ws://localhost:4444", false);

if (controller.isFailed()) { // Awaits response from OBS
  // Here you can handle a failed connection request
}
// Now you can start making requests
```

If you don't want your program to wait for a connection you could alternatively register an onConnect callback:

```java
controller.registerConnectCallback(response -> {
	GetVersionResponse version = (GetVersionResponse) response;
	log.debug(version.getObsStudioVersion());

	// Other requests...
});
```

#### Websocket server with authentication

If your OBS websocket server is secured with a password, pass the password as a string to the controller:
```java
OBSRemoteController controller = new OBSRemoteController("ws://localhost:4444", false, "myPassword");
```

Catch any authentication errors by registering a callback for this:
```java
controller.registerConnectionFailedCallback(message -> {
    log.error("Failed to connect: " + message);
})
```

---
## Supported requests and events 

A list of supported requests and events can be found in the corresponding enum class files:
- [RequestType class file](src/main/java/net/twasi/obsremotejava/requests/RequestType.java)
- [EventType class file](src/main/java/net/twasi/obsremotejava/events/EventType.java)

A description of every request and event can be found in the plugin's [**Protocol.MD**](https://github.com/Palakis/obs-websocket/blob/4.x-current/docs/generated/protocol.md) file.

---
## Examples

Examples can be found [**here**](src/test/java/net/twasi/obsremotejava/test/OBSRemoteControllerTest.java). Just uncomment the requests you want to test or copy.

---

## Logging
This project ships with SLF4J, and uses the SLF4J-Simple binding by default so logs are printed directly to the console. 

If you wish to override this, for example with Logback, you must exclude SLF4J in your POM and add the dependency to the
binding you want (depends on the vendor)
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

---
**Thanks to Palakis for the great plugin!**
