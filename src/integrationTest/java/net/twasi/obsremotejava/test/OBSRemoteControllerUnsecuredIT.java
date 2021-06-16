package net.twasi.obsremotejava.test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.atomic.AtomicReference;
import net.twasi.obsremotejava.OBSRemoteController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class OBSRemoteControllerUnsecuredIT {

    /**
     * - Setup OBS with the below address, and disable authentication
     * - Make sure your OBS is running and available for connection
     */
    private final String host = "localhost";
    private final int port = 4444;
    private final String obsAddress = "ws://" + host + ":" + port;
    private final String obsPassword = null;

    @Test
    void testConnectAndDisconnect() {
        AtomicReference<Boolean> testSuccessful = new AtomicReference<>(Boolean.FALSE);
        AtomicReference<String> testFailedReason = new AtomicReference<>();

        final OBSRemoteController controller = OBSRemoteController.builder()
          .password(obsPassword)
          .autoConnect(true)
          .lifecycle()
            // Given we expect a non-error close
            .onDisconnect((contr) -> {
                testSuccessful.set(Boolean.TRUE);
            })
            // And no errors
            .onError((contr, reasonThrowable) -> {
                testFailedReason.set("onError called unexpectedly");
                contr.disconnect();
            })
            // And we disconnect once fully identified/connected
            .onReady((OBSRemoteController::disconnect))
            .and()
          .build();

        // If it is failed then fail
        if (controller.isFailed()) {
            fail("Failed to connect to websocket");
        }

//        controller.registerDisconnectCallback(() -> testSuccessful.set(Boolean.TRUE));
//        controller.registerConnectCallback(response -> controller.disconnect());
//
//        controller.registerConnectionFailedCallback(message -> {
//            testFailedReason.set("onConnectionFailed called unexpectedly");
//            controller.disconnect();
//        });
//        controller.registerOnError((message, throwable) -> {
//            testFailedReason.set("onError called unexpectedly");
//            controller.disconnect();
//        });

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

        AtomicReference<Boolean> testSuccessful = new AtomicReference<>(Boolean.FALSE);
        AtomicReference<String> testFailedReason = new AtomicReference<>();

        // Given a controller that connects successfully
//        final OBSRemoteController controller = new OBSRemoteController(obsAddress, true,
//                obsPassword, true);
        final OBSRemoteController controller = OBSRemoteController.builder()
          .password(obsPassword)
          .autoConnect(true)
          .lifecycle()
          .onDisconnect((contr) -> {
              testSuccessful.set(Boolean.TRUE);
          })
          .onError((contr, reasonThrowable) -> {
              testFailedReason.set("onError called unexpectedly");
              contr.disconnect();
          })
        .and()
        .build();

        if (controller.isFailed()) {
            fail("Failed to connect to websocket");
        }

        // When we register a Close callback
//        controller.registerCloseCallback((Integer statusCode, String reason) -> testSuccessful.set(Boolean.TRUE));

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
    void testConnectionToNonExistingHostAndExpectConnectionFailedError() {
        AtomicReference<String> testFailedReason = new AtomicReference<>();
        AtomicReference<String> connectionFailedResult = new AtomicReference<>();

//        final OBSRemoteController controller = new OBSRemoteController("ws://giberish:noport", false,
//          null, false);
        OBSRemoteController controller = OBSRemoteController.builder()
          .host("gibberish")
          .port(4444)
          .autoConnect(true)
          .lifecycle()
            .onReady((contr) -> testFailedReason.set("Controller should NOT be ready"))
            .onDisconnect((contr) -> testFailedReason.set("Controller never connected, it cannot have ever disconnected"))
            .onError((contr, reasonThrowable) -> connectionFailedResult.set(reasonThrowable.getReason()))
          .and()
          .build();

        if (controller.isFailed()) {
            fail("isFailed is set unexpectedly");
        }

//        controller.registerDisconnectCallback(() -> testFailedReason.set("onDisconnected called unexpectedly"));
//        controller.registerConnectCallback(response -> testFailedReason.set("onConnected called unexpectedly"));
//        controller.registerConnectionFailedCallback(connectionFailedResult::set);
//        controller.registerOnError((message, throwable) -> testFailedReason.set("onError called unexpectedly"));
//
//        controller.connect();

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

//        final OBSRemoteController controller = new OBSRemoteController("ws://localhost:1", false,
//          null, false);
        OBSRemoteController controller = OBSRemoteController.builder()
          .host("localhost")
          .port(1)
          .autoConnect(true)
          .lifecycle()
              .onReady((contr) -> testFailedReason.set("Controller should NOT be ready"))
              .onDisconnect((contr) -> testFailedReason.set("Controller never connected, it cannot have ever disconnected"))
              .onError((contr, reasonThrowable) -> connectionFailedResult.set(reasonThrowable.getReason()))
          .and()
          .build();

        if (!controller.isFailed()) {
            fail("isFailed is set unexpectedly");
        }

//        controller.registerDisconnectCallback(() -> testFailedReason.set("onDisconnected called unexpectedly"));
//        controller.registerConnectCallback(response -> testFailedReason.set("onConnected called unexpectedly"));
//        controller.registerConnectionFailedCallback(connectionFailedResult::set);
//        controller.registerOnError((message, throwable) -> testFailedReason.set("onError called unexpectedly"));
//
//        controller.connect();

        if (testFailedReason.get() != null) {
            fail(testFailedReason.get());
        }

        assertThat(connectionFailedResult.get()).contains("Failed to connect to OBS");
        assertTrue(controller.isFailed());
    }

    @Disabled
    @Test
    void controllerDisconnectsWhenObsCannotBeContacted() {
        fail("to do, #34");
    }

    @Disabled
    @Test
    void controllerDisconnectsWhenObsCannotIdentifyClient() {
        fail("to do, #34");
    }

}
