package net.twasi.obsremotejava.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetInputDefaultSettingsRequest extends Request {
    private final Data requestData;

    public GetInputDefaultSettingsRequest(String inputKind) {
        super(Type.GetInputDefaultSettings);

        this.requestData = Data.builder().inputKind(inputKind).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final String inputKind;
    }
}
