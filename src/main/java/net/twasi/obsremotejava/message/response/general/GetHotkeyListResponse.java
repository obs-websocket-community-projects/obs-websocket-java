package net.twasi.obsremotejava.message.response.general;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetHotkeyListResponse extends RequestResponse {
    private Data responseData;

    public GetHotkeyListResponse() {
        super(Request.Type.GetHotkeyList);
    }

    @Getter
    @ToString
    public static class Data {
        private List<String> hotkeys;
    }
}
