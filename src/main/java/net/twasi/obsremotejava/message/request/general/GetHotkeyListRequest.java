package net.twasi.obsremotejava.message.request.general;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetHotkeyListRequest extends Request {
    @Builder
    private GetHotkeyListRequest() {
        super(Type.GetHotkeyList);
    }
}
