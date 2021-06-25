package io.obswebsocket.community.client.message.request.general;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetVersionRequest extends Request {
    @Builder
    private GetVersionRequest() {
        super(Type.GetVersion);
    }
}
