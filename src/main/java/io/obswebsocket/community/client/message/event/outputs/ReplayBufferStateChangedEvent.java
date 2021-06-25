package io.obswebsocket.community.client.message.event.outputs;

import lombok.ToString;

@ToString(callSuper = true)
public class ReplayBufferStateChangedEvent extends OutputStateChangedEvent {
    protected ReplayBufferStateChangedEvent() {
        super(Type.ReplayBufferStateChanged, Category.Outputs);
    }
}
