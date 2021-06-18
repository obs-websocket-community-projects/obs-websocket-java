package net.twasi.obsremotejava.message.request.general;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class SetStudioModeEnabledRequest extends Request {
    private final Data requestData;

    public SetStudioModeEnabledRequest(Boolean studioModeEnabled) {
        super(Type.SetStudioModeEnabled);

        this.requestData = Data.builder().studioModeEnabled(studioModeEnabled).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final Boolean studioModeEnabled;
    }
}
