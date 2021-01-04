package net.twasi.obsremotejava.events.responses;

import net.twasi.obsremotejava.objects.Transition;
import net.twasi.obsremotejava.requests.ResponseBase;

import java.util.List;

public class TransitionListChangedResponse extends ResponseBase {
    // Note: enabled these when https://github.com/Palakis/obs-websocket/blob/4.x-current/src/WSEvents.cpp#L561 is released.
    // private List<Transition> transitions;

    // public List<Transition> getTransitions() { return transitions; }
}
