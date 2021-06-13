package net.twasi.obsremotejava.message.response.general;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetStudioModeEnabledResponse extends RequestResponse {
    private Data responseData;

    public GetStudioModeEnabledResponse() {
        super(Request.Type.GetStudioModeEnabled);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean studioModeEnabled;
    }
}
