package net.twasi.obsremotejava.message.authentication;

import net.twasi.obsremotejava.message.Message;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Identify extends Message {
    private Integer rpcVersion;
    private String authentication;
    private Boolean ignoreInvalidMessages;
    private Boolean ignoreNonFatalRequestChecks;
    private Integer eventSubscriptions;

    private Identify() {
        super(Type.Identify);
    }

    public enum EventSubscription {
        // Set subscriptions to 0 to disable all events
        None(0),
        // Receive events in the `General` category
        General(1 << 0),
        // Receive events in the `Config` category
        Config(1 << 1),
        // Receive events in the `Scenes` category
        Scenes(1 << 2),
        // Receive events in the `Inputs` category
        Inputs(1 << 3),
        // Receive events in the `Transitions` category
        Transitions(1 << 4),
        // Receive events in the `Filters` category
        Filters(1 << 5),
        // Receive events in the `Outputs` category
        Outputs(1 << 6),
        // Receive events in the `Scene Items` category
        SceneItems(1 << 7),
        // Receive events in the `MediaInputs` category
        MediaInputs(1 << 8),
        // Receive all event categories (default subscription setting)
        All(General.value | Config.value | Scenes.value | Inputs.value | Transitions.value | Filters.value | Outputs.value | SceneItems.value | MediaInputs.value),
        ;

        private final int value;

        EventSubscription(int value) {
            this.value = value;
        }
    }

    public static class Builder {
        private String authentication;
        private Boolean ignoreInvalidMessages;
        private Boolean ignoreNonFatalRequestChecks;
        private Integer eventSubscriptions;

        public Builder() {}

        public Builder authentication(String password, String salt, String challenge) throws NoSuchAlgorithmException {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            String secretString = password + salt;
            byte[] secretHash = digest.digest(secretString.getBytes(StandardCharsets.UTF_8));
            String encodedSecret = Base64.getEncoder().encodeToString(secretHash);

            String resultString = encodedSecret + challenge;
            byte[] resultHash = digest.digest(resultString.getBytes(StandardCharsets.UTF_8));
            this.authentication = Base64.getEncoder().encodeToString(resultHash);

            return this;
        }

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

        public Identify build() {
            Identify identify = new Identify();
            identify.rpcVersion = 1; // TODO: Move this to a constant maybe?
            identify.authentication = this.authentication;
            identify.ignoreInvalidMessages = this.ignoreInvalidMessages;
            identify.ignoreNonFatalRequestChecks = this.ignoreNonFatalRequestChecks;
            identify.eventSubscriptions = this.eventSubscriptions;

            return identify;
        }
    }
}
