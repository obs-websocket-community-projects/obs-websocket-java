package net.twasi.obsremotejava.message.request.filters;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSourceFilterEnabledRequest extends FilterRequest {
    private final Data requestData;

    @Builder
    private SetSourceFilterEnabledRequest(String sourceName, String filterName, Boolean filterEnabled) {
        super(Type.SetSourceFilterEnabled);

        this.requestData = Data.builder().sourceName(sourceName).filterName(filterName).filterEnabled(filterEnabled).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends FilterRequest.Data {
        @NonNull
        private final String filterName;
        @NonNull
        private final Boolean filterEnabled;
    }
}
