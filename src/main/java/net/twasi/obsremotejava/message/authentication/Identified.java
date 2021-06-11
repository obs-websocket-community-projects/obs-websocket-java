package net.twasi.obsremotejava.message.authentication;

import net.twasi.obsremotejava.message.Message;

public class Identified extends Message {
    static {
        Message.registerMessageType(Type.Identified, Identified.class);
    }

    private Integer negotiatedRpcVersion;

    public Identified() {
        super(Type.Identified);
    }

    public Integer getNegotiatedRpcVersion() {
        return negotiatedRpcVersion;
    }
}
