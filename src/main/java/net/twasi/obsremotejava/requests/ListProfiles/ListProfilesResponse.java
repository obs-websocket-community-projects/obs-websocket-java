package net.twasi.obsremotejava.requests.ListProfiles;

import java.util.List;
import net.twasi.obsremotejava.objects.Profile;
import net.twasi.obsremotejava.requests.ResponseBase;

public class ListProfilesResponse extends ResponseBase {
    private List<Profile> profiles;

    public List<Profile> getProfiles() {
        return profiles;
    }
}
