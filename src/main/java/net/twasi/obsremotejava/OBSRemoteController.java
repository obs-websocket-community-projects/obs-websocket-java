package net.twasi.obsremotejava;

import net.twasi.obsremotejava.events.models.*;
import net.twasi.obsremotejava.objects.throwables.OBSResponseError;
import net.twasi.obsremotejava.requests.GetAudioMonitorType.GetAudioMonitorTypeResponse;
import net.twasi.obsremotejava.requests.GetCurrentProfile.GetCurrentProfileResponse;
import net.twasi.obsremotejava.requests.GetCurrentScene.GetCurrentSceneResponse;
import net.twasi.obsremotejava.requests.GetPreviewScene.GetPreviewSceneResponse;
import net.twasi.obsremotejava.requests.GetSceneItemProperties.GetSceneItemPropertiesResponse;
import net.twasi.obsremotejava.requests.GetSceneList.GetSceneListResponse;
import net.twasi.obsremotejava.requests.GetSourceFilterInfo.GetSourceFilterInfoResponse;
import net.twasi.obsremotejava.requests.GetSourceFilters.GetSourceFiltersResponse;
import net.twasi.obsremotejava.requests.GetSourceSettings.GetSourceSettingsResponse;
import net.twasi.obsremotejava.requests.GetSourcesList.GetSourcesListResponse;
import net.twasi.obsremotejava.requests.GetSpecialSources.GetSpecialSourcesResponse;
import net.twasi.obsremotejava.requests.GetStreamingStatus.GetStreamingStatusResponse;
import net.twasi.obsremotejava.requests.GetStudioModeEnabled.GetStudioModeEnabledResponse;
import net.twasi.obsremotejava.requests.GetTransitionDuration.GetTransitionDurationResponse;
import net.twasi.obsremotejava.requests.GetTransitionList.GetTransitionListResponse;
import net.twasi.obsremotejava.requests.GetVersion.GetVersionResponse;
import net.twasi.obsremotejava.requests.GetVolume.GetVolumeResponse;
import net.twasi.obsremotejava.requests.ListProfiles.ListProfilesResponse;
import net.twasi.obsremotejava.requests.NextMedia.NextMediaResponse;
import net.twasi.obsremotejava.requests.PlayPauseMedia.PlayPauseMediaResponse;
import net.twasi.obsremotejava.requests.PreviousMedia.PreviousMediaResponse;
import net.twasi.obsremotejava.requests.RefreshBrowserSource.RefreshBrowserSourceResponse;
import net.twasi.obsremotejava.requests.RestartMedia.RestartMediaResponse;
import net.twasi.obsremotejava.requests.SaveReplayBuffer.SaveReplayBufferResponse;
import net.twasi.obsremotejava.requests.SetAudioMonitorType.SetAudioMonitorTypeResponse;
import net.twasi.obsremotejava.requests.SetCurrentProfile.SetCurrentProfileResponse;
import net.twasi.obsremotejava.requests.SetCurrentScene.SetCurrentSceneResponse;
import net.twasi.obsremotejava.requests.SetCurrentTransition.SetCurrentTransitionResponse;
import net.twasi.obsremotejava.requests.SetMute.SetMuteResponse;
import net.twasi.obsremotejava.requests.SetPreviewScene.SetPreviewSceneResponse;
import net.twasi.obsremotejava.requests.SetSceneItemProperties.SetSceneItemPropertiesResponse;
import net.twasi.obsremotejava.requests.SetSourceFilterSettings.SetSourceFilterSettingsResponse;
import net.twasi.obsremotejava.requests.SetSourceFilterVisibility.SetSourceFilterVisibilityResponse;
import net.twasi.obsremotejava.requests.SetSourceSettings.SetSourceSettingsResponse;
import net.twasi.obsremotejava.requests.SetStudioModeEnabled.SetStudioModeEnabledResponse;
import net.twasi.obsremotejava.requests.SetTransitionDuration.SetTransitionDurationResponse;
import net.twasi.obsremotejava.requests.SetVolume.SetVolumeResponse;
import net.twasi.obsremotejava.requests.StartRecording.StartRecordingResponse;
import net.twasi.obsremotejava.requests.StartReplayBuffer.StartReplayBufferResponse;
import net.twasi.obsremotejava.requests.StartStreaming.StartStreamingResponse;
import net.twasi.obsremotejava.requests.StopMedia.StopMediaResponse;
import net.twasi.obsremotejava.requests.StopRecording.StopRecordingResponse;
import net.twasi.obsremotejava.requests.StopReplayBuffer.StopReplayBufferResponse;
import net.twasi.obsremotejava.requests.StopStreaming.StopStreamingResponse;
import net.twasi.obsremotejava.requests.TakeSourceScreenshot.TakeSourceScreenshotResponse;
import net.twasi.obsremotejava.requests.TransitionToProgram.TransitionToProgramResponse;
import net.twasi.obsremotejava.requests.TriggerHotkeyByName.TriggerHotkeyByNameResponse;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ConnectException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class OBSRemoteController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    private String address;
    private final boolean debug;
    private final OBSCommunicator communicator;
    private final String password;
    private final WebSocketClient client;

    private Consumer<String> onConnectionFailed;
    private BiConsumer<String, Throwable> onError;

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
        }
        catch (Exception e) {
            runOnError("Failed to start WebSocketClient", e);
            return;
        }

        try {
            URI uri = new URI(address);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> connection = client.connect(communicator, uri, request);
            log.info(String.format("Connecting to: %s%s.%n", uri, (password != null ? " with password" : " (no password)")));
            try {
                connection.get();
                failed = false;
            }
            catch (ExecutionException e) {
                if (e.getCause() instanceof ConnectException) {
                    failed = true;
                    runOnConnectionFailed("Failed to connect to OBS! Is it running and is the websocket plugin installed?", e);
                }
                else {
                    throw e;
                }
            }
        }
        catch (Throwable t) {
            runOnConnectionFailed("Failed to setup connection with OBS", t);
        }
    }

    public void disconnect() {
        // trigger the latch
        try {
            if (debug) {
                log.debug("Closing connection.");
            }
            communicator.awaitClose(1, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            runOnError("Error during closing websocket connection", e);
        }

        // stop the client if it isn't already stopped or stopping
        if (!client.isStopped() && !client.isStopping()) {
            try {
                if (debug) {
                    log.debug("Stopping client.");
                }
                client.stop();
            }
            catch (Exception e) {
                runOnError("Error during stopping websocket client", e);
            }
        }
    }

    public boolean isFailed() {
        return failed;
    }

    public void getScenes(Consumer<GetSceneListResponse> callback) {
        communicator.getScenes(callback);
    }

    public void getSourcesList(Consumer<GetSourcesListResponse> callback) {
        communicator.getSourcesList(callback);
    }

    public void registerOnError(BiConsumer<String, Throwable> onError) {
        this.onError = onError;
        communicator.registerOnError(onError);
    }

    public void registerConnectCallback(Consumer<GetVersionResponse> onConnect) {
        communicator.registerOnConnect(onConnect);
    }

    public void registerDisconnectCallback(Runnable onDisconnect) {
        communicator.registerOnDisconnect(onDisconnect);
    }

    public void registerConnectionFailedCallback(Consumer<String> onConnectionFailed) {
        this.onConnectionFailed = onConnectionFailed;
        communicator.registerOnConnectionFailed(onConnectionFailed);
    }

    public void registerCloseCallback(BiConsumer<Integer, String> closeCallback) {
        communicator.registerOnClose(closeCallback);
    }

    public void registerRecordingStartedCallback(Runnable onRecordingStarted) {
        communicator.registerOnRecordingStarted(onRecordingStarted);
    }

    public void registerRecordingStoppedCallback(Runnable onRecordingStopped) {
        communicator.registerOnRecordingStopped(onRecordingStopped);
    }

    public void registerReplayStartedCallback(Runnable onReplayStarted) {
        communicator.registerOnReplayStarted(onReplayStarted);
    }

    public void registerReplayStartingCallback(Runnable onReplayStarting) {
        communicator.registerOnReplayStarting(onReplayStarting);
    }

    public void registerReplayStoppedCallback(Runnable onReplayStopped) {
        communicator.registerOnReplayStopped(onReplayStopped);
    }

    public void registerReplayStoppingCallback(Runnable onReplayStopping) {
        communicator.registerOnReplayStopping(onReplayStopping);
    }

    public void registerStreamStartedCallback(Runnable onRecordingStarted) {
        communicator.registerOnStreamStarted(onRecordingStarted);
    }

    public void registerStreamStoppedCallback(Runnable onRecordingStopped) {
        communicator.registerOnStreamStopped(onRecordingStopped);
    }

    public void registerOnMediaPlaying(Consumer<MediaPlayingEvent> onMediaPlaying) {
        communicator.registerOnMediaPlaying(onMediaPlaying);
    }

    public void registerOnMediaPaused(Consumer<MediaPausedEvent> onMediaPaused) {
        communicator.registerOnMediaPaused(onMediaPaused);
    }

    public void registerOnMediaRestarted(Consumer<MediaRestartedEvent> onMediaRestarted) {
        communicator.registerOnMediaRestarted(onMediaRestarted);
    }

    public void registerOnMediaStopped(Consumer<MediaStoppedEvent> onMediaStopped) {
        communicator.registerOnMediaStopped(onMediaStopped);
    }

    public void registerOnMediaNext(Consumer<MediaNextEvent> onMediaNext) {
        communicator.registerOnMediaNext(onMediaNext);
    }

    public void registerOnMediaPrevious(Consumer<MediaPreviousEvent> onMediaPrevious) {
        communicator.registerOnMediaPrevious(onMediaPrevious);
    }

    public void registerOnMediaStarted(Consumer<MediaStartedEvent> onMediaStarted) {
        communicator.registerOnMediaStarted(onMediaStarted);
    }

    public void registerOnMediaEnded(Consumer<MediaEndedEvent> onMediaEnded) {
        communicator.registerOnMediaEnded(onMediaEnded);
    }

    public void registerSwitchScenesCallback(Consumer<SwitchScenesEvent> onSwitchScenes) {
        communicator.registerOnSwitchScenes(onSwitchScenes);
    }

    public void registerScenesChangedCallback(Consumer<ScenesChangedEvent> onScenesChanged) {
        communicator.registerOnScenesChanged(onScenesChanged);
    }

    public void registerSwitchTransitionCallback(Consumer<SwitchTransitionEvent> onSwitchTransition) {
        communicator.registerOnSwitchTransition(onSwitchTransition);
    }

    public void registerTransitionListChangedCallback(Consumer<TransitionListChangedEvent> onTransitionListChanged) {
        communicator.registerOnTransitionListChanged(onTransitionListChanged);
    }

    public void registerTransitionBeginCallback(Consumer<TransitionBeginEvent> onTransitionBegin) {
        communicator.registerOnTransitionBegin(onTransitionBegin);
    }

    public void registerTransitionEndCallback(Consumer<TransitionEndEvent> onTransitionEnd) {
        communicator.registerOnTransitionEnd(onTransitionEnd);
    }

    public void registerSourceFilterVisibilityChangedCallback(Consumer<SourceFilterVisibilityChangedEvent> onSourceVisibilityChanged) {
        communicator.registerOnSourceFilterVisibilityChanged(onSourceVisibilityChanged);
    }

    public void registerOnSourceVolumeChanged(Consumer<SourceVolumeChangedEvent> onSourceVolumeChanged) {
        communicator.registerOnSourceVolumeChanged(onSourceVolumeChanged);
    }

    public void registerPreviewSceneChangesCallback(Consumer<PreviewSceneChangedEvent> onPreviewSceneChanged) {
        communicator.registerOnPreviewSceneChanged(onPreviewSceneChanged);
    }

    public void await() throws InterruptedException {
        communicator.await();
    }

    public void setCurrentScene(String scene, Consumer<SetCurrentSceneResponse> callback) {
        communicator.setCurrentScene(scene, callback);
    }

    public void setCurrentTransition(String transition, Consumer<SetCurrentTransitionResponse> callback) {
        communicator.setCurrentTransition(transition, callback);
    }

    public void changeSceneWithTransition(final String scene, String transition, final Consumer<SetCurrentSceneResponse> callback) {
        communicator.setCurrentTransition(transition, response -> {
            if (!response.getStatus().equals("ok")) {
                log.error("Failed to change transition. Pls fix.");
                runOnError("Error response for changeSceneWithTransition", new OBSResponseError(response.getError()));
            }
            communicator.setCurrentScene(scene, callback);
        });
    }

    public void setSourceVisibility(String scene, String source, boolean visibility, Consumer<SetSceneItemPropertiesResponse> callback) {
        communicator.setSourceVisiblity(scene, source, visibility, callback);
    }

    public void getSceneItemProperties(String scene, String source, Consumer<GetSceneItemPropertiesResponse> callback) {
        communicator.getSceneItemProperties(scene, source, callback);
    }

    public void getSourceFilters(String sourceName, Consumer<GetSourceFiltersResponse> callback) {
        communicator.getSourceFilters(sourceName, callback);
    }

    public void getSourceFilterInfo(String sourceName, String filterName, Consumer<GetSourceFilterInfoResponse> callback) {
        communicator.getSourceFilterInfo(sourceName, filterName, callback);
    }

    public void setSourceFilterVisibility(String sourceName, String filterName, boolean filterEnabled, Consumer<SetSourceFilterVisibilityResponse> callback) {
        communicator.setSourceFilterVisibility(sourceName, filterName, filterEnabled, callback);
    }

    public void getTransitionList(Consumer<GetTransitionListResponse> callback) {
        communicator.getTransitionList(callback);
    }

    public void transitionToProgram(String transitionName, int duration, Consumer<TransitionToProgramResponse> callback) {
        communicator.transitionToProgram(transitionName, duration, callback);
    }

    public void getSourceSettings(String sourceName, Consumer<GetSourceSettingsResponse> callback) {
        communicator.getSourceSettings(sourceName, callback);
    }

    public void setSourceSettings(String sourceName, Map<String, Object> settings, Consumer<SetSourceSettingsResponse> callback) {
        communicator.setSourceSettings(sourceName, settings, callback);
    }

    public void setSourceFilterSettings(String sourceName, String filterName, Map<String, Object> settings, Consumer<SetSourceFilterSettingsResponse> callback) {
        communicator.setSourceFilterSettings(sourceName, filterName, settings, callback);
    }

    public void takeSourceScreenshot(String sourceName, String embedPictureFormat, String saveToFilePath, String fileFormat, Integer compressionQuality, Integer width, Integer height, Consumer<TakeSourceScreenshotResponse> callback) {
        communicator.takeSourceScreenshot(sourceName, embedPictureFormat, saveToFilePath, fileFormat, compressionQuality, width, height, callback);
    }

    public void takeSourceScreenshot(Consumer<TakeSourceScreenshotResponse> callback) {
        communicator.takeSourceScreenshot(callback);
    }

    public void takeSourceScreenshotToEmbed(String sourceName, String embedPictureFormat, Integer compressionQuality, Integer width, Integer height, Consumer<TakeSourceScreenshotResponse> callback) {
        communicator.takeSourceScreenshotToEmbed(sourceName, embedPictureFormat, compressionQuality, width, height, callback);
    }

    public void takeSourceScreenshotToFile(String sourceName, String saveToFilePath, String fileFormat, Integer compressionQuality, Integer width, Integer height, Consumer<TakeSourceScreenshotResponse> callback) {
        communicator.takeSourceScreenshotToFile(sourceName, saveToFilePath, fileFormat, compressionQuality, width, height, callback);
    }

    public void getStreamingStatus(Consumer<GetStreamingStatusResponse> callback) {
        communicator.getStreamingStatus(callback);
    }

    public void startStreaming(Consumer<StartStreamingResponse> callback) {
        communicator.startStreaming(callback);
    }

    public void stopStreaming(Consumer<StopStreamingResponse> callback) {
        communicator.stopStreaming(callback);
    }

    public void startRecording(Consumer<StartRecordingResponse> callback) {
        communicator.startRecording(callback);
    }

    public void stopRecording(Consumer<StopRecordingResponse> callback) {
        communicator.stopRecording(callback);
    }

    public void listProfiles(Consumer<ListProfilesResponse> callback) {
        communicator.listProfiles(callback);
    }

    public void getCurrentProfile(Consumer<GetCurrentProfileResponse> callback) {
        communicator.getCurrentProfile(callback);
    }

    public void setCurrentProfile(String profile, Consumer<SetCurrentProfileResponse> callback) {
        communicator.setCurrentProfile(profile, callback);
    }

    public void getCurrentScene(Consumer<GetCurrentSceneResponse> callback) {
        communicator.getCurrentScene(callback);
    }

    public void getVolume(String source, Consumer<GetVolumeResponse> callback) {
        communicator.getVolume(source, callback);
    }

    public void setVolume(String source, double volume, Consumer<SetVolumeResponse> callback) {
        communicator.setVolume(source, volume, callback);
    }

    public void setMute(String source, boolean mute, Consumer<SetMuteResponse> callback) {
        communicator.setMute(source, mute, callback);
    }

    public void getPreviewScene(Consumer<GetPreviewSceneResponse> callback) {
        communicator.getPreviewScene(callback);
    }

    public void setPreviewScene(String name, Consumer<SetPreviewSceneResponse> callback) {
        communicator.setPreviewScene(name, callback);
    }

    public void getTransitionDuration(Consumer<GetTransitionDurationResponse> callback) {
        communicator.getTransitionDuration(callback);
    }

    public void setTransitionDuration(int duration, Consumer<SetTransitionDurationResponse> callback) {
        communicator.setTransitionDuration(duration, callback);
    }


    public void getStudioModeEnabled(Consumer<GetStudioModeEnabledResponse> callback) {
        communicator.getStudioModeEnabled(callback);
    }

    public void setStudioModeEnabled(boolean enabled, Consumer<SetStudioModeEnabledResponse> callback) {
        communicator.setStudioModeEnabled(enabled, callback);
    }

    public void startReplayBuffer(Consumer<StartReplayBufferResponse> callback) {
        communicator.startReplayBuffer(callback);
    }

    public void stopReplayBuffer(Consumer<StopReplayBufferResponse> callback) {
        communicator.stopReplayBuffer(callback);
    }

    public void saveReplayBuffer(Consumer<SaveReplayBufferResponse> callback) {
        communicator.saveReplayBuffer(callback);
    }

    public void playPauseMedia(String sourceName, Boolean playPause, Consumer<PlayPauseMediaResponse> callback) {
        communicator.playPauseMedia(sourceName, playPause, callback);
    }

    public void playMedia(String sourceName, Consumer<PlayPauseMediaResponse> callback) {
        communicator.playPauseMedia(sourceName, false, callback);
    }

    public void pauseMedia(String sourceName, Consumer<PlayPauseMediaResponse> callback) {
        communicator.playPauseMedia(sourceName, true, callback);
    }

    public void toggleMedia(String sourceName, Consumer<PlayPauseMediaResponse> callback) {
        communicator.playPauseMedia(sourceName, null, callback);
    }

    public void restartMedia(String sourceName, Consumer<RestartMediaResponse> callback) {
        communicator.restartMedia(sourceName, callback);
    }

    public void stopMedia(String sourceName, Consumer<StopMediaResponse> callback) {
        communicator.stopMedia(sourceName, callback);
    }

    public void nextMedia(String sourceName, Consumer<NextMediaResponse> callback) {
        communicator.nextMedia(sourceName, callback);
    }

    public void previousMedia(String sourceName, Consumer<PreviousMediaResponse> callback) {
        communicator.previousMedia(sourceName, callback);
    }

    public void refreshBrowserSource(String sourceName, Consumer<RefreshBrowserSourceResponse> callback) {
        communicator.refreshBrowserSource(sourceName, callback);
    }

    public void getAudioMonitorType(String sourceName, Consumer<GetAudioMonitorTypeResponse> callback) {
        communicator.getAudioMonitorType(sourceName, callback);
    }

    public void setAudioMonitorType(String sourceName, GetAudioMonitorTypeResponse.MonitorType monitorType, Consumer<SetAudioMonitorTypeResponse> callback) {
        communicator.setAudioMonitorType(sourceName, monitorType, callback);
    }

    public void getSpecialSources(Consumer<GetSpecialSourcesResponse> callback) {
        communicator.getSpecialSources(callback);
    }

    public void triggerHotkeyByName(String hotkeyName, Consumer<TriggerHotkeyByNameResponse> callback) {
        communicator.triggerHotkeyByName(hotkeyName, callback);
    }

    private void runOnError(String message, Throwable throwable) {
        log.debug("Running onError with message: " + message + " and exception:", throwable);
        if (onError == null) {
            log.debug("No onError callback was registered");
            return;
        }

        try {
            onError.accept(message, throwable);
        }
        catch (Exception e) {
            log.error("Unable to run OnError callback", e);
        }
    }

    private void runOnConnectionFailed(String message, Throwable throwable) {
        log.debug("Running onConnectionFailed with message: " + message + " with exception:", throwable);

        if (onConnectionFailed == null) {
            log.debug("No onConnectionFailed callback was registered");
            return;
        }

        try {
            onConnectionFailed.accept(message);
        }
        catch (Exception e) {
            log.error("Unable to run OnConnectionFailed callback", e);
        }
    }
}
