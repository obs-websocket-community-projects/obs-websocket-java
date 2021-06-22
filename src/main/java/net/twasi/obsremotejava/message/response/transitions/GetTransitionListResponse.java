package net.twasi.obsremotejava.message.response.transitions;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.model.Transition;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetTransitionListResponse extends RequestResponse {
    private Data responseData;

    public GetTransitionListResponse() {
        super(Request.Type.GetTransitionList);
    }

    @Getter
    @ToString
    public static class Data {
        private String currentTransitionName;
        private List<Transition> transitions;
    }
}
