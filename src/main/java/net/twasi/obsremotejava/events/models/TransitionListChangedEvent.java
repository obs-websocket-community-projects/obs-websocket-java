package net.twasi.obsremotejava.events.models;

import net.twasi.obsremotejava.events.EventBase;
import net.twasi.obsremotejava.objects.Transition;

import java.util.List;

public class TransitionListChangedEvent extends EventBase {
     private List<Transition> transitions;

     public List<Transition> getTransitions() {
         return transitions;
     }
}
