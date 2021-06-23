package net.twasi.obsremotejava.message.request.filters;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSourceFilterIndexRequest extends FilterRequest {
    private final Data requestData;

    @Builder
    private SetSourceFilterIndexRequest(String sourceName, String filterName, Integer filterIndex) {
        super(Type.SetSourceFilterIndex);

        this.requestData = Data.builder().sourceName(sourceName).filterName(filterName).filterIndex(filterIndex).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends FilterRequest.Data {
        private final String filterName;
        private final Integer filterIndex;
    }
}
