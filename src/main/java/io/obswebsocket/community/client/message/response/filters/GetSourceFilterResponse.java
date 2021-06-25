package io.obswebsocket.community.client.message.response.filters;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Filter;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterResponse extends RequestResponse {
    private Filter responseData;

    public GetSourceFilterResponse() {
        super(Request.Type.GetSourceFilter);
    }
}
