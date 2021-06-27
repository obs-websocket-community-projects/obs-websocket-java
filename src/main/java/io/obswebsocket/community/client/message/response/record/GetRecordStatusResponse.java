package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetRecordStatusResponse extends RequestResponse {
    private Data responseData;

    public GetRecordStatusResponse() {
        super(Request.Type.GetRecordStatus);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean outputActive;
        private Boolean outputPaused;
        private Long outputTimecode;
        private Long outputDuration;
    }
}
