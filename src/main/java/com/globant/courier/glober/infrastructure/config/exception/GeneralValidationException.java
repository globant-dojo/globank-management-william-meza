package com.globant.courier.glober.infrastructure.config.exception;

import com.globant.courier.glober.infrastructure.rest.output.FormatMessage;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class GeneralValidationException extends RuntimeException {

    private final List<FormatMessage> messages;

    public GeneralValidationException(List<FormatMessage> messages) {
        this.messages = messages;
    }
}
