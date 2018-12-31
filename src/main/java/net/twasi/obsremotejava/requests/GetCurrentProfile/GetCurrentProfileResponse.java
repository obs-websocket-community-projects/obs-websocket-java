package net.twasi.obsremotejava.requests.GetCurrentProfile;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.requests.ResponseBase;

public class GetCurrentProfileResponse extends ResponseBase {
    @SerializedName("profile-name")
    private String profileName;

    public String getProfileName() {
        return profileName;
    }
}
