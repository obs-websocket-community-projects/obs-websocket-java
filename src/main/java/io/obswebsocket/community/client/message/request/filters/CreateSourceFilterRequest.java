package io.obswebsocket.community.client.message.request.filters;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class CreateSourceFilterRequest extends FilterRequest {
    private final Data requestData;

    @Builder
    private CreateSourceFilterRequest(String sourceName, String filterName, Integer filterIndex, String filterKind, JsonObject filterSettings) {
        super(Type.CreateSourceFilter);

        this.requestData = Data.builder().sourceName(sourceName).filterName(filterName).filterIndex(filterIndex).filterKind(filterKind).filterSettings(filterSettings).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends FilterRequest.Data {
        @NonNull
        private final String filterName;
        @NonNull
        private final Boolean filterEnabled;
        @NonNull
        private final Integer filterIndex;
        @NonNull
        private final String filterKind;
        @NonNull
        private final JsonObject filterSettings;
    }
}
