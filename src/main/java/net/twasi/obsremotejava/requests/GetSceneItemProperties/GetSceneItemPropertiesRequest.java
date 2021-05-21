package net.twasi.obsremotejava.requests.GetSceneItemProperties;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class GetSceneItemPropertiesRequest extends RequestBase {
    private String scene;
    private Item item;

    private class Item {
        private String id;
        private String name;

        public Item(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public GetSceneItemPropertiesRequest(OBSCommunicator com, String scene, String source) {
        super(RequestType.GetSceneItemProperties);

        this.scene = scene;
        this.item = new Item(null, source);

        com.messageTypes.put(getMessageId(), GetSceneItemPropertiesResponse.class);
    }
}
