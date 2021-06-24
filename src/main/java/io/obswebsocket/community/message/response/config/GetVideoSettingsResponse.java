package io.obswebsocket.community.message.response.config;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetVideoSettingsResponse extends RequestResponse {
    private Data responseData;

    public GetVideoSettingsResponse() {
        super(Request.Type.GetVideoSettings);
    }

    @Getter
    @ToString
    public static class Data {
        private Integer baseWidth;
        private Integer baseHeight;
        private Integer outputWidth;
        private Integer outputHeight;
        private Double fpsNum;
        private Double fpsDen;
    }
}
