package net.twasi.obsremotejava.requests.GetSceneItemProperties;

import net.twasi.obsremotejava.requests.ResponseBase;

public class GetSceneItemPropertiesResponse extends ResponseBase {
    private String name;
    private long itemId;
    private boolean visible;
    private boolean muted;
    private boolean locked;

    public String getName() {
        return this.name;
    }

    public long getItemId() {
        return this.itemId;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public boolean isMuted() {
        return this.muted;
    }

    public boolean isLocked() {
        return this.locked;
    }
}
