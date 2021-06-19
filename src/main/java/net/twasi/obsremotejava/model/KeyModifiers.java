package net.twasi.obsremotejava.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter(AccessLevel.PRIVATE)
@ToString
@NoArgsConstructor
public class KeyModifiers {
    private boolean shift;
    private boolean alt;
    private boolean control;
    private boolean command;

    public static KeyModifiers fromTypeList(List<KeyModifierType> modifierList) {
        KeyModifiers keyModifiers = new KeyModifiers();

        if (modifierList != null) {
            keyModifiers.setShift(modifierList.contains(KeyModifierType.SHIFT));
            keyModifiers.setAlt(modifierList.contains(KeyModifierType.ALT));
            keyModifiers.setControl(modifierList.contains(KeyModifierType.CONTROL));
            keyModifiers.setCommand(modifierList.contains(KeyModifierType.COMMAND));
        }

        return keyModifiers;
    }

    public enum KeyModifierType {
        SHIFT,
        ALT,
        CONTROL,
        COMMAND
    }
}
