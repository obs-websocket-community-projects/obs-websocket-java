package io.obswebsocket.community.client.message.response.filters;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Filter;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterResponse extends RequestResponse {
    private Filter responseData;

    public GetSourceFilterResponse() {
        super(Request.Type.GetSourceFilter);
    }
}
