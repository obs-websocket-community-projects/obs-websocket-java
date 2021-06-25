package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputMuteRequest extends InputRequest {
    private final Data requestData;

    @Builder
    private GetInputMuteRequest(String inputName) {
        super(Request.Type.GetInputMute);

        this.requestData = Data.builder().inputName(inputName).build();
    }
}
