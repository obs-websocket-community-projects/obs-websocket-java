package net.twasi.obsremotejava.model.throwables;

import javax.management.openmbean.InvalidKeyException;

public class InvalidResponseTypeError extends InvalidKeyException {
    public InvalidResponseTypeError(String s) {
        super(s);
    }
}
