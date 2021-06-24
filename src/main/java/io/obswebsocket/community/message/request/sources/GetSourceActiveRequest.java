package io.obswebsocket.community.message.request.sources;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSourceActiveRequest extends SourceRequest {
    private final Data requestData;

    @Builder
    private GetSourceActiveRequest(String sourceName) {
        super(Type.GetSourceActive);

        this.requestData = Data.builder().sourceName(sourceName).build();
    }
}
