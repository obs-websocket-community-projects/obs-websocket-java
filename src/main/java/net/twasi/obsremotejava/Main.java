package net.twasi.obsremotejava;

import net.twasi.obsremotejava.requests.SetTextGDIPlusProperties.SetTextGDIPlusPropertiesResponse;

public class Main {

    private static Object SetTextGDIPlusPropertiesResponse;

    public static void main(String[] args) {

        OBSRemoteController controller = new OBSRemoteController("ws://localhost:4444", false);

        if (controller.isFailed()) { // Awaits response from OBS
            // Here you can handle a failed connection request
            System.out.println("Failure!");
        }

        controller.setTextGDIPlusProperties("TestGDI", false, "bacon and cyanide \n are the crigne \n brothers", new TextCallback());
        System.out.println("Doing something");

    }


}
