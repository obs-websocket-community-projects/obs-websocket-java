package io.obswebsocket.community.client.message.request.record;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetRecordFilenameFormattingRequest extends Request {
    private final Data requestData;

    @Builder
    private SetRecordFilenameFormattingRequest(String filenameFormatting) {
        super(Type.SetRecordFilenameFormatting);

        this.requestData = Data.builder().filenameFormatting(filenameFormatting).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final String filenameFormatting;
    }
}
