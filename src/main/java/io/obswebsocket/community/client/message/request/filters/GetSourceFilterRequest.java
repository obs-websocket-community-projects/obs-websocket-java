package io.obswebsocket.community.client.message.request.filters;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterRequest extends FilterRequest {
    private final Data requestData;

    @Builder
    private GetSourceFilterRequest(String sourceName, String filterName) {
        super(Type.GetSourceFilter);

        this.requestData = Data.builder().sourceName(sourceName).filterName(filterName).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends FilterRequest.Data {
        @NonNull
        private final String filterName;
    }
}
