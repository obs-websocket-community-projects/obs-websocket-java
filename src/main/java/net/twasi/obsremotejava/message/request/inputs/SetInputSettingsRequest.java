package net.twasi.obsremotejava.message.request.inputs;

import com.google.gson.JsonObject;
import lombok.*;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class SetInputSettingsRequest extends InputRequest {
    private final Data requestData;

    public SetInputSettingsRequest(String inputName, JsonObject inputSettings, Boolean overlay) {
        super(Type.SetInputSettings);

        this.requestData = Data.builder().inputName(inputName).inputSettings(inputSettings).overlay(overlay).build();
    }

    @Getter
    @ToString
    static class Data extends InputRequest.Data {
        @NonNull
        private final JsonObject inputSettings;
        private final Boolean overlay;

        @Builder
        Data(String inputName, JsonObject inputSettings, Boolean overlay) {
            super(inputName);

            this.inputSettings = inputSettings;
            this.overlay = overlay;
        }
    }
}
