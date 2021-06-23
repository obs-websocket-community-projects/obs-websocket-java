package net.twasi.obsremotejava.message.response.filters;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class RemoveSourceFilterResponse extends RequestResponse {
    public RemoveSourceFilterResponse() {
        super(Request.Type.RemoveSourceFilter);
    }
}
