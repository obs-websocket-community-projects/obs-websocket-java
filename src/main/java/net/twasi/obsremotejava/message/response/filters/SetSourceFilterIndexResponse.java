package net.twasi.obsremotejava.message.response.filters;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.model.Filter;

@Getter
@ToString(callSuper = true)
public class SetSourceFilterIndexResponse extends RequestResponse {
    public SetSourceFilterIndexResponse() {
        super(Request.Type.SetSourceFilterIndex);
    }
}
