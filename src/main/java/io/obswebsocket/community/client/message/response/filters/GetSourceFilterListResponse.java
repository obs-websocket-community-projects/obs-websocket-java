package io.obswebsocket.community.client.message.response.filters;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Filter;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterListResponse extends RequestResponse {
    private Data responseData;

    public GetSourceFilterListResponse() {
        super(Request.Type.GetSourceFilterList);
    }

    @Getter
    @ToString
    public static class Data {
        private List<Filter> filters;
    }
}
