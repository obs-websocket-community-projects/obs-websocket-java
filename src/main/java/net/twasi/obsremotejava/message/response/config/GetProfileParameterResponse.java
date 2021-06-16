package net.twasi.obsremotejava.message.response.config;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetProfileParameterResponse extends RequestResponse {
    private Data responseData;

    public GetProfileParameterResponse() {
        super(Request.Type.GetProfileParameter);
    }

    @Getter
    @ToString
    public static class Data {
        private String parameterValue;
        private String defaultParameterValue;
    }
}
