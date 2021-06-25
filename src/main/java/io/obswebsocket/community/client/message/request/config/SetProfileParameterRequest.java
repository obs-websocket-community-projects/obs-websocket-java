package io.obswebsocket.community.client.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;

@Getter
@ToString(callSuper = true)
public class SetProfileParameterRequest extends Request {
    private final Data requestData;

    @Builder
    private SetProfileParameterRequest(String parameterCategory, String parameterName, String parameterValue) {
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
