package net.twasi.obsremotejava.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetProfileParameterRequest extends Request {
    private final Data requestData;

    public GetProfileParameterRequest(String parameterCategory, String parameterName) {
        super(Type.GetProfileParameter);

        this.requestData = Data.builder().parameterCategory(parameterCategory).parameterName(parameterName).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final String parameterCategory;
        @NonNull
        private final String parameterName;
    }
}
