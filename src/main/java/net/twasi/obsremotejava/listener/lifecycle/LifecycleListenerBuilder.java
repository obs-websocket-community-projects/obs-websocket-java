package net.twasi.obsremotejava.listener.lifecycle;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.ObsCommunicatorBuilder;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

public class LifecycleListenerBuilder {
  private final Consumer DEFAULT_CONSUMER = obj -> {};
  private final BiConsumer DEFAULT_BICONSUMER = (a, b) -> {};

  private final ObsCommunicatorBuilder obsCommunicatorBuilder;

  private Consumer<Session> onConnect = DEFAULT_CONSUMER;
  private Consumer<Hello> onHello = DEFAULT_CONSUMER;
  private BiConsumer<OBSCommunicator, Identified> onIdentified = DEFAULT_BICONSUMER;
  private BiConsumer<Integer, String> onClose = DEFAULT_BICONSUMER;
  private BiConsumer<String, Throwable> onError = DEFAULT_BICONSUMER;
  private boolean defaultLogging = true;

  public LifecycleListenerBuilder(
    ObsCommunicatorBuilder obsCommunicatorBuilder) {
    this.obsCommunicatorBuilder = obsCommunicatorBuilder;
  }

  public LifecycleListenerBuilder onConnect(Consumer<Session> onConnect) {
    this.onConnect = onConnect;
    return this;
  }

  public LifecycleListenerBuilder onHello(Consumer<Hello> onHello) {
    this.onHello = onHello;
    return this;
  }

  public LifecycleListenerBuilder onIdentified(BiConsumer<OBSCommunicator, Identified> onIdentified) {
    this.onIdentified = onIdentified;
    return this;
  }

  public LifecycleListenerBuilder onClose(BiConsumer<Integer, String> onClose) {
    this.onClose = onClose;
    return this;
  }

  public LifecycleListenerBuilder onError(BiConsumer<String, Throwable> onError) {
    this.onError = onError;
    return this;
  }

  public LifecycleListenerBuilder withDefaultLogging(boolean defaultLogging) {
    this.defaultLogging = defaultLogging;
    return this;
  }

  public ObsCommunicatorBuilder and() {
    return obsCommunicatorBuilder;
  }

  public CompositeLifecycleListener build() {
    List<LifecycleListener> listeners = new ArrayList<>();
    listeners.add(new DelegatingLifecycleListener(
      onConnect,
      onHello,
      onIdentified,
      onClose,
      onError
    ));
    if(defaultLogging) listeners.add(new LoggingLifecycleListener());
    return new CompositeLifecycleListener(listeners);
  }

}
