package net.twasi.obsremotejava.message.authentication;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.Message;

@Getter
@ToString
public class Identify extends Message {
    private Integer rpcVersion;
    private String authentication;
    private Boolean ignoreInvalidMessages;
    private Boolean ignoreNonFatalRequestChecks;
    private Integer eventSubscriptions;

    @Builder
    public Identify(Integer rpcVersion, String authentication,
      Boolean ignoreInvalidMessages, Boolean ignoreNonFatalRequestChecks,
      Integer eventSubscriptions) {
        super(Type.Identify);
        this.rpcVersion = rpcVersion;
        this.authentication = authentication;
        this.ignoreInvalidMessages = ignoreInvalidMessages;
        this.ignoreNonFatalRequestChecks = ignoreNonFatalRequestChecks;
        this.eventSubscriptions = eventSubscriptions;
    }
}
