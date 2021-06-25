package io.obswebsocket.community.client.message.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.Message;

@ToString
@Getter
public class Hello extends Message {
    private final String obsWebSocketVersion;
    private final Authentication authentication;
    private final int rpcVersion;

    @Builder
    private Hello(
            String obsWebSocketVersion,
            Authentication authentication,
            int rpcVersion
    ) {
        super(Type.Hello);

        this.obsWebSocketVersion = obsWebSocketVersion;
        this.authentication = authentication;
        this.rpcVersion = rpcVersion;
    }

    public boolean isAuthenticationRequired() {
        return this.authentication != null;
    }

    @AllArgsConstructor
    @ToString
    @Getter
    @Builder
    public static class Authentication {
        private final String challenge;
        private final String salt;
    }
}
