package io.obswebsocket.community.client.message.request.mediaInputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RestartMediaInputRequest extends MediaInputRequest {
    private final Data requestData;

    @Builder
    private RestartMediaInputRequest(String inputName) {
        super(Type.RestartMediaInput);

        this.requestData = Data.builder().inputName(inputName).build();
    }
}