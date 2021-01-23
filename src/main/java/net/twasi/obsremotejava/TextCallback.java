package net.twasi.obsremotejava;

import net.twasi.obsremotejava.callbacks.Callback;
import net.twasi.obsremotejava.requests.SetSceneItemProperties.SetSceneItemPropertiesRequest;
import net.twasi.obsremotejava.requests.SetTextGDIPlusProperties.SetTextGDIPlusPropertiesResponse;

public class TextCallback implements Callback<SetTextGDIPlusPropertiesResponse> {

    public void run(SetTextGDIPlusPropertiesResponse response) {
        System.out.println("Calling back....");


    }
}
