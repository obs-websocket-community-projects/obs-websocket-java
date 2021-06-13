package net.twasi.obsremotejava.message.response.general;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class BroadcastCustomEventResponse extends RequestResponse {
    public BroadcastCustomEventResponse() {
        super(Request.Type.BroadcastCustomEvent);
    }
}
