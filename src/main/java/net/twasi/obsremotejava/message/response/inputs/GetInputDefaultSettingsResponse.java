package net.twasi.obsremotejava.message.response.inputs;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetInputDefaultSettingsResponse extends RequestResponse {
    private Data responseData;

    public GetInputDefaultSettingsResponse() {
        super(Request.Type.GetInputDefaultSettings);
    }

    @Getter
    @ToString
    public static class Data {
        private JsonObject defaultInputSettings;
    }
}
