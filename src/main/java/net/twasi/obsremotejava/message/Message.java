package net.twasi.obsremotejava.message;

import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
public abstract class Message {
    public static HashMap<Type, Class<? extends Message>> MESSAGE_REGISTRY = new HashMap<>();

    protected Type messageType;

//    public Message(Type messageType) {
//        this.messageType = messageType;
//    }

//    public Type getMessageType() {
//        return this.messageType;
//    }

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

        private Class clazz;
        private Type(Class clazz) {
            this.clazz = clazz;
        }

        public Class getClazz() {
            return clazz;
        }
    }

    public static void registerMessageType(Type messageType, Class<? extends Message> clazz) {
        Message.MESSAGE_REGISTRY.put(messageType, clazz);
    }
}
