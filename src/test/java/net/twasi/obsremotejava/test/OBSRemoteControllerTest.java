package net.twasi.obsremotejava.test;

import net.twasi.obsremotejava.OBSRemoteController;
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

        controller.registerDisconnectCallback(() -> testFailedReason.set("onDisconnected called unexpectedly"));
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

        controller.registerDisconnectCallback(() -> testFailedReason.set("onDisconnected called unexpectedly"));
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
