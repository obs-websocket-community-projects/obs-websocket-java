package io.obswebsocket.community.client;

import io.obswebsocket.community.client.listener.lifecycle.LifecycleListenerBuilderFacade;
import io.obswebsocket.community.client.listener.lifecycle.controller.ControllerLifecycleListenerBuilder;
import io.obswebsocket.community.client.message.event.Event;
import java.util.function.Consumer;
import org.eclipse.jetty.websocket.client.WebSocketClient;

/**
 * The internal builder for creating ${@link OBSRemoteController} instances.
 */
public class OBSRemoteControllerBuilder {

  private ControllerLifecycleListenerBuilder controllerLifecycleListenerBuilder = new ControllerLifecycleListenerBuilder(this);
  private OBSCommunicatorBuilder obsCommunicatorBuilder = new OBSCommunicatorBuilder();
  private LifecycleListenerBuilderFacade lifecycleListenerBuilderFacade = new LifecycleListenerBuilderFacade(
    this,
    obsCommunicatorBuilder.lifecycle(),
    controllerLifecycleListenerBuilder
  );
  private OBSCommunicator communicator;

  private WebSocketClient webSocketClient = WEBSOCKET_CLIENT();
  private String host = "localhost";
  private int port = 4444;
  private int connectionTimeoutSeconds = 3;
  private boolean autoConnect = false;

  public static WebSocketClient WEBSOCKET_CLIENT() {
    return new WebSocketClient();
  }

  public OBSRemoteControllerBuilder host(String host) {
    this.host = host;
    return this;
  }

  public OBSRemoteControllerBuilder port(int port) {
    this.port = port;
    return this;
  }

  public OBSRemoteControllerBuilder password(String password) {
    obsCommunicatorBuilder.password(password);
    return this;
  }

  public <T extends Event> OBSRemoteControllerBuilder registerEventListener(Class<T> eventClass,
      Consumer<T> listener) {
    this.obsCommunicatorBuilder.registerEventListener(eventClass, listener);
    return this;
  }

  public OBSRemoteControllerBuilder connectionTimeout(int seconds) {
    this.connectionTimeoutSeconds = seconds;
    return this;
  }

  public OBSRemoteControllerBuilder autoConnect(boolean autoConnect) {
    this.autoConnect = autoConnect;
    return this;
  }

  public LifecycleListenerBuilderFacade lifecycle() {
    return lifecycleListenerBuilderFacade;
  }

  public OBSRemoteControllerBuilder communicator(OBSCommunicator communicator) {
    this.communicator = communicator;
    return this;
  }

  public OBSRemoteController build() {

    return new OBSRemoteController(
        webSocketClient,
        communicator == null
            ? obsCommunicatorBuilder.build()
            : communicator,
        controllerLifecycleListenerBuilder.build(),
        host,
        port,
        connectionTimeoutSeconds,
        autoConnect
    );

  }

}
