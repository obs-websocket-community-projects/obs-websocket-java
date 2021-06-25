package io.obswebsocket.community.client;

import io.obswebsocket.community.client.listener.lifecycle.controller.ControllerLifecycleListenerBuilder;
import io.obswebsocket.community.client.message.event.Event;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.util.function.Consumer;

public class ObsRemoteControllerBuilder {

  private ControllerLifecycleListenerBuilder controllerLifecycleListenerBuilder = new ControllerLifecycleListenerBuilder(this);
  private ObsCommunicatorBuilder obsCommunicatorBuilder = new ObsCommunicatorBuilder(this);
  private WebSocketClient webSocketClient = WEBSOCKET_CLIENT();
  private String host = "localhost";
  private int port = 4444;
  private boolean autoConnect = false;

  public static WebSocketClient WEBSOCKET_CLIENT() {
    return new WebSocketClient();
  }

  public ObsRemoteControllerBuilder host(String host) {
    this.host = host;
    return this;
  }

  public ObsRemoteControllerBuilder port(int port) {
    this.port = port;
    return this;
  }

  public ObsRemoteControllerBuilder password(String password) {
    obsCommunicatorBuilder.password(password);
    return this;
  }

  public <T extends Event> ObsRemoteControllerBuilder registerEventListener(Class<T> eventClass, Consumer<T> listener) {
    this.obsCommunicatorBuilder.registerEventListener(eventClass, listener);
    return this;
  }

  public ObsRemoteControllerBuilder autoConnect(boolean autoConnect) {
    this.autoConnect = autoConnect;
    return this;
  }

  public ControllerLifecycleListenerBuilder lifecycle() {
    return controllerLifecycleListenerBuilder;
  }

  public ObsCommunicatorBuilder communicator() {
    return obsCommunicatorBuilder;
  }

  public OBSRemoteController build() {

    return new OBSRemoteController(
      webSocketClient,
      obsCommunicatorBuilder.build(),
      controllerLifecycleListenerBuilder.build(),
      host,
      port,
      autoConnect
    );

  }

}
