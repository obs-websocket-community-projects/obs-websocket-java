package net.twasi.obsremotejava.test;

import net.twasi.obsremotejava.OBSRemoteController;
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
    void testConnectAndDisconnect() {
        AtomicReference<Boolean> testSuccessful = new AtomicReference<>(Boolean.FALSE);
        AtomicReference<String> testFailedReason = new AtomicReference<>();

        final OBSRemoteController controller = new OBSRemoteController(obsAddress, true,
                obsPassword, true);

        if (controller.isFailed()) {
            fail("Failed to connect to websocket");
        }

        controller.registerDisconnectCallback(() -> testSuccessful.set(Boolean.TRUE));
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
    void testCloseCallback() {

        // Given a controller that connects successfully
        final OBSRemoteController controller = new OBSRemoteController(obsAddress, true,
                obsPassword, true);

        if (controller.isFailed()) {
            fail("Failed to connect to websocket");
        }

        // When we register a Close callback
        AtomicReference<Boolean> testSuccessful = new AtomicReference<>(Boolean.FALSE);
        AtomicReference<String> testFailedReason = new AtomicReference<>();

        controller.registerCloseCallback((Integer statusCode, String reason) -> testSuccessful.set(Boolean.TRUE));

        // When we disconnect
        try {
            controller.disconnect();
            controller.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Then the close callback should have been called
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
        controller.registerDisconnectCallback(() -> {
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
