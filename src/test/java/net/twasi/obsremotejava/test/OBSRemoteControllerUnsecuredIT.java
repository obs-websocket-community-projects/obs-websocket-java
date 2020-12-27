package net.twasi.obsremotejava.test;

import net.twasi.obsremotejava.callbacks.Callback;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.events.responses.ScenesChangedResponse;
import net.twasi.obsremotejava.events.responses.SwitchScenesResponse;
import net.twasi.obsremotejava.events.responses.TransitionBeginResponse;
import net.twasi.obsremotejava.events.responses.TransitionEndResponse;
import net.twasi.obsremotejava.requests.GetVersion.GetVersionResponse;
import net.twasi.obsremotejava.requests.ResponseBase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.fail;

public class OBSRemoteControllerUnsecuredIT {

    /**
     * - Setup OBS with the below address, and disable authentication
     * - Make sure your OBS is running and available for connection
     */
    private final String obsAddress = "ws://localhost:4444";
    private final String obsPassword = null;

    @Test
    @Disabled
    void test() {
        final OBSRemoteController controller = new OBSRemoteController(obsAddress, false, obsPassword);

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

                controller.registerReplayStartedCallback(res -> {
                    System.out.println("Replay started");
                });

                controller.registerReplayStartingCallback(res -> {
                    System.out.println("Replay starting");
                });

                controller.registerReplayStoppedCallback(res -> {
                    System.out.println("Replay stopped");
                });

                controller.registerReplayStoppingCallback(res -> {
                    System.out.println("Replay stopping");
                });

                controller.startReplayBuffer(res -> {
                    System.out.println("Should start replay buffer");
                });

                controller.saveReplayBuffer(res -> {
                    System.out.println("Should save replay buffer");
                });

                controller.stopReplayBuffer(res -> {
                    System.out.println("Should stop replay buffer");
                });

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
                }); */

                /* controller.setCurrentTransition("Überbllenden", new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Change transition: " + response.getStatus());
                    }
                }); */

                /* controller.setCurrentScene("Szene", new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Change scene:" + response.getStatus());
                    }
                }); */

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
                }); */

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
                }); */

                /* controller.transitionToProgram("Überblenden", 0, new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Transition OK");
                    }
                }); */

                /* controller.getSourceSettings("Streaminput", new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        GetSourceSettingsResponse res = (GetSourceSettingsResponse) response;

                        System.out.println(res.getSourceName());
                        System.out.println(res.getSourceSettings());
                    }
                }); */

                /* Map<String, Object> settings = new HashMap<>();
                settings.put("input", "https://sadfasdf.net");
                controller.setSourceSettings("Medienquelle", settings, new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Source settings changed.");
                    }
                }); */

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
                }); */

                /* controller.stopStreaming(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Streaming stopped: " + response.getStatus());
                    }
                }); */

                /* controller.listProfiles(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        ListProfilesResponse res = (ListProfilesResponse) response;

                        res.getProfiles().forEach(profile -> System.out.println(profile.getName()));
                    }
                }); */

                /* controller.getCurrentProfile(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        GetCurrentProfileResponse res = (GetCurrentProfileResponse) response;

                        System.out.println(res.getProfileName());
                    }
                }); */

                /* controller.setCurrentProfile("Unbenannt", res -> {
                    System.out.println(res.getStatus());
                }); */

                /* controller.getCurrentScene(res -> {
                    System.out.println(((GetCurrentSceneResponse) res).getName());
                }); */

                /* controller.getVolume("Streaminput", res -> {
                    GetVolumeResponse resp = (GetVolumeResponse) res;

                    System.out.println(resp.isMuted());
                    System.out.println(resp.getVolume());
                }); */

                /* controller.setVolume("Streaminput", 0.01, res -> {
                    System.out.println("Done");
                }); */

                /* controller.setMute("Streaminput", true, res -> {
                    System.out.println("Done");
                }); */

                /* controller.getPreviewScene(res -> {
                    GetPreviewSceneResponse resp = (GetPreviewSceneResponse)res;
                    System.out.println(resp);
                }); */

                /* controller.setPreviewScene("Twasi Starting Soon", res -> {
                    System.out.println("Done");
                }); */

                /* controller.getTransitionDuration(res -> {
                    GetTransitionDurationResponse resp = (GetTransitionDurationResponse) res;

                    System.out.println(resp.getTransitionDuration());
                }); */

                /* controller.setTransitionDuration(1077, res -> {
                    System.out.println("Done");
                }); */

                /* controller.getStudioModeEnabled(res -> {
                    GetStudioModeEnabledResponse resp = (GetStudioModeEnabledResponse) res;
                    System.out.println("Studio mode is " + (resp.isEnabled() ? "enabled" : "disabled") + ".");
                }); */

                /* controller.setStudioModeEnabled(false, res -> {
                    System.out.println("Done");
                }); */


                controller.registerSwitchScenesCallback(res -> {
                    SwitchScenesResponse switchScenesResponse = (SwitchScenesResponse) res;
                    System.out.println("Switched to scene: " + switchScenesResponse.getSceneName());
                });

                controller.registerScenesChangedCallback(res -> {
                    ScenesChangedResponse scenesChangedResponse = (ScenesChangedResponse) res;
                    System.out.println("Scenes changed");
                });

                controller.registerTransitionBeginCallback(res -> {
                    TransitionBeginResponse transitionBeginResponse = (TransitionBeginResponse) res;
                    System.out.println("Transition started from scene: '" + transitionBeginResponse.getFromScene() + "' to scene: '" + transitionBeginResponse.getToScene() + "'");
                });

                controller.registerTransitionEndCallback(res -> {
                    TransitionEndResponse transitionEndResponse = (TransitionEndResponse) res;
                    System.out.println("Transition ended with scene: " + transitionEndResponse.getToScene());
                });
            }
        });

        try {
            controller.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testConnectAndDisconnect() {
        AtomicReference<Boolean> testSuccessful = new AtomicReference<>(Boolean.FALSE);
        AtomicReference<String> testFailedReason = new AtomicReference<>();

        final OBSRemoteController controller = new OBSRemoteController(obsAddress, true,
                                                                       obsPassword, true);

        if (controller.isFailed()) {
            fail("Failed to connect to websocket");
        }

        controller.registerDisconnectCallback(response -> testSuccessful.set(Boolean.TRUE));
        controller.registerConnectCallback(response -> controller.disconnect());

        controller.registerConnectionFailedCallback(message -> {
            testFailedReason.set("onConnectionFailed called unexpectedly");
            controller.disconnect();
        });
        controller.registerOnError((message, throwable) -> {
            testFailedReason.set("onError called unexpectedly");
            controller.disconnect();
        });

        try {
            controller.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (testFailedReason.get() != null) {
            fail(testFailedReason.get());
        }

        if (!testSuccessful.get()) {
            fail("Disconnect didn't work");
        }
    }

    @Test
    void disconnectShouldNotHaveErrorsWhenNoConnectDisconnectCallbacksRegistered() {
        AtomicReference<String> testFailedReason = new AtomicReference<>();

        // Given a controller that auto-connects...When connected
        final OBSRemoteController controller = new OBSRemoteController(obsAddress, true,
                                                                       obsPassword, true);

        // Then no errors should have occurred
        if (controller.isFailed()) {
            fail("Failed to connect to websocket");
        }

        // And given no callbacks registered for connect/disconnect
        controller.registerDisconnectCallback(null);
        controller.registerConnectCallback(null);

        // And given on connection failure and on error callbacks are set
        controller.registerConnectionFailedCallback(message ->
                testFailedReason.set("ConnectionFailedCallback called unexpectedly")
        );
        controller.registerOnError((message, throwable) ->
                testFailedReason.set("OnError called unexpectedly")
        );

        // When disconnected
        controller.disconnect();

        // Then the error or connection failure callbacks should not have been called
        if (testFailedReason.get() != null) {
            fail(testFailedReason.get());
        }
    }

    @Test
    void disconnectShouldNotHaveErrorsWhenConnectDisconnectCallbacksThrowErrors() {
        AtomicReference<String> testFailedReason = new AtomicReference<>();

        // Given controller that auto-connects...When connected
        final OBSRemoteController controller = new OBSRemoteController(obsAddress, true,
                                                                       obsPassword, true);

        // Then no failure was expected on connection
        if (controller.isFailed()) {
            fail("Failed to connect to websocket");
        }

        // And given (invalid) connect and disconnect callbacks are registered
        controller.registerDisconnectCallback(response -> {
            throw new Error("Disconnect callback error");
        });
        controller.registerConnectCallback(response -> {
            throw new Error("Connect callback error");
        });

        // And given on connection failure and on error callbacks are set
        controller.registerConnectionFailedCallback(message ->
                testFailedReason.set("ConnectionFailedCallback called unexpectedly")
        );
        controller.registerOnError((message, throwable) ->
                testFailedReason.set("OnError called unexpectedly")
        );

        // When the controller is disconnected
        controller.disconnect();

        // Then the connection failure and error callbacks should NOT have been called
        if (testFailedReason.get() != null) {
            fail(testFailedReason.get());
        }
    }

    @Test
    void testConnectionFailWithNoCallbacksRegistered() {
        AtomicReference<String> testFailedReason = new AtomicReference<>();

        final OBSRemoteController controller = new OBSRemoteController("ws://garbish:noport", true,
                                                                       null, true);

        if (controller.isFailed()) {
            fail("Failed to connect to websocket");
        }

        controller.registerConnectionFailedCallback(null);
        controller.registerOnError((message, throwable) -> testFailedReason.set("OnError called unexpectedly"));

        controller.disconnect();

        if (testFailedReason.get() != null) {
            fail(testFailedReason.get());
        }
    }
}
