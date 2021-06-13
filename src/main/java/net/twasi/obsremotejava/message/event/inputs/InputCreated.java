package net.twasi.obsremotejava.message.event.inputs;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputCreated extends Input {
    private Data eventData;

    protected InputCreated() {
        super(Type.InputCreated, Category.Inputs);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends Input.Data {
        private String inputKind;
        private JsonObject inputSettings;
        private JsonObject defaultInputSettings;
    }
}
