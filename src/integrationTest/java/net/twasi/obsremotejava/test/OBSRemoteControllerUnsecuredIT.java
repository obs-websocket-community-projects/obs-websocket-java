package net.twasi.obsremotejava.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.atomic.AtomicReference;
import net.twasi.obsremotejava.OBSRemoteController;
import org.assertj.core.api.Fail;
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

    @Disabled // failing
    @Test
    void testConnectAndDisconnect() {
        AtomicReference<Boolean> testSuccessful = new AtomicReference<>(Boolean.FALSE);
        AtomicReference<String> testFailedReason = new AtomicReference<>();

//        final OBSRemoteController controller = new OBSRemoteController(obsAddress, true,
//          obsPassword, true);
        final OBSRemoteController controller = OBSRemoteController.builder()
          .password(obsPassword)
          .autoConnect(true)
          .lifecycle()
            .onClose((comm, codeReason) -> {
                if(codeReason.getCode() == null) {
                    testSuccessful.set(Boolean.TRUE);
                } else {
                    testFailedReason.set("onConnectionFailed called unexpectedly: " + codeReason.getCode() + " - " + codeReason.getReason());
                }
            })
            .onError((comm, reasonThrowable) -> {
                testFailedReason.set("onError called unexpectedly");
                comm.disconnect();
            })
            .and()
          .build();

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
          .onClose((contr, codeReason) -> {
              if(codeReason.getCode() == null) {
                  testSuccessful.set(Boolean.TRUE);
              } else {
                  testFailedReason.set("onConnectionFailed called unexpectedly: " + codeReason);
              }
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
    void disconnectShouldNotHaveErrorsWhenNoConnectDisconnectCallbacksRegistered() {
        AtomicReference<String> testFailedReason = new AtomicReference<>();

        // Given a controller that auto-connects...When connected
//        final OBSRemoteController controller = new OBSRemoteController(obsAddress, true,
//                obsPassword, true);
        final OBSRemoteController controller = OBSRemoteController.builder()
          .password(obsPassword)
          .autoConnect(true)
          .lifecycle()
                // And given no callbacks registered for connect/disconnect
              .onClose((contr, codeReason) -> {
                  if(codeReason.getCode() == null) {
                      // do nothing
                  } else {
                      testFailedReason.set("onConnectionFailed called unexpectedly: " + codeReason);
                  }
              })
              .onError((contr, reasonThrowable) -> {
                  testFailedReason.set("onError called unexpectedly");
                  contr.disconnect();
              })
          .and()
        .build();

        // Then no errors should have occurred
        if (controller.isFailed()) {
            fail("Failed to connect to websocket");
        }

        // And given on connection failure and on error callbacks are set
//        controller.registerConnectionFailedCallback(message ->
//                testFailedReason.set("ConnectionFailedCallback called unexpectedly")
//        );
//        controller.registerOnError((message, throwable) ->
//                testFailedReason.set("OnError called unexpectedly")
//        );

        // When disconnected
        controller.disconnect();

        // Then the error or connection failure callbacks should not have been called
        if (testFailedReason.get() != null) {
            fail(testFailedReason.get());
        }
    }

    // TODO: Move to unit test on DelegatingLifecycleListener
//    @Test
//    void disconnectShouldNotHaveErrorsWhenConnectDisconnectCallbacksThrowErrors() {
//        AtomicReference<String> testFailedReason = new AtomicReference<>();
//
//        // Given controller that auto-connects...When connected
////        final OBSRemoteController controller = new OBSRemoteController(obsAddress, true,
////                obsPassword, true);
//        final OBSRemoteController controller = OBSRemoteController.builder()
//          .password(obsPassword)
//          .autoConnect(true)
//          .communicator().lifecycle()
//              // And given no callbacks registered for connect/disconnect
//              .onClose((code, reason) -> {
//                  if(code == null) {
//                      // do nothing
//                  } else {
//                      testFailedReason.set("onConnectionFailed called unexpectedly: " + code + " - " + reason);
//                  }
//              })
//              .onError((message, throwable) -> {
//                  testFailedReason.set("onError called unexpectedly");
//              })
//              .and()
//          .and()
//          .build();
//
//        // Then no failure was expected on connection
//        if (controller.isFailed()) {
//            fail("Failed to connect to websocket");
//        }
//
//        // And given (invalid) connect and disconnect callbacks are registered
//        controller.registerDisconnectCallback(() -> {
//            throw new Error("Disconnect callback error");
//        });
//        controller.registerConnectCallback(response -> {
//            throw new Error("Connect callback error");
//        });
//
//        // And given on connection failure and on error callbacks are set
//        controller.registerConnectionFailedCallback(message ->
//                testFailedReason.set("ConnectionFailedCallback called unexpectedly")
//        );
//        controller.registerOnError((message, throwable) ->
//                testFailedReason.set("OnError called unexpectedly")
//        );
//
//        // When the controller is disconnected
//        controller.disconnect();
//
//        // Then the connection failure and error callbacks should NOT have been called
//        if (testFailedReason.get() != null) {
//            fail(testFailedReason.get());
//        }
//    }

    // TODO: Unit test for DelegatingLifecycleListener
//    @Test
//    void testConnectionFailWithNoCallbacksRegistered() {
//        AtomicReference<String> testFailedReason = new AtomicReference<>();
//
//        final OBSRemoteController controller = new OBSRemoteController("ws://garbish:noport", true,
//                null, true);
//
//        if (controller.isFailed()) {
//            fail("Failed to connect to websocket");
//        }
//
//        controller.registerConnectionFailedCallback(null);
//        controller.registerOnError((message, throwable) -> testFailedReason.set("OnError called unexpectedly"));
//
//        controller.disconnect();
//
//        if (testFailedReason.get() != null) {
//            fail(testFailedReason.get());
//        }
//    }
}
