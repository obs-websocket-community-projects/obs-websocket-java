package net.twasi.obsremotejava.message.request.general;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.model.Projector;

@Getter
@ToString(callSuper = true)
public class OpenProjectorRequest extends Request {
    private final Data requestData;

    @Builder
    private OpenProjectorRequest(Projector.Type projectorType, Integer projectorMonitor, String projectorGeometry, String sourceName) {
        super(Type.OpenProjector);

        this.requestData = Data.builder().projectorType(projectorType).projectorMonitor(projectorMonitor).projectorGeometry(projectorGeometry).sourceName(sourceName).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final Projector.Type projectorType;
        @NonNull
        private final Integer projectorMonitor;
        @NonNull
        private final String projectorGeometry;
        private final String sourceName;
    }
}
