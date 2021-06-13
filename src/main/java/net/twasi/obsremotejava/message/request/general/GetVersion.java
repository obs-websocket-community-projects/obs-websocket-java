package net.twasi.obsremotejava.message.request.general;

import net.twasi.obsremotejava.message.request.Request;

public class GetVersion extends Request {
    public GetVersion() {
        super(Type.GetVersion);
    }
}
