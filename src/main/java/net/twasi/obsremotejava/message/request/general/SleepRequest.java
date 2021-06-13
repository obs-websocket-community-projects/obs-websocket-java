package net.twasi.obsremotejava.message.request.general;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class SleepRequest extends Request {
    private final Data requestData;

    public SleepRequest(Long sleepMillis) {
        super(Type.Sleep);

        this.requestData = Data.builder().sleepMillis(sleepMillis).build();
    }

    @Getter
    @ToString
    @Builder
    public static class Data {
        private final Long sleepMillis;
    }
}
