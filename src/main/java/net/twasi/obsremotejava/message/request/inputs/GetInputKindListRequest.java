package net.twasi.obsremotejava.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetInputKindListRequest extends Request {
    private final Data requestData;

    public GetInputKindListRequest(boolean unversioned) {
        super(Type.GetInputKindList);

        this.requestData = Data.builder().unversioned(unversioned).build();
    }

    public GetInputKindListRequest() {
        super(Type.GetInputKindList);

        this.requestData = Data.builder().build();
    }

    @Getter
    @ToString
    @Builder
    public static class Data {
        private final boolean unversioned;
    }
}
