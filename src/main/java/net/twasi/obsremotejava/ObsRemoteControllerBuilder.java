package net.twasi.obsremotejava;

import net.twasi.obsremotejava.message.event.Event.Category;
import org.eclipse.jetty.websocket.client.WebSocketClient;

public class ObsRemoteControllerBuilder {

  private WebSocketClient webSocketClient = WEBSOCKET_CLIENT();
  private String host = "localhost";
  private int port = 4444;
  private String password;
  private Category eventSubscription = ObsCommunicatorBuilder.DEFAULT_SUBSCRIPTION;
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
    this.password = password;
    return this;
  }

  public ObsRemoteControllerBuilder eventSubscription(Category eventSubscription) {
    this.eventSubscription = eventSubscription;
    return this;
  }

  public ObsRemoteControllerBuilder autoConnect(boolean autoConnect) {
    this.autoConnect = autoConnect;
    return this;
  }

  public OBSRemoteController build() {

    return new OBSRemoteController(
      webSocketClient,
      OBSCommunicator.builder()
        .eventSubscription(eventSubscription)
        .password(password)
        .build(),
      host,
      port,
      autoConnect
    );

  }

}
