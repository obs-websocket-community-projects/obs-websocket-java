package io.obswebsocket.community.client.message.authentication;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.Message;

@Getter
@ToString
public class Reidentify extends Message {
    private final Boolean ignoreInvalidMessages;
    private final Boolean ignoreNonFatalRequestChecks;
    private final Integer eventSubscriptions;

    @Builder
    private Reidentify(
            Boolean ignoreInvalidMessages,
            Boolean ignoreNonFatalRequestChecks,
            Integer eventSubscriptions
    ) {
        super(Type.Reidentify);

        this.ignoreInvalidMessages = ignoreInvalidMessages;
        this.ignoreNonFatalRequestChecks = ignoreNonFatalRequestChecks;
        this.eventSubscriptions = eventSubscriptions;
    }
}
