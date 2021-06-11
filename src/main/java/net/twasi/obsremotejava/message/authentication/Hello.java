package net.twasi.obsremotejava.message.authentication;

import net.twasi.obsremotejava.message.Message;

public class Hello extends Message {
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
            return challenge;
        }

        public String getSalt() {
            return salt;
        }
    }
}
