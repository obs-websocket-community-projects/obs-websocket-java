package net.twasi.obsremotejava.message.request.scenes;

import net.twasi.obsremotejava.message.request.Request;

public class GetSceneList extends Request {
    static {
        Request.registerRequestType(Type.GetSceneList, GetSceneList.class);
    }

    public GetSceneList() {
        super(Type.GetSceneList);
    }
}
