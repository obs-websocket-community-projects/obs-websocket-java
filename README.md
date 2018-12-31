
# websocket-obs-java
### A java library for the [**OBS-Studio websocket plugin**](https://github.com/Palakis/obs-websocket) by [**Palakis**](https://github.com/Palakis).
---
## Getting started

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
	System.out.println(version.getObsStudioVersion());

	// Other requests...
});
```
---
## Supported requests and events 

A list of supported requests and events can be found in the corresponding enum class files:
- [RequestType class file](src/main/java/net/diespendendose/obsremotejava/requests/RequestType.java)
- [EventType class file](src/main/java/net/diespendendose/obsremotejava/events/EventType.java)

A description of every request and event can be found in the plugin's [**Protocol.MD**](https://github.com/Palakis/obs-websocket/blob/4.x-current/docs/generated/protocol.md) file.

---
## Examples

Examples can be found [**here**](src/test/java/net/diespendendose/obsremotejava/test/OBSRemoteControllerTest.java). Just uncomment the requests you want to test or copy.

---
## Contribution

If you miss an endpoint feel free to make a pull request. Any help is appreciated.

---
**Thanks to Palakis for the great plugin!**
