package net.twasi.obsremotejava;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.twasi.obsremotejava.listener.lifecycle.ControllerLifecycleListenerBuilder;
import net.twasi.obsremotejava.listener.lifecycle.LifecycleListener.CodeReason;
import net.twasi.obsremotejava.listener.lifecycle.LifecycleListener.ReasonThrowable;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import net.twasi.obsremotejava.message.authentication.Identify;
import net.twasi.obsremotejava.message.event.Event.Category;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.WebSocketClient;

public class ObsRemoteControllerBuilder {

  private ControllerLifecycleListenerBuilder controllerLifecycleListenerBuilder = new ControllerLifecycleListenerBuilder(this);
  private ObsCommunicatorBuilder obsCommunicatorBuilder = new ObsCommunicatorBuilder(this);
  private WebSocketClient webSocketClient = WEBSOCKET_CLIENT();
  private String host = "localhost";
  private int port = 4444;
  private String password;
  private Category eventSubscription = ObsCommunicatorBuilder.DEFAULT_SUBSCRIPTION;
  private boolean autoConnect = false;

  private BiConsumer<OBSRemoteController, Session> onConnectCallback;
  private BiConsumer<OBSRemoteController, Hello> onHelloCallback;
  private BiConsumer<OBSRemoteController, Identified> onIdentifiedCallback;
  private BiConsumer<OBSRemoteController, CodeReason> onCloseCallback;
  private BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback;

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
      host,
      port,
      autoConnect
    );

  }

}
