package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Projector;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetProjectorListResponse extends RequestResponse {
    private Data responseData;

    protected GetProjectorListResponse() {
        super(Request.Type.GetProjectorList);
    }

    @Getter
    @ToString
    public static class Data {
        private List<Projector> projectors;
    }
}
