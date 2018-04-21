package net.diespendendose.obsremotejava.test;

import net.diespendendose.obsremotejava.Callback;
import net.diespendendose.obsremotejava.OBSRemoteController;
import net.diespendendose.obsremotejava.requests.GetCurrentProfile.GetCurrentProfileResponse;
import net.diespendendose.obsremotejava.requests.GetCurrentScene.GetCurrentSceneResponse;
import net.diespendendose.obsremotejava.requests.GetVersion.GetVersionResponse;
import net.diespendendose.obsremotejava.requests.ListProfiles.ListProfilesResponse;
import net.diespendendose.obsremotejava.requests.ResponseBase;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;
import java.util.concurrent.ExecutionException;

public class OBSRemoteControllerTest {

    @Test
    void test() {
        final OBSRemoteController controller = new OBSRemoteController("ws://localhost:4444", false);

        if (controller.isFailed()) {
            System.out.println("UPS DAS GET NET HÜLFEEE!");
        }

        controller.registerDisconnectCallback(new Callback() {
            @Override
            public void run(ResponseBase response) {
                System.out.println("Disconnected");
            }
        });

        controller.registerConnectCallback(new Callback() {
            @Override
            public void run(ResponseBase response) {
                GetVersionResponse version = (GetVersionResponse) response;
                System.out.println("Connected!");
                System.out.println(version.getObsStudioVersion());

                /* controller.getScenes(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        GetSceneListResponse res = (GetSceneListResponse) response;

                        for (Scene scene : res.getScenes()) {
                            System.out.println("Name: " + scene.getName());
                            for (Source src : scene.getSources()) {
                                System.out.println("  " + src.getName());
                            }
                        }
                    }
                });*/

                /* controller.setCurrentTransition("Überbllenden", new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Change transition: " + response.getStatus());
                    }
                });

                controller.setCurrentScene("Szene", new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Change scene:" + response.getStatus());
                    }
                });*/

                /* controller.changeSceneWithTransition("EineCooleSzene", "Überblenden", new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.print("Change completed.");
                    }
                }); */

                /* controller.setSourceVisibility("EineCooleSzene", "Bildschirmaufnahme", true, new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        if (response.getStatus().equals("ok")) {
                            System.out.println("Visibility changed.");
                        } else {
                            System.out.print("Error while changing visibility: " + response.getError());
                        }
                    }
                });*/

                /* controller.getTransitionList(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        GetTransitionListResponse res = (GetTransitionListResponse) response;

                        System.out.println("Current transition: " + res.getCurrentTransition());
                        System.out.println("All transitions:");
                        for(GetTransitionListResponse.Transition t : res.getTransitions()) {
                            System.out.println("  - " + t.getName());
                        }
                    }
                });*/

                /* controller.transitionToProgram("Überblenden", 0, new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Transition OK");
                    }
                });*/

                /* controller.getSourceSettings("Medienquelle", new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        GetSourceSettingsResponse res = (GetSourceSettingsResponse) response;

                        System.out.println(res.getSourceName());
                        System.out.println(res.getSourceSettings());
                    }
                });*/

                /* Map<String, Object> settings = new HashMap<>();
                settings.put("input", "https://sadfasdf.net");
                controller.setSourceSettings("Medienquelle", settings, new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Source settings changed.");
                    }
                });*/

                /* controller.getStreamingStatus(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        GetStreamingStatusResponse res = (GetStreamingStatusResponse) response;
                        System.out.println("isStreaming: " + res.isStreaming());
                        System.out.println("Streaming since: " + res.getStreamTimecode());
                        System.out.println("isRecording: " + res.isRecording());
                        System.out.println("Recording since: " + res.getRecTimecode());
                    }
                }); */

                /* controller.startStreaming(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Streaming started: " + response.getStatus());
                    }
                });

                controller.stopStreaming(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Streaming stopped: " + response.getStatus());
                    }
                });*/

                /* controller.listProfiles(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        ListProfilesResponse res = (ListProfilesResponse) response;

                        res.getProfiles().forEach(profile -> System.out.println(profile.getName()));
                    }
                });*/

                /* controller.getCurrentProfile(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        GetCurrentProfileResponse res = (GetCurrentProfileResponse) response;

                        System.out.println(res.getProfileName());
                    }
                });*/

                /* controller.setCurrentProfile("Unbenannt", res -> {
                    System.out.println(res.getStatus());
                }); */

                /* controller.getCurrentScene(res -> {
                    System.out.println(((GetCurrentSceneResponse) res).getName());
                });*/
            }
        });

        try {
            controller.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
