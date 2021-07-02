package io.obswebsocket.community.client.example;

import io.obswebsocket.community.client.OBSRemoteController;

public class Example {

  private final OBSRemoteController obsRemoteController;

  public static void main(String[] args) {
    new Example();
  }

  private Example() {
    this.obsRemoteController = OBSRemoteController.builder()
        .autoConnect(false)
        .host("127.0.0.1")
        .port(4444)
        .lifecycle()
          .onReady(this::getSceneList)
          .and()
        .build();

    this.obsRemoteController.connect();
  }

  private void getSceneList(OBSRemoteController obsRemoteController) {
    this.obsRemoteController.getSceneList(System.out::println);

    this.obsRemoteController.disconnect();
  }
}
