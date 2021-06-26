package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputDefaultSettingsRequest extends Request {
    private final Data requestData;

    @Builder
    private GetInputDefaultSettingsRequest(String inputKind) {
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
