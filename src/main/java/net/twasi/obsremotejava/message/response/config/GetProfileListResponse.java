package net.twasi.obsremotejava.message.response.config;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.model.Profile;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetProfileListResponse extends RequestResponse {
    private Data responseData;

    public GetProfileListResponse() {
        super(Request.Type.GetProfileList);
    }

    @Getter
    @ToString
    public static class Data {
        private List<Profile> profiles;
        private String currentProfileName;
    }
}
