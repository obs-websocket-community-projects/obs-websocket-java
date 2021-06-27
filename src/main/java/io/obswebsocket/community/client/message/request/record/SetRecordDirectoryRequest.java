package io.obswebsocket.community.client.message.request.record;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.File;

@Getter
@ToString(callSuper = true)
public class SetRecordDirectoryRequest extends Request {
    private final Data requestData;

    @Builder
    private SetRecordDirectoryRequest(String recordDirectory, Boolean createIfNotExist) {
        super(Type.SetRecordDirectory);

        this.requestData = Data.builder().recordDirectory(recordDirectory).createIfNotExist(createIfNotExist).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data {
        @NonNull
        private final String recordDirectory;
        @NonNull
        private final Boolean createIfNotExist;
    }
}
