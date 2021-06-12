package net.twasi.obsremotejava.message.response.general;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

import java.util.List;

@Getter
@ToString
public class GetVersion extends RequestResponse {
    private Data responseData;

    public GetVersion() {
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
