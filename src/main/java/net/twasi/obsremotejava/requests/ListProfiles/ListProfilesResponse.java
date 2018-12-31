package net.twasi.obsremotejava.requests.ListProfiles;

import net.twasi.obsremotejava.objects.Profile;
import net.twasi.obsremotejava.requests.ResponseBase;

import java.util.List;

public class ListProfilesResponse extends ResponseBase {
    private List<Profile> profiles;

    public List<Profile> getProfiles() {
        return profiles;
    }
}
