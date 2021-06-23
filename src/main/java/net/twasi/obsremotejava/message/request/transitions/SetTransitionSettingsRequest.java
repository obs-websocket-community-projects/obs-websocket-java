package net.twasi.obsremotejava.message.request.transitions;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetTransitionSettingsRequest extends TransitionRequest {
    private final Data requestData;

    @Builder
    private SetTransitionSettingsRequest(String transitionName, JsonObject transitionSettings) {
        super(Type.SetTransitionSettings);

        this.requestData = Data.builder().transitionName(transitionName).transitionSettings(transitionSettings).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends TransitionRequest.Data {
        private final JsonObject transitionSettings;
    }
}
