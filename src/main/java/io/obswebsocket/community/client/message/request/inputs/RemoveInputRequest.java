package io.obswebsocket.community.client.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveInputRequest extends InputRequest {
    private final Data requestData;

    @Builder
    private RemoveInputRequest(String inputName) {
        super(Type.RemoveInput);

        this.requestData = Data.builder().inputName(inputName).build();
    }
}
