package net.twasi.obsremotejava.message.authentication;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.Message;

@Getter
@ToString
public class Identified extends Message {
//    static {
//        Message.registerMessageType(Type.Identified, Identified.class);
//    }

    private Integer negotiatedRpcVersion;

    @Builder
    public Identified(Integer negotiatedRpcVersion) {
        super(Type.Identified);
        this.negotiatedRpcVersion = negotiatedRpcVersion;
    }

    //    public Identified() {
//        super(Type.Identified);
//    }

}
