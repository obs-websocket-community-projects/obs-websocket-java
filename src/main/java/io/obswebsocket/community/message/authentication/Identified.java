package io.obswebsocket.community.message.authentication;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.Message;

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
