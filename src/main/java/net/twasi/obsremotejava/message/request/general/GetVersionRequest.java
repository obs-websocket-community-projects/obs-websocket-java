package net.twasi.obsremotejava.message.request.general;

import net.twasi.obsremotejava.message.request.Request;

public class GetVersionRequest extends Request {
    public GetVersionRequest() {
        super(Type.GetVersion);
    }
}
