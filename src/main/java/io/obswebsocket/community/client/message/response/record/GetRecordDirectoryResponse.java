package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

import java.io.File;

@Getter
@ToString(callSuper = true)
public class GetRecordDirectoryResponse extends RequestResponse {
    private Data responseData;

    public GetRecordDirectoryResponse() {
        super(Request.Type.GetRecordDirectory);
    }

    @Getter
    @ToString
    public static class Data {
        private File recordDirectory;
    }
}
