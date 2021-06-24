package io.obswebsocket.community;

import io.obswebsocket.community.authenticator.Authenticator;
import io.obswebsocket.community.authenticator.AuthenticatorImpl;
import io.obswebsocket.community.authenticator.NoOpAuthenticator;
import io.obswebsocket.community.listener.event.ObsEventListenerImpl;
import io.obswebsocket.community.listener.lifecycle.communicator.CommunicatorLifecycleListenerBuilder;
import io.obswebsocket.community.listener.request.ObsRequestListenerImpl;
import io.obswebsocket.community.message.event.Event;
import io.obswebsocket.community.translator.GsonMessageTranslator;
import io.obswebsocket.community.translator.MessageTranslator;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class ObsCommunicatorBuilder {
  private final static MessageTranslator TRANSLATOR;

  static {
    TRANSLATOR = new GsonMessageTranslator();
  }

  private ObsRemoteControllerBuilder obsRemoteControllerBuilder;
  private String password;
  private CommunicatorLifecycleListenerBuilder communicatorLifecycleListenerBuilder = new CommunicatorLifecycleListenerBuilder(this);
  private ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();

  public ObsCommunicatorBuilder() {
  }

  public ObsCommunicatorBuilder(
    ObsRemoteControllerBuilder obsRemoteControllerBuilder) {
    this.obsRemoteControllerBuilder = obsRemoteControllerBuilder;
  }

  public ObsCommunicatorBuilder password(String password) {
    this.password = password;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder lifecycle() {
    return communicatorLifecycleListenerBuilder;
  }

  public <T extends Event> ObsCommunicatorBuilder registerEventListener(Class<T> eventClass, Consumer<T> listener) {
    this.eventListeners.put(eventClass, listener);
    return this;
  }

  public ObsRemoteControllerBuilder and() {
    if(obsRemoteControllerBuilder != null) {
      return obsRemoteControllerBuilder;
    } else {
      throw new IllegalStateException("Trying to build Communicator directly, no RemoteControllerBuilder exists");
    }
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
      new ObsEventListenerImpl(eventListeners)
    );
  }

}
