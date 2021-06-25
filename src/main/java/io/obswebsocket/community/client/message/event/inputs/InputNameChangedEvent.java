package io.obswebsocket.community.client.message.event.inputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputNameChangedEvent extends InputEvent {
    private Data eventData;

    protected InputNameChangedEvent() {
        super(Type.InputNameChanged, Category.Inputs);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends InputEvent.Data {
        private String oldInputName;
    }
}
