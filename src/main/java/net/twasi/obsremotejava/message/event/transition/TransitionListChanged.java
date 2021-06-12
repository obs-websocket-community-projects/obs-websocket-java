package net.twasi.obsremotejava.message.event.transition;

import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.objects.Transition;

import java.util.List;

public class TransitionListChanged extends Event {
    private Data eventData;

    protected TransitionListChanged() {
        super(Type.TransitionEnd);
    }

    public Data getEventData() {
        return this.eventData;
    }

    public static class Data {
        private List<Transition> transitions;

        public List<Transition> getTransitions() {
            return transitions;
        }
    }
}
