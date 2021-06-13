package net.twasi.obsremotejava.message.response.general;

import java.util.List;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString
public class GetVersionResponse extends RequestResponse {
    private Data responseData;

    public GetVersionResponse() {
        super(Request.Type.GetVersion);
    }

    @Getter
    @ToString
    public static class Data {
        private Integer rpcVersion;
        private String obsWebSocketVersion;
        private String obsVersion;
        private List<String> availableRequests;
        private List<String> supportedImageFormats;
    }
}
