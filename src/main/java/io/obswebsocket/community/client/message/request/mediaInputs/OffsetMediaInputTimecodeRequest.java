package io.obswebsocket.community.client.message.request.mediaInputs;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class OffsetMediaInputTimecodeRequest extends MediaInputRequest {
    private final Data requestData;

    @Builder
    private OffsetMediaInputTimecodeRequest(String inputName) {
        super(Type.OffsetMediaInputTimecode);

        this.requestData = Data.builder().inputName(inputName).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends MediaInputRequest.Data {
        @NonNull
        private final Long timestampOffset;
    }
}