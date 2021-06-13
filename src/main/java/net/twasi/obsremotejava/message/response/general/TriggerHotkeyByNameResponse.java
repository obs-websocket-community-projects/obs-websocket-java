package net.twasi.obsremotejava.message.response.general;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class TriggerHotkeyByNameResponse extends RequestResponse {
    public TriggerHotkeyByNameResponse() {
        super(Request.Type.TriggerHotkeyByName);
    }
}
