package net.twasi.obsremotejava.requests.TransitionToProgram;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class TransitionToProgramRequest extends BaseRequest {
    @SerializedName("with-transition")
    private WithTransition withTransition;

    public class WithTransition {
        private String name;
        private Integer duration;

        public WithTransition(String name, int duration) {
            if (duration == 0) {
                this.duration = null;
            } else {
                this.duration = duration;
            }

            this.name = name;
        }
    }

    public TransitionToProgramRequest(OBSCommunicator com, String transition, int duration) {
        super(RequestType.TransitionToProgram);

        this.withTransition = new WithTransition(transition, duration);

        com.messageTypes.put(getMessageId(), TransitionToProgramResponse.class);
    }
}
