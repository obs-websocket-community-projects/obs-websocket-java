package net.twasi.obsremotejava.test;

import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.callbacks.Callback;
import net.twasi.obsremotejava.events.responses.ScenesChangedResponse;
import net.twasi.obsremotejava.events.responses.SwitchScenesResponse;
import net.twasi.obsremotejava.events.responses.TransitionBeginResponse;
import net.twasi.obsremotejava.events.responses.TransitionEndResponse;
import net.twasi.obsremotejava.requests.GetVersion.GetVersionResponse;
import net.twasi.obsremotejava.requests.ResponseBase;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class OBSRemoteControllerTest {

    @Test
    void testConnectionToNonExistingHostAndExpectConnectionFailedError() {
        AtomicReference<String> testFailedReason = new AtomicReference<>();
        AtomicReference<String> connectionFailedResult = new AtomicReference<>();

        final OBSRemoteController controller = new OBSRemoteController("ws://giberish:noport", false,
                                                                       null, false);

        if (controller.isFailed()) {
            fail("isFailed is set unexpectedly");
        }

        controller.registerDisconnectCallback(response -> testFailedReason.set("onDisconnected called unexpectedly"));
        controller.registerConnectCallback(response -> testFailedReason.set("onConnected called unexpectedly"));
        controller.registerConnectionFailedCallback(connectionFailedResult::set);
        controller.registerOnError((message, throwable) -> testFailedReason.set("onError called unexpectedly"));

        controller.connect();

        if (testFailedReason.get() != null) {
            fail(testFailedReason.get());
        }

        assertEquals("Failed to setup connection with OBS", connectionFailedResult.get());
        assertFalse(controller.isFailed());
    }

    @Test
    void testConnectionToWrongPortAndExpectConnectionFailedError() {
        AtomicReference<String> testFailedReason = new AtomicReference<>();
        AtomicReference<String> connectionFailedResult = new AtomicReference<>();

        final OBSRemoteController controller = new OBSRemoteController("ws://localhost:1", false,
                                                                       null, false);

        if (controller.isFailed()) {
            fail("isFailed is set unexpectedly");
        }

        controller.registerDisconnectCallback(response -> testFailedReason.set("onDisconnected called unexpectedly"));
        controller.registerConnectCallback(response -> testFailedReason.set("onConnected called unexpectedly"));
        controller.registerConnectionFailedCallback(connectionFailedResult::set);
        controller.registerOnError((message, throwable) -> testFailedReason.set("onError called unexpectedly"));

        controller.connect();

        if (testFailedReason.get() != null) {
            fail(testFailedReason.get());
        }

        assertThat(connectionFailedResult.get()).contains("Failed to connect to OBS");
        assertTrue(controller.isFailed());
    }
}
