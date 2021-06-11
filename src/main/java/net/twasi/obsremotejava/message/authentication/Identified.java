package net.twasi.obsremotejava.message.authentication;

import net.twasi.obsremotejava.message.Message;

public class Identified extends Message {
    private Integer negotiatedRpcVersion;

    public Identified() {
        super(Type.Identified);
    }

    public Integer getNegotiatedRpcVersion() {
        return negotiatedRpcVersion;
    }
}
