package net.twasi.obsremotejava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.MessageDeserializer;
import net.twasi.obsremotejava.message.authentication.Authenticator;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.message.event.EventDeserializer;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.request.RequestDeserializer;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.message.response.RequestResponseDeserializer;

public class ObsCommunicatorBuilder {

  private String password;
  private Event.Category eventSubscription = DEFAULT_SUBSCRIPTION;

  public static Gson GSON() {
    return new GsonBuilder()
      .registerTypeAdapter(Message.class, new MessageDeserializer())
      .registerTypeAdapter(Event.class, new EventDeserializer())
      .registerTypeAdapter(Request.class, new RequestDeserializer())
      .registerTypeAdapter(RequestResponse.class, new RequestResponseDeserializer())
      .create();
  }

  public static Authenticator AUTHENTICATOR() {
    return new Authenticator();
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

  public OBSCommunicator build() {
    return new OBSCommunicator(
      GSON(),
      AUTHENTICATOR(),
      password,
      eventSubscription
    );
  }

}
