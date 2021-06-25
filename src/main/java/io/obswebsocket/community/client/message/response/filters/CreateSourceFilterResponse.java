package io.obswebsocket.community.client.message.response.filters;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class CreateSourceFilterResponse extends RequestResponse {
    public CreateSourceFilterResponse() {
        super(Request.Type.CreateSourceFilter);
    }
}
