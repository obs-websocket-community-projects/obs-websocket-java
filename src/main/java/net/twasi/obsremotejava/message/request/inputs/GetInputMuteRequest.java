package net.twasi.obsremotejava.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetInputMuteRequest extends Request {
    private final Data requestData;

    public GetInputMuteRequest(String inputName) {
        super(Type.GetInputMute);

        this.requestData = Data.builder().inputName(inputName).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final String inputName;
    }
}
