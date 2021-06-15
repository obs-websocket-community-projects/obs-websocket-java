package net.twasi.obsremotejava.listener.lifecycle;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.ObsCommunicatorBuilder;
import net.twasi.obsremotejava.listener.lifecycle.LifecycleListener.CodeReason;
import net.twasi.obsremotejava.listener.lifecycle.LifecycleListener.ReasonThrowable;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

public class CommunicatorLifecycleListenerBuilder {
  private final Consumer DEFAULT_CONSUMER = obj -> {};
  private final BiConsumer DEFAULT_BICONSUMER = (a, b) -> {};

  private final ObsCommunicatorBuilder obsCommunicatorBuilder;

  private BiConsumer<OBSCommunicator, Session> onConnectCallback;
  private BiConsumer<OBSCommunicator, Hello> onHelloCallback;
  private BiConsumer<OBSCommunicator, Identified> onIdentifiedCallback;
  private BiConsumer<OBSCommunicator, CodeReason> onCloseCallback;
  private BiConsumer<OBSCommunicator, ReasonThrowable> onErrorCallback;
  private boolean defaultLogging = true;

  public CommunicatorLifecycleListenerBuilder(
    ObsCommunicatorBuilder obsCommunicatorBuilder) {
    this.obsCommunicatorBuilder = obsCommunicatorBuilder;
  }

  public CommunicatorLifecycleListenerBuilder onConnect(BiConsumer<OBSCommunicator, Session> onConnectCallback) {
    this.onConnectCallback = onConnectCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onHello(BiConsumer<OBSCommunicator, Hello> onHelloCallback) {
    this.onHelloCallback = onHelloCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onIdentified(BiConsumer<OBSCommunicator, Identified> onIdentifiedCallback) {
    this.onIdentifiedCallback = onIdentifiedCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onClose(BiConsumer<OBSCommunicator, CodeReason> onCloseCallback) {
    this.onCloseCallback = onCloseCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onError(BiConsumer<OBSCommunicator, ReasonThrowable> onErrorCallback) {
    this.onErrorCallback = onErrorCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder withDefaultLogging(boolean defaultLogging) {
    this.defaultLogging = defaultLogging;
    return this;
  }

  public ObsCommunicatorBuilder and() {
    return obsCommunicatorBuilder;
  }

  public CompositeLifecycleListener build() {
    List<LifecycleListener> listeners = new ArrayList<>();
    listeners.add(new DelegatingCommunicatorLifecycleListener(
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
