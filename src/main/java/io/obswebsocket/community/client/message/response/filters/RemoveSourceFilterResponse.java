package io.obswebsocket.community.client.message.response.filters;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class RemoveSourceFilterResponse extends RequestResponse {
    public RemoveSourceFilterResponse() {
        super(Request.Type.RemoveSourceFilter);
    }
}
