package io.obswebsocket.community.client.example;

import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.message.event.general.StudioModeStateChangedEvent;
import io.obswebsocket.community.client.message.request.general.GetStudioModeEnabledRequest;

public class Example {

  private final OBSRemoteController obsRemoteController;
  private boolean isReconnect = false;

  public static void main(String[] args) {
    new Example();
  }

  private Example() {
    // Create OBSRemoteController through its builder
    this.obsRemoteController = OBSRemoteController.builder()
        .autoConnect(false)                       // Do not connect automatically
        .host("127.0.0.1")                        // Set the host
        .port(4444)                               // Set the port
        .password("53CR37")                       // Set the password
        .lifecycle()                              // Add some lifecycle callbacks
          .onReady(this::onReady)                 // Add onReady callback
          .and()                                  // Build the LifecycleListenerBuilder
        .registerEventListener(StudioModeStateChangedEvent.class, this::onStudioModeStateChanged) // Register a StudioModeStateChangedEvent
        .build();                                 // Build the OBSRemoteController

    // Connect
    this.obsRemoteController.connect();
  }

  private void onStudioModeStateChanged(StudioModeStateChangedEvent studioModeStateChangedEvent) {
    System.out.printf(
        "Studio Mode State Changed to: %B%n", studioModeStateChangedEvent.getEventData().getStudioModeEnabled());
  }

  private void onReady() {
    if (!this.isReconnect) {
      // First connection

      // Send a request through a convenience method
      this.obsRemoteController.getSceneList(System.out::println);

      // Disconnect
      this.obsRemoteController.disconnect();

      // Set a flag
      this.isReconnect = true;
      // Reconnect
      this.obsRemoteController.connect(); // onReady will be called another time
    }
    else {
      // Second connection

      // Send a Request through  specific Request builder
      this.obsRemoteController.sendRequest(GetStudioModeEnabledRequest.builder().build(), System.out::println);

      // Disconnect
      this.obsRemoteController.disconnect();
    }
  }
}
