package io.obswebsocket.community.client.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetSpecialInputNamesRequest extends Request {
    @Builder
    private GetSpecialInputNamesRequest() {
        super(Type.GetSpecialInputNames);
    }
}
