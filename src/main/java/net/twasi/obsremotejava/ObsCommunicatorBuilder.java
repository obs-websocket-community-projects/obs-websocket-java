package net.twasi.obsremotejava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.twasi.obsremotejava.authenticator.Authenticator;
import net.twasi.obsremotejava.authenticator.AuthenticatorImpl;
import net.twasi.obsremotejava.authenticator.NoOpAuthenticator;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CommunicatorLifecycleListenerBuilder;
import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.MessageSerialization;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.message.event.EventSerialization;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.request.RequestSerialization;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.message.response.RequestResponseSerialization;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class ObsCommunicatorBuilder {
  private final static Gson GSON;

  static {
    GSON = new GsonBuilder()
            .registerTypeAdapter(Message.class, new MessageSerialization())
            .registerTypeAdapter(Event.class, new EventSerialization())
            .registerTypeAdapter(Request.class, new RequestSerialization())
            .registerTypeAdapter(RequestResponse.class, new RequestResponseSerialization())
            .create();
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

  public static Gson GSON() {
    return GSON;
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
      GSON(),
      authenticator,
      communicatorLifecycleListenerBuilder.build(),
      eventListeners
    );
  }

}
