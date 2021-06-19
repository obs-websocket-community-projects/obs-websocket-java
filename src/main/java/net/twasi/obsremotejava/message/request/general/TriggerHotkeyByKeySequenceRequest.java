package net.twasi.obsremotejava.message.request.general;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.model.KeyModifiers;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class TriggerHotkeyByKeySequenceRequest extends Request {
    private final Data requestData;

    public TriggerHotkeyByKeySequenceRequest(String keyId, List<KeyModifiers.KeyModifierType> keyModifiers) {
        super(Type.TriggerHotkeyByName);

        this.requestData = Data.builder().keyId(keyId).keyModifiers(KeyModifiers.fromTypeList(keyModifiers)).build();
    }

    public TriggerHotkeyByKeySequenceRequest(String keyId) {
        this(keyId, null);
    }

    public TriggerHotkeyByKeySequenceRequest(List<KeyModifiers.KeyModifierType> keyModifiers) {
        this(null, keyModifiers);
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        private final String keyId;
        private final KeyModifiers keyModifiers;
    }
}
