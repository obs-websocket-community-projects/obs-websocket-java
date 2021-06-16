package net.twasi.obsremotejava.message.request.config;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetProfileListRequest extends Request {
    public GetProfileListRequest() {
        super(Type.GetProfileList);
    }
}
