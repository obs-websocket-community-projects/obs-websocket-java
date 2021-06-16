package net.twasi.obsremotejava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CommunicatorLifecycleListenerBuilder;
import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.MessageSerialization;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.message.event.EventSerialization;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.request.RequestSerialization;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.message.response.RequestResponseSerialization;

public class ObsCommunicatorBuilder {

  private ObsRemoteControllerBuilder obsRemoteControllerBuilder;
  private String password;
  private Event.Category eventSubscription = DEFAULT_SUBSCRIPTION;
  private CommunicatorLifecycleListenerBuilder communicatorLifecycleListenerBuilder = new CommunicatorLifecycleListenerBuilder(this);

  public ObsCommunicatorBuilder() {
  }

  public ObsCommunicatorBuilder(
    ObsRemoteControllerBuilder obsRemoteControllerBuilder) {
    this.obsRemoteControllerBuilder = obsRemoteControllerBuilder;
  }

  public static Gson GSON() {
    return new GsonBuilder()
      .registerTypeAdapter(Message.class, new MessageSerialization())
      .registerTypeAdapter(Event.class, new EventSerialization())
      .registerTypeAdapter(Request.class, new RequestSerialization())
      .registerTypeAdapter(RequestResponse.class, new RequestResponseSerialization())
      .create();
  }

  public static Event.Category DEFAULT_SUBSCRIPTION = Event.Category.All;

  public ObsCommunicatorBuilder password(String password) {
    this.password = password;
    return this;
  }

  public ObsCommunicatorBuilder eventSubscription(Event.Category eventSubscription) {
    this.eventSubscription = eventSubscription;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder lifecycle() {
    return communicatorLifecycleListenerBuilder;
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
      eventSubscription,
      communicatorLifecycleListenerBuilder.build()
    );
  }

}
