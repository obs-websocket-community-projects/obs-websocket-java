package net.twasi.obsremotejava.events.responses;

import net.twasi.obsremotejava.requests.ResponseBase;

public class TransitionListChangedResponse extends ResponseBase {
    // Leaving this empty for now to match ScenesChangedResponse event strategy.
    //
    // We may want to populate both of these with scenes/transitions when changed:
    // The list of available transitions has been modified. Transitions have been added, removed, or renamed.
    //
    // Response Items:
    //
    // Name                 Type            Description
    // ---                  ---             ---
    // transitions          Array<Object>   Transitions list.
    // transitions.*.name   String          Transition name.
}
