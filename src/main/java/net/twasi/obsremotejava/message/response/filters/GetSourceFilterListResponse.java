package net.twasi.obsremotejava.message.response.filters;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.model.Filter;
import net.twasi.obsremotejava.model.Profile;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterListResponse extends RequestResponse {
    private Data responseData;

    public GetSourceFilterListResponse() {
        super(Request.Type.GetSourceFilterList);
    }

    @Getter
    @ToString
    public static class Data {
        private List<Filter> filters;
    }
}
