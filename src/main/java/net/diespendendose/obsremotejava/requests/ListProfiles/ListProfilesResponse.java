package net.diespendendose.obsremotejava.requests.ListProfiles;

import net.diespendendose.obsremotejava.objects.Profile;
import net.diespendendose.obsremotejava.requests.ResponseBase;

import java.util.List;

public class ListProfilesResponse extends ResponseBase {
    private List<Profile> profiles;

    public List<Profile> getProfiles() {
        return profiles;
    }
}
