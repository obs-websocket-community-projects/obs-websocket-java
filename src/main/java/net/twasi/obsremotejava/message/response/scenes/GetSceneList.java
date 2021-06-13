package net.twasi.obsremotejava.message.response.scenes;

import java.util.List;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.objects.Scene;

@Getter
@ToString(callSuper = true)
public class GetSceneList extends RequestResponse {
    private Data responseData;

    public GetSceneList() {
        super(Request.Type.GetSceneList);
    }

    @Getter
    @ToString
    public static class Data {
        private List<Scene> scenes;
    }
}
