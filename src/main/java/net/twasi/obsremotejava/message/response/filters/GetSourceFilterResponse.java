package net.twasi.obsremotejava.message.response.filters;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.model.Filter;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterResponse extends RequestResponse {
    private Filter responseData;

    public GetSourceFilterResponse() {
        super(Request.Type.GetSourceFilter);
    }
}
