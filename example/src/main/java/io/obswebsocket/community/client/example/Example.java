package io.obswebsocket.community.client.example;

import static org.slf4j.LoggerFactory.getLogger;

import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.message.event.ui.StudioModeStateChangedEvent;
import io.obswebsocket.community.client.message.request.ui.GetStudioModeEnabledRequest;
import io.obswebsocket.community.client.message.response.ui.GetStudioModeEnabledResponse;
import org.slf4j.Logger;

public class Example {

  private static final Logger log = getLogger(Example.class);
  private final OBSRemoteController obsRemoteController;
  private boolean isReconnecting = false;

  public static void main(String[] args) {
    new Example();
  }

  private Example() {
    // Create OBSRemoteController through its builder
    this.obsRemoteController = OBSRemoteController.builder()
        .autoConnect(false)                       // Do not connect automatically
        .host("127.0.0.1")                        // Set the host
        .port(4455)                               // Set the port
        .password("53CR37")                       // Set the password
        .lifecycle()                              // Add some lifecycle callbacks
        .onReady(this::onReady)                   // Add onReady callback
        .and()                                    // Build the LifecycleListenerBuilder
        .registerEventListener(StudioModeStateChangedEvent.class,
            this::onStudioModeStateChanged)       // Register a StudioModeStateChangedEvent
        .build();                                 // Build the OBSRemoteController

    // Connect
    this.obsRemoteController.connect();
  }

  private void onReady() {
    if (!this.isReconnecting) {
      // First connection
      this.onFirstConnection();
    } else {
      // Second connection
      this.onSecondConnection();
    }
  }

  private void onFirstConnection() {
    // Send a blocking call (last parameter is a timeout instead of a callback)
    this.obsRemoteController.setStudioModeEnabled(true, 1000);

    // Send a request through a convenience method
    this.obsRemoteController.getSceneList(getSceneListResponse -> {
      if (getSceneListResponse.isSuccessful()) {
        // Print each Scene
        getSceneListResponse.getScenes().forEach(scene -> log.info("Scene: {}", scene));
      }

      this.obsRemoteController.setStudioModeEnabled(false, 1000);
      this.disconnectAndReconnect();
    });
  }

  private void onSecondConnection() {
    // Send a Request through specific Request builder
    this.obsRemoteController.sendRequest(GetStudioModeEnabledRequest.builder().build(),
        (GetStudioModeEnabledResponse requestResponse) -> {
          if (requestResponse.isSuccessful()) {
            if (requestResponse.getStudioModeEnabled()) {
              log.info("Studio mode enabled");
            } else {
              log.info("Studio mode not enabled");
            }
          }

          // Disconnect
          this.obsRemoteController.disconnect();
          this.obsRemoteController.stop();
        });
  }

  private void disconnectAndReconnect() {
    // Disconnect
    this.obsRemoteController.disconnect();

    // Set a flag
    this.isReconnecting = true;
    // Reconnect
    this.obsRemoteController.connect(); // onReady will be called another time
  }

  private void onStudioModeStateChanged(StudioModeStateChangedEvent studioModeStateChangedEvent) {
    log.info(
        "Studio Mode State Changed to: {}",
        studioModeStateChangedEvent.getStudioModeEnabled());
  }
}
