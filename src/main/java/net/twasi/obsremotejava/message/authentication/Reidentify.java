package net.twasi.obsremotejava.message.authentication;

import net.twasi.obsremotejava.message.MessageBase;

public class Reidentify extends MessageBase {
    private Boolean ignoreInvalidMessages;
    private Boolean ignoreNonFatalRequestChecks;
    private Integer eventSubscriptions;

    private Reidentify() {
        super(Type.Reidentify);
    }


    public static class Builder {
        private Boolean ignoreInvalidMessages;
        private Boolean ignoreNonFatalRequestChecks;
        private Integer eventSubscriptions;

        public Builder() {}

        public Builder ignoreInvalidMessages(Boolean ignoreInvalidMessages) {
            this.ignoreInvalidMessages = ignoreInvalidMessages;

            return this;
        }

        public Builder ignoreNonFatalRequestChecks(Boolean ignoreNonFatalRequestChecks) {
            this.ignoreNonFatalRequestChecks = ignoreNonFatalRequestChecks;

            return this;
        }

        public Builder eventSubscriptions(Integer eventSubscriptions) {
            this.eventSubscriptions = eventSubscriptions;

            return this;
        }

        public Reidentify build() {
            Reidentify reidentify = new Reidentify();
            reidentify.ignoreInvalidMessages = this.ignoreInvalidMessages;
            reidentify.ignoreNonFatalRequestChecks = this.ignoreNonFatalRequestChecks;
            reidentify.eventSubscriptions = this.eventSubscriptions;

            return reidentify;
        }
    }
}
