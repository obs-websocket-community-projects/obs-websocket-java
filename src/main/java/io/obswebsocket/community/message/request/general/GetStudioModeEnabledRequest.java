package io.obswebsocket.community.message.request.general;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetStudioModeEnabledRequest extends Request {
    @Builder
    private GetStudioModeEnabledRequest() {
        super(Type.GetStudioModeEnabled);
    }
}
