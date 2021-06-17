package net.twasi.obsremotejava.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Input {
    private String inputName;
    private String inputKind;
    private String unversionedInputKind;
}
