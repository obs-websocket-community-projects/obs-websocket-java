package net.twasi.obsremotejava;

import net.twasi.obsremotejava.callbacks.Callback;
import net.twasi.obsremotejava.callbacks.ErrorCallback;
import net.twasi.obsremotejava.callbacks.StringCallback;
import net.twasi.obsremotejava.objects.throwables.OBSResponseError;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.ConnectException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class OBSRemoteController {
    private String address;
    private final boolean debug;
    private final OBSCommunicator communicator;
    private final String password;
    private final WebSocketClient client;

    private StringCallback onConnectionFailed;
    private ErrorCallback onError;

    private boolean failed;

    public OBSRemoteController(String address, boolean debug, String password, boolean autoConnect) {
        this.address = address;
        this.debug = debug;
        this.password = password;

        client = new WebSocketClient();
        communicator = new OBSCommunicator(debug, password);

        if (autoConnect) {
            connect();
        }
    }

    public OBSRemoteController(String address, boolean debug, String password) {
        this(address, debug, password, true);
    }

    public OBSRemoteController(String address, boolean debug) {
        this(address, debug, null);
    }

    public void connect() {
        try {
            client.start();
        } catch (Exception e) {
            System.err.println("Failed to start WebSocketClient.");
            e.printStackTrace();
            runOnError("Failed to start WebSocketClient", e);
            return;
        }

        try {
            URI uri = new URI(address);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> connection = client.connect(communicator, uri, request);
            System.out.printf("Connecting to: %s%s.%n", uri, (password != null ? " with password" : ""));

            try {
                connection.get();
                failed = false;
            } catch (ExecutionException e) {
                if (e.getCause() instanceof ConnectException) {
                    System.out.println("Failed to connect to OBS.");
                    e.printStackTrace();

                    failed = true;

                    runOnConnectionFailed("Failed to connect to OBS");
                } else {
                    throw e;
                }
            }
        } catch (Throwable t) {
            System.err.println("Failed to setup connection with OBS.");
            t.printStackTrace();
            runOnConnectionFailed("Failed to setup connection with OBS");
        }
    }

    public void disconnect() {
        // wait for closed socket connection
        try {
            if (debug) {
                System.out.println("Closing connection.");
            }
            communicator.awaitClose(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            runOnError("Error during closing websocket connection", e);
        }

        if (!client.isStopped() && !client.isStopping()) {
            try {
                if (debug) {
                    System.out.println("Stopping client.");
                }
                client.stop();
            } catch (Exception e) {
                e.printStackTrace();
                runOnError("Error during stopping websocket client", e);
            }
        }
    }

    public boolean isFailed() {
        return failed;
    }

    public void getScenes(Callback callback) {
        communicator.getScenes(callback);
    }

    public void registerOnError(ErrorCallback onError) {
        this.onError = onError;
        communicator.registerOnError(onError);
    }

    public void registerConnectCallback(Callback onConnect) {
        communicator.registerOnConnect(onConnect);
    }

    public void registerDisconnectCallback(Callback onDisconnect) {
        communicator.registerOnDisconnect(onDisconnect);
    }

    public void registerConnectionFailedCallback(StringCallback onConnectionFailed) {
        this.onConnectionFailed = onConnectionFailed;
        communicator.registerOnConnectionFailed(onConnectionFailed);
    }

    public void registerReplayStartedCallback(Callback onReplayStarted) {
        communicator.registerOnReplayStarted(onReplayStarted);
    }

    public void registerReplayStartingCallback(Callback onReplayStarting) {
        communicator.registerOnReplayStarting(onReplayStarting);
    }

    public void registerReplayStoppedCallback(Callback onReplayStopped) {
        communicator.registerOnReplayStopped(onReplayStopped);
    }

    public void registerReplayStoppingCallback(Callback onReplayStopping) {
        communicator.registerOnReplayStopping(onReplayStopping);
    }

    public void registerSwitchScenesCallback(Callback onSwitchScenes) {
        communicator.registerOnSwitchScenes(onSwitchScenes);
    }

    public void registerScenesChangedCallback(Callback onScenesChanged) {
        communicator.registerOnScenesChanged(onScenesChanged);
    }

    public void registerTransitionBeginCallback(Callback onTransitionBegin) {
        communicator.registerOnTransitionBegin(onTransitionBegin);
    }

    public void registerTransitionEndCallback(Callback onTransitionEnd) {
        communicator.registerOnTransitionEnd(onTransitionEnd);
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
        communicator.setCurrentTransition(transition, response -> {
            if (!response.getStatus().equals("ok")) {
                System.out.println("Failed to change transition. Pls fix.");
                runOnError("Error response for changeSceneWithTransition", new OBSResponseError(response.getError()));
            }
            communicator.setCurrentScene(scene, callback);
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

    public void setSourceSettings(String sourceName, Map<String, Object> settings, Callback callback) {
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

    public void getVolume(String source, Callback callback) {
        communicator.getVolume(source, callback);
    }

    public void setVolume(String source, double volume, Callback callback) {
        communicator.setVolume(source, volume, callback);
    }

    public void setMute(String source, boolean mute, Callback callback) {
        communicator.setMute(source, mute, callback);
    }

    public void getPreviewScene(Callback callback) {
        communicator.getPreviewScene(callback);
    }

    public void setPreviewScene(String name, Callback callback) {
        communicator.setPreviewScene(name, callback);
    }

    public void getTransitionDuration(Callback callback) {
        communicator.getTransitionDuration(callback);
    }

    public void setTransitionDuration(int duration, Callback callback) {
        communicator.setTransitionDuration(duration, callback);
    }


    public void getStudioModeEnabled(Callback callback) {
        communicator.getStudioModeEnabled(callback);
    }

    public void setStudioModeEnabled(boolean enabled, Callback callback) {
        communicator.setStudioModeEnabled(enabled, callback);
    }

    public void startReplayBuffer(Callback callback) {
        communicator.startReplayBuffer(callback);
    }

    public void stopReplayBuffer(Callback callback) {
        communicator.stopReplayBuffer(callback);
    }

    public void saveReplayBuffer(Callback callback) {
        communicator.saveReplayBuffer(callback);
    }

    private void runOnError(String message, Throwable throwable) {
        if (onError == null) {
            return;
        }

        try {
            onError.run(message, throwable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void runOnConnectionFailed(String message) {
        if (onConnectionFailed == null) {
            return;
        }

        try {
            onConnectionFailed.run(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
