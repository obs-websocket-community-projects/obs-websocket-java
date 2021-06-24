package io.obswebsocket.community.message.event.inputs;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputCreatedEvent extends InputEvent {
    private Data eventData;

    protected InputCreatedEvent() {
        super(Type.InputCreated, Category.Inputs);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends InputEvent.Data {
        private String inputKind;
        private JsonObject inputSettings;
        private JsonObject defaultInputSettings;
    }
}
