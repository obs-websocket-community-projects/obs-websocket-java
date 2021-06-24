package io.obswebsocket.community.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetInputListRequest extends Request {
    private final Data requestData;

    @Builder
    private GetInputListRequest(String inputKind) {
        super(Type.GetInputList);

        this.requestData = Data.builder().inputKind(inputKind).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        private final String inputKind;
    }
}
