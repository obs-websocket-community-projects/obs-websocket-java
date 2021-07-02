package io.obswebsocket.community.client.example;

import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.message.request.general.GetStudioModeEnabledRequest;

public class Example {

  private final OBSRemoteController obsRemoteController;
  private boolean isReconnect = false;

  public static void main(String[] args) {
    new Example();
  }

  private Example() {
    this.obsRemoteController = OBSRemoteController.builder()
        .autoConnect(false)
        .host("127.0.0.1")
        .port(4444)
        .password("53CR37")
        .lifecycle()
          .onReady(this::onReady)
          .and()
        .build();

    this.obsRemoteController.connect();
  }

  private void onReady() {
    if (!this.isReconnect) {
      this.obsRemoteController.getSceneList(System.out::println);

      this.obsRemoteController.disconnect();

      this.isReconnect = true;
      this.obsRemoteController.connect();
    }
    else {
      this.obsRemoteController.sendRequest(GetStudioModeEnabledRequest.builder().build(), System.out::println);

      this.obsRemoteController.disconnect();
    }
  }
}
