package net.twasi.obsremotejava.message.request.general;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetVersionRequest extends Request {
    public GetVersionRequest() {
        super(Type.GetVersion);
    }
}
