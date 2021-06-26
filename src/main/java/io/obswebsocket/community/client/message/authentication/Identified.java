package io.obswebsocket.community.client.message.authentication;

import io.obswebsocket.community.client.message.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Identified extends Message {
    private final Integer negotiatedRpcVersion;

    @Builder
    private Identified(Integer negotiatedRpcVersion) {
        super(Type.Identified);

        this.negotiatedRpcVersion = negotiatedRpcVersion;
    }
}
