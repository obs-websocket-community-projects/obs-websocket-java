package net.diespendendose.obsremotejava.requests.GetSceneItemProperties;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class GetSceneItemPropertiesRequest extends BaseRequest {
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

        this.scene = scene;
    }
}
