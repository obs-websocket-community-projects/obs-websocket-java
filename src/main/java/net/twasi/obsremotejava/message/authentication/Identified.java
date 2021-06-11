package net.twasi.obsremotejava.message.authentication;

import net.twasi.obsremotejava.message.MessageBase;

public class Identified extends MessageBase {
    private Integer negotiatedRpcVersion;

    public Identified() {
        super(Type.Identified);
    }

    public Integer getNegotiatedRpcVersion() {
        return negotiatedRpcVersion;
    }
}
