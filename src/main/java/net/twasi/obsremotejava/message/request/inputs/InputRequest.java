package net.twasi.obsremotejava.message.request.inputs;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
abstract class InputRequest extends Request {
    InputRequest(Type type) {
        super(type);
    }

    @Getter
    @ToString
    @SuperBuilder
    static class Data {
        @NonNull
        private final String inputName;
    }
}
