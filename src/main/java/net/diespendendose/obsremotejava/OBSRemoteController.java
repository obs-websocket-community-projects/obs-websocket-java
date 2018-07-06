package net.diespendendose.obsremotejava;

import net.diespendendose.obsremotejava.requests.ResponseBase;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.ConnectException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class OBSRemoteController {
    private String address;
    private OBSCommunicator communicator;
    private WebSocketClient client;

    private boolean failed;

    public OBSRemoteController(String address, boolean debug) {
        this.address = address;
        communicator = new OBSCommunicator(debug);
        client = new WebSocketClient();
        try {
            client.start();

            URI uri = new URI(address);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> connection = client.connect(communicator, uri, request);
            System.out.printf("Connecting to: %s%n", uri);

            try {
                connection.get();
                failed = false;
            } catch (ExecutionException e) {
                if (e.getCause() instanceof ConnectException) {
                    System.out.println("Connection to OBS failed.");
                    failed = true;
                }
            }

            /* new Thread() {
                @Override
                public void run() {
                    try {
                        communicator.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start(); */
            //communicator.;

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                //client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isFailed() {
        return failed;
    }

    public void getScenes(Callback callback) {
        communicator.getScenes(callback);
    };

    public void registerConnectCallback(Callback onConnect) {
        communicator.registerOnConnect(onConnect);
    }

    public void registerDisconnectCallback(Callback onDisconnect) {
        communicator.registerOnDisconnect(onDisconnect);
    }

    public void await() throws InterruptedException {
        communicator.await();
    }

    public void setCurrentScene(String szene, Callback callback) {
        communicator.setCurrentScene(szene, callback);
    }

    public void setCurrentTransition(String transition, Callback callback) {
        communicator.setCurrentTransition(transition, callback);
    }

    public void changeSceneWithTransition(final String scene, String transition, final Callback callback) {
        communicator.setCurrentTransition(transition, new Callback() {
            @Override
            public void run(ResponseBase response) {
                if (!response.getStatus().equals("ok")) {
                    System.out.println("Failed to change transition. Pls fix.");
                }
                communicator.setCurrentScene(scene, callback);
            }
        });
    }

    public void setSourceVisibility(String scene, String source, boolean visibility, Callback callback) {
        communicator.setSourceVisiblity(scene, source, visibility, callback);
    }

    public void getSceneItemProperties(String scene, String source, Callback callback) {
        communicator.getSceneItemProperties(scene, source, callback);
    }

    public void getTransitionList(Callback callback) {
        communicator.getTransitionList(callback);
    }

    public void transitionToProgram(String transitionName, int duration, Callback callback) {
        communicator.transitionToProgram(transitionName, duration, callback);
    }

    public void getSourceSettings(String sourceName, Callback callback) {
        communicator.getSourceSettings(sourceName, callback);
    }

    public void setSourceSettings(String sourceName, Map<String,Object> settings, Callback callback) {
        communicator.setSourceSettings(sourceName, settings, callback);
    }

    public void getStreamingStatus(Callback callback) {
        communicator.getStreamingStatus(callback);
    }

    public void startStreaming(Callback callback) {
        communicator.startStreaming(callback);
    }

    public void stopStreaming(Callback callback) {
        communicator.stopStreaming(callback);
    }

    public void listProfiles(Callback callback) {
        communicator.listProfiles(callback);
    }

    public void getCurrentProfile(Callback callback) {
        communicator.getCurrentProfile(callback);
    }

    public void setCurrentProfile(String profile, Callback callback) {
        communicator.setCurrentProfile(profile, callback);
    }

    public void getCurrentScene(Callback callback) {
        communicator.getCurrentScene(callback);
    }

    public void getVolume(String source, Callback callback) { communicator.getVolume(source, callback); }

    public void setVolume(String source, double volume, Callback callback) { communicator.setVolume(source, volume, callback); }

    public void setMute(String source, boolean mute, Callback callback) { communicator.setMute(source, mute, callback); }

    public void getPreviewScene(Callback callback) { communicator.getPreviewScene(callback); }

    public void setPreviewScene(String name, Callback callback) { communicator.setPreviewScene(name, callback); }
}
