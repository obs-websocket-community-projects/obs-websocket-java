package net.twasi.obsremotejava.message.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import net.twasi.obsremotejava.message.Message;

@Getter
public class Hello extends Message {
//    static {
//        Message.registerMessageType(Type.Hello, Hello.class);
//    }

    private String obsWebSocketVersion;
    private Authentication authentication;
    private int rpcVersion;

    @Builder
    public Hello(String obsWebSocketVersion,
      Authentication authentication, int rpcVersion) {
        super(Type.Hello);
        this.obsWebSocketVersion = obsWebSocketVersion;
        this.authentication = authentication;
        this.rpcVersion = rpcVersion;
    }

//    public Hello() {
//        super(Type.Hello);
//    }

    public boolean isAuthenticationRequired() {
        return this.authentication != null;
    }

    @AllArgsConstructor
    @Getter
    @Builder
    public static class Authentication {
        private String challenge;
        private String salt;
    }

}
