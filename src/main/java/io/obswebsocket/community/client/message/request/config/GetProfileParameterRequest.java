package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetProfileParameterRequest extends Request {
    private final Data requestData;

    @Builder
    private GetProfileParameterRequest(String parameterCategory, String parameterName) {
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
