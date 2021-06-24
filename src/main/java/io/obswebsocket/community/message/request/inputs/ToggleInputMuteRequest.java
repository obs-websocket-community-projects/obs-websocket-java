package io.obswebsocket.community.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ToggleInputMuteRequest extends InputRequest {
    private final Data requestData;

    @Builder
    private ToggleInputMuteRequest(String inputName) {
        super(Type.ToggleInputMute);

        this.requestData = Data.builder().inputName(inputName).build();
    }
}
