package net.twasi.obsremotejava.message.request.general;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class TriggerHotkeyByKeySequenceRequest extends Request {
    private final Data requestData;

    public TriggerHotkeyByKeySequenceRequest(String keyId, List<String> keyModifiers) {
        super(Type.TriggerHotkeyByName);

        this.requestData = Data.builder().keyId(keyId).keyModifiers(keyModifiers).build();
    }

    @Getter
    @ToString
    @Builder
    public static class Data {
        private final String keyId;
        private final List<String> keyModifiers;
    }
}
