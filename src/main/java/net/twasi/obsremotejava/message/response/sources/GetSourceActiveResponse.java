package net.twasi.obsremotejava.message.response.sources;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.model.Scene;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetSourceActiveResponse extends RequestResponse {
    private Data responseData;

    public GetSourceActiveResponse() {
        super(Request.Type.GetSourceActive);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean videoActive;
        private Boolean videoShowing;
    }
}
