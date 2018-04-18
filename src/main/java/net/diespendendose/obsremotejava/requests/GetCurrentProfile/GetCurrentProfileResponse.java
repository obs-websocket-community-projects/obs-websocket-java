package net.diespendendose.obsremotejava.requests.GetCurrentProfile;

import com.google.gson.annotations.SerializedName;
import net.diespendendose.obsremotejava.requests.ResponseBase;

public class GetCurrentProfileResponse extends ResponseBase {
    @SerializedName("profile-name")
    private String profileName;

    public String getProfileName() {
        return profileName;
    }
}
