package io.obswebsocket.community.message.response.filters;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;
import io.obswebsocket.community.model.Filter;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterResponse extends RequestResponse {
    private Filter responseData;

    public GetSourceFilterResponse() {
        super(Request.Type.GetSourceFilter);
    }
}
