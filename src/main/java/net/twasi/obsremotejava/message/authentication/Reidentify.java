package net.twasi.obsremotejava.message.authentication;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.Message;

@Getter
@ToString
public class Reidentify extends Message {
    private final Boolean ignoreInvalidMessages;
    private final Boolean ignoreNonFatalRequestChecks;
    private final Integer eventSubscriptions;

    @Builder
    public Reidentify(Boolean ignoreInvalidMessages,
      Boolean ignoreNonFatalRequestChecks, Integer eventSubscriptions) {
        super(Type.Reidentify);
        this.ignoreInvalidMessages = ignoreInvalidMessages;
        this.ignoreNonFatalRequestChecks = ignoreNonFatalRequestChecks;
        this.eventSubscriptions = eventSubscriptions;
    }
}
