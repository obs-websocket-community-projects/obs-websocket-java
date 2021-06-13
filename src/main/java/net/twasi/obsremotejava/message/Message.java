package net.twasi.obsremotejava.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import net.twasi.obsremotejava.message.authentication.Identify;
import net.twasi.obsremotejava.message.authentication.Reidentify;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.request.RequestBatch;
import net.twasi.obsremotejava.message.response.RequestBatchResponse;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@AllArgsConstructor
@ToString
public abstract class Message {
    protected Type messageType;

    @Getter
    public enum Type {
        Hello(Hello.class),
        Identify(Identify.class),
        Identified(Identified.class),
        Reidentify(Reidentify.class),
        Request(Request.class),
        RequestResponse(RequestResponse.class),
        RequestBatch(RequestBatch.class),
        RequestBatchResponse(RequestBatchResponse.class),
        Event(Event.class);

        private final Class<? extends Message> messageClass;

        Type(Class<? extends Message> messageClass) {
            this.messageClass = messageClass;
        }
    }
}
