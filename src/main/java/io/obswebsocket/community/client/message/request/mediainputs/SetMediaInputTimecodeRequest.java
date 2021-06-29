package io.obswebsocket.community.client.message.request.mediainputs;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetMediaInputTimecodeRequest extends MediaInputRequest {
    private final Data requestData;

    @Builder
    private SetMediaInputTimecodeRequest(String inputName, Long mediaTimestamp) {
        super(Type.SetMediaInputTimecode);

        this.requestData = Data.builder().inputName(inputName).mediaTimestamp(mediaTimestamp).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends MediaInputRequest.Data {
        @NonNull
        private final Long mediaTimestamp;
    }
}