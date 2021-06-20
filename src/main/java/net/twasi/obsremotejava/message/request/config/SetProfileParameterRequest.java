package net.twasi.obsremotejava.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class SetProfileParameterRequest extends Request {
    private final Data requestData;

    public SetProfileParameterRequest(String parameterCategory, String parameterName, String parameterValue) {
        super(Type.SetProfileParameter);

        this.requestData = Data.builder().parameterCategory(parameterCategory).parameterName(parameterName).parameterValue(parameterValue).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final String parameterCategory;
        @NonNull
        private final String parameterName;
        private final String parameterValue; // this field is optional
    }
}
