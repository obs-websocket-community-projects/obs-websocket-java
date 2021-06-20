package net.twasi.obsremotejava.message.request.inputs;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

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
    @SuperBuilder
    static class Data extends InputRequest.Data {
        @NonNull
        private final JsonObject inputSettings;
        private final Boolean overlay;
    }
}
