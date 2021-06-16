package net.twasi.obsremotejava.message.response.inputs;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.model.Input;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetInputListResponse extends RequestResponse {
    private Data responseData;

    public GetInputListResponse() {
        super(Request.Type.GetInputList);
    }

    @Getter
    @ToString
    public static class Data {
        private List<Input> inputs;
    }
}
