package net.twasi.obsremotejava.message.request.inputs;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class SetInputSettingsRequest extends Request {
    private final Data requestData;

    public SetInputSettingsRequest(String inputName, JsonObject inputSettings, boolean overlay) {
        super(Type.SetInputSettings);

        this.requestData = Data.builder().inputName(inputName).inputSettings(inputSettings).overlay(overlay).build();
    }

    public SetInputSettingsRequest(String inputName, JsonObject inputSettings) {
        super(Type.SetInputSettings);

        this.requestData = Data.builder().inputName(inputName).inputSettings(inputSettings).build();
    }

    @Getter
    @ToString
    @Builder
    public static class Data {
        private final String inputName;
        private final JsonObject inputSettings;
        @Builder.Default
        private final boolean overlay = true;
    }
}
