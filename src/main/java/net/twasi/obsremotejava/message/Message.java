package net.twasi.obsremotejava.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Message {
    protected Type messageType;

    public enum Type {
        Hello(net.twasi.obsremotejava.message.authentication.Hello.class),
        Identify(net.twasi.obsremotejava.message.authentication.Identify.class),
        Identified(net.twasi.obsremotejava.message.authentication.Identified.class),
        Reidentify(net.twasi.obsremotejava.message.authentication.Reidentify.class),
        Request(net.twasi.obsremotejava.message.request.Request.class),
        RequestResponse(net.twasi.obsremotejava.message.response.RequestResponse.class),
        RequestBatch(net.twasi.obsremotejava.message.request.RequestBatch.class),
        RequestBatchResponse(net.twasi.obsremotejava.message.response.RequestBatchResponse.class),
        Event(net.twasi.obsremotejava.message.event.Event.class);

        private final Class<? extends Message> clazz;

        Type(Class<? extends Message> clazz) {
            this.clazz = clazz;
        }

        public Class<? extends Message> getClazz() {
            return this.clazz;
        }
    }
}
