package io.obswebsocket.community.message;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public abstract class Message {
    protected Type messageType;

    @Getter
    public enum Type {
        Hello(io.obswebsocket.community.message.authentication.Hello.class),
        Identify(io.obswebsocket.community.message.authentication.Identify.class),
        Identified(io.obswebsocket.community.message.authentication.Identified.class),
        Reidentify(io.obswebsocket.community.message.authentication.Reidentify.class),
        Request(io.obswebsocket.community.message.request.Request.class),
        RequestResponse(io.obswebsocket.community.message.response.RequestResponse.class),
        RequestBatch(io.obswebsocket.community.message.request.RequestBatch.class),
        RequestBatchResponse(io.obswebsocket.community.message.response.RequestBatchResponse.class),
        Event(io.obswebsocket.community.message.event.Event.class);

        private final Class<? extends Message> messageClass;

        Type(Class<? extends Message> messageClass) {
            this.messageClass = messageClass;
        }
    }
}
