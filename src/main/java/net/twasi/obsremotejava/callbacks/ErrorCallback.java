package net.twasi.obsremotejava.callbacks;

public interface ErrorCallback {
    void run(String message, Throwable throwable);
}
