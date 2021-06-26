package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetHotkeyListRequest extends Request {
    @Builder
    private GetHotkeyListRequest() {
        super(Type.GetHotkeyList);
    }
}
