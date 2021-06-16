package net.twasi.obsremotejava;

import net.twasi.obsremotejava.listener.lifecycle.controller.ControllerLifecycleListenerBuilder;
import net.twasi.obsremotejava.message.event.Event.Category;
import org.eclipse.jetty.websocket.client.WebSocketClient;

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

  public ObsRemoteControllerBuilder eventSubscription(Category eventSubscription) {
    obsCommunicatorBuilder.eventSubscription(eventSubscription);
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
