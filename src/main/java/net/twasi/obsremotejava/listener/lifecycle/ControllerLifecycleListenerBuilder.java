package net.twasi.obsremotejava.listener.lifecycle;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.ObsCommunicatorBuilder;
import net.twasi.obsremotejava.ObsRemoteControllerBuilder;
import net.twasi.obsremotejava.listener.lifecycle.LifecycleListener.CodeReason;
import net.twasi.obsremotejava.listener.lifecycle.LifecycleListener.ReasonThrowable;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

public class ControllerLifecycleListenerBuilder {
  private final BiConsumer DEFAULT_BICONSUMER = (a, b) -> {};

  private final ObsRemoteControllerBuilder obsRemoteControllerBuilder;

  private BiConsumer<OBSRemoteController, Session> onConnectCallback = DEFAULT_BICONSUMER;
  private BiConsumer<OBSRemoteController, Hello> onHelloCallback = DEFAULT_BICONSUMER;
  private BiConsumer<OBSRemoteController, Identified> onIdentifiedCallback = DEFAULT_BICONSUMER;
  private BiConsumer<OBSRemoteController, CodeReason> onCloseCallback = DEFAULT_BICONSUMER;
  private BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback = DEFAULT_BICONSUMER;
  private boolean defaultLogging = true;

  public ControllerLifecycleListenerBuilder(
    ObsRemoteControllerBuilder obsRemoteControllerBuilder) {
    this.obsRemoteControllerBuilder = obsRemoteControllerBuilder;
  }

  public ControllerLifecycleListenerBuilder onConnect(BiConsumer<OBSRemoteController, Session> onConnectCallback) {
    this.onConnectCallback = onConnectCallback;
    return this;
  }

  public ControllerLifecycleListenerBuilder onHello(BiConsumer<OBSRemoteController, Hello> onHelloCallback) {
    this.onHelloCallback = onHelloCallback;
    return this;
  }

  public ControllerLifecycleListenerBuilder onIdentified(BiConsumer<OBSRemoteController, Identified> onIdentifiedCallback) {
    this.onIdentifiedCallback = onIdentifiedCallback;
    return this;
  }

  public ControllerLifecycleListenerBuilder onClose(BiConsumer<OBSRemoteController, CodeReason> onCloseCallback) {
    this.onCloseCallback = onCloseCallback;
    return this;
  }

  public ControllerLifecycleListenerBuilder onError(BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback) {
    this.onErrorCallback = onErrorCallback;
    return this;
  }

  public ControllerLifecycleListenerBuilder withDefaultLogging(boolean defaultLogging) {
    this.defaultLogging = defaultLogging;
    return this;
  }

  public ObsRemoteControllerBuilder and() {
    return obsRemoteControllerBuilder;
  }

  public CompositeLifecycleListener build() {
    List<LifecycleListener> listeners = new ArrayList<>();
    listeners.add(new DelegatingControllerLifecycleListener(
      onConnectCallback,
      onHelloCallback,
      onIdentifiedCallback,
      onCloseCallback,
      onErrorCallback
    ));
    if(defaultLogging) listeners.add(new LoggingLifecycleListener());
    return new CompositeLifecycleListener(listeners);
  }

}
