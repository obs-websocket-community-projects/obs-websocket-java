package net.twasi.obsremotejava.message.request.general;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class TriggerHotkeyByNameRequest extends Request {
    private final Data requestData;

    @Builder
    private TriggerHotkeyByNameRequest(String hotkeyName) {
        super(Type.TriggerHotkeyByName);

        this.requestData = Data.builder().hotkeyName(hotkeyName).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final String hotkeyName;
    }
}
