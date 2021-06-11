package net.twasi.obsremotejava.message.authentication;

import net.twasi.obsremotejava.message.Message;

public class Hello extends Message {
    static {
        Message.registerMessageType(Type.Hello, Hello.class);
    }

    private String websocketVersion;
    private Authentication authentication;

    public Hello() {
        super(Type.Hello);
    }

    public String getWebsocketVersion() {
        return this.websocketVersion;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public boolean isAuthenticationRequired() {
        return this.authentication != null;
    }

    public static class Authentication {
        private String challenge;
        private String salt;

        public String getChallenge() {
            return this.challenge;
        }

        public String getSalt() {
            return this.salt;
        }
    }
}
