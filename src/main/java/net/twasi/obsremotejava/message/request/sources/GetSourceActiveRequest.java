package net.twasi.obsremotejava.message.request.sources;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSourceActiveRequest extends SourceRequest {
    private final Data requestData;

    public GetSourceActiveRequest(String sourceName) {
        super(Type.GetSourceActive);

        this.requestData = Data.builder().sourceName(sourceName).build();
    }
}
