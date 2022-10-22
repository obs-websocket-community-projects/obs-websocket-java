package io.obswebsocket.community.client;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class BlockingConsumer<T> implements Consumer<T> {

  private final CountDownLatch latch = new CountDownLatch(1);
  private T result;

  @Override
  public void accept(T t) {
    this.result = t;
    latch.countDown();
  }

  public T get(long timeout) throws InterruptedException {
    if (!latch.await(timeout, TimeUnit.MILLISECONDS)) {
      log.warn("Timeout waiting for result");
    }
    return result;
  }
}
