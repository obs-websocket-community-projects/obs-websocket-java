package io.obswebsocket.community.client.message.event.outputs;

import lombok.ToString;

@ToString(callSuper = true)
public class RecordStateChangedEvent extends OutputStateChangedEvent {
    protected RecordStateChangedEvent() {
        super(Type.RecordStateChanged, Category.Outputs);
    }
}
