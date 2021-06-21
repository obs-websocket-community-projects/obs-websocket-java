package net.twasi.obsremotejava.message.authentication;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.Message;

@Getter
@ToString
public class Identify extends Message {
    private final Integer rpcVersion;
    private final String authentication;
    private final Boolean ignoreInvalidMessages;
    private final Boolean ignoreNonFatalRequestChecks;
    private final Integer eventSubscriptions;

    @Builder
    private Identify(
            Integer rpcVersion,
            String authentication,
            Boolean ignoreInvalidMessages,
            Boolean ignoreNonFatalRequestChecks,
            Integer eventSubscriptions
    ) {
        super(Type.Identify);

        this.rpcVersion = rpcVersion;
        this.authentication = authentication;
        this.ignoreInvalidMessages = ignoreInvalidMessages;
        this.ignoreNonFatalRequestChecks = ignoreNonFatalRequestChecks;
        this.eventSubscriptions = eventSubscriptions;
    }
}
