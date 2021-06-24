package io.obswebsocket.community.message.event.outputs;

import lombok.ToString;

@ToString(callSuper = true)
public class ReplayBufferStateChangedEvent extends OutputStateChangedEvent {
    protected ReplayBufferStateChangedEvent() {
        super(Type.ReplayBufferStateChanged, Category.Outputs);
    }
}
