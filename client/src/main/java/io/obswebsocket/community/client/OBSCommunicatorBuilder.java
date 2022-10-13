package io.obswebsocket.community.client;

import io.obswebsocket.community.client.authenticator.Authenticator;
import io.obswebsocket.community.client.authenticator.AuthenticatorImpl;
import io.obswebsocket.community.client.authenticator.NoOpAuthenticator;
import io.obswebsocket.community.client.listener.event.OBSEventListenerImpl;
import io.obswebsocket.community.client.listener.lifecycle.communicator.CommunicatorLifecycleListenerBuilder;
import io.obswebsocket.community.client.listener.request.ObsRequestListenerImpl;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.translator.GsonMessageTranslator;
import io.obswebsocket.community.client.translator.MessageTranslator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * Internal builder for constructing instances of ${@link OBSCommunicator}.
 */
public class OBSCommunicatorBuilder {

  private final static MessageTranslator TRANSLATOR;

  static {
    TRANSLATOR = new GsonMessageTranslator();
  }

  private String password;
  private CommunicatorLifecycleListenerBuilder communicatorLifecycleListenerBuilder = new CommunicatorLifecycleListenerBuilder(this);
  private ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();

  public OBSCommunicatorBuilder() {
  }

  public OBSCommunicatorBuilder password(String password) {
    this.password = password;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder lifecycle() {
    return communicatorLifecycleListenerBuilder;
  }

  public <T extends Event> OBSCommunicatorBuilder registerEventListener(Class<T> eventClass,
      Consumer<T> listener) {
    this.eventListeners.put(eventClass, listener);
    return this;
  }

  public OBSCommunicator build() {
    // Build the authenticator
    Authenticator authenticator = password == null
        ? new NoOpAuthenticator()
        : new AuthenticatorImpl(password);

    // Build the communicator and return
    return new OBSCommunicator(
        TRANSLATOR,
        authenticator,
        communicatorLifecycleListenerBuilder.build(),
        new ObsRequestListenerImpl(),
        new OBSEventListenerImpl(eventListeners)
    );
  }

}
