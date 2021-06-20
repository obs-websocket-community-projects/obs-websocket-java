package net.twasi.obsremotejava.message.request.general;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class TriggerHotkeyByKeySequenceRequest extends Request {
    private final Data requestData;

    @Builder
    private TriggerHotkeyByKeySequenceRequest(String keyId, KeyModifiers keyModifiers) {
        super(Type.TriggerHotkeyByName);

        this.requestData = Data.builder().keyId(keyId).keyModifiers(keyModifiers).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        private final String keyId;
        private final KeyModifiers keyModifiers;
    }

    @Builder
    public static class KeyModifiers {
        private final boolean shift;
        private final boolean alt;
        private final boolean control;
        private final boolean command;
    }
}
