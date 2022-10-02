package io.obswebsocket.community.client.example;

import java.util.List;
import java.util.stream.Collectors;

import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.message.event.general.StudioModeStateChangedEvent;
import io.obswebsocket.community.client.message.event.inputs.InputVolumeChangedEvent;
import io.obswebsocket.community.client.message.event.outputs.VirtualcamStateChangedEvent;
import io.obswebsocket.community.client.message.request.general.GetStudioModeEnabledRequest;
import io.obswebsocket.community.client.message.response.general.GetStudioModeEnabledResponse;
import io.obswebsocket.community.client.model.Scene;

public class Example {
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
                                                  .registerEventListener(StudioModeStateChangedEvent.class, this::onStudioModeStateChanged) // Register a StudioModeStateChangedEvent
                                                  .registerEventListener(VirtualcamStateChangedEvent.class, this::onVirtualCamStateChanged)
                                                  .registerEventListener(InputVolumeChangedEvent.class, this::onInputVolumeChanged)
                                                  .build();                                 // Build the OBSRemoteController

    // Connect
    this.obsRemoteController.connect();
  }

  private void onInputVolumeChanged(InputVolumeChangedEvent t) {
    System.out.println(t);
  }

  private void onVirtualCamStateChanged(VirtualcamStateChangedEvent t) {
    System.out.println(t);
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
    // Send a request through a convenience method
    this.obsRemoteController.getSceneList(getSceneListResponse -> {
      if (getSceneListResponse.isSuccessful()) {
        // Filter by isGroup
        List<Scene> groups = getSceneListResponse.getMessageData().getResponseData().getScenes()
                                                 .stream().filter(Scene::getIsGroup).collect(Collectors.toList());
        // Print each Scene
        groups.forEach(System.out::println);
      }

      this.disconnectAndReconnect();
    });
  }

  private void onSecondConnection() {
    // Send a Request through  specific Request builder
    this.obsRemoteController.sendRequest(GetStudioModeEnabledRequest.builder().build(), requestResponse -> {
      if (requestResponse.isSuccessful()) {
        GetStudioModeEnabledResponse getStudioModeEnabledResponse = (GetStudioModeEnabledResponse) requestResponse;
        if (getStudioModeEnabledResponse.getMessageData().getResponseData().getStudioModeEnabled()) {
          System.out.println("Studio mode enabled");
        } else {
          System.out.println("Studio mode not enabled");
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
    System.out.printf(
            "Studio Mode State Changed to: %B%n", studioModeStateChangedEvent.getMessageData().getEventData().getStudioModeEnabled());
  }
}
