package net.twasi.obsremotejava.message.request.sources;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetSourceActiveRequest extends Request {
    private final Data requestData;

    public GetSourceActiveRequest(String sourceName) {
        super(Type.GetSourceActive);

        this.requestData = Data.builder().sourceName(sourceName).build();
    }

    @Getter
    @ToString
    @Builder
    public static class Data {
        private final String sourceName;
    }
}
