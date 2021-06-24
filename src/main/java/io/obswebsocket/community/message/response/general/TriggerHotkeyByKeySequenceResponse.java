package io.obswebsocket.community.message.response.general;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class TriggerHotkeyByKeySequenceResponse extends RequestResponse {
    public TriggerHotkeyByKeySequenceResponse() {
        super(Request.Type.TriggerHotkeyByKeySequence);
    }
}
