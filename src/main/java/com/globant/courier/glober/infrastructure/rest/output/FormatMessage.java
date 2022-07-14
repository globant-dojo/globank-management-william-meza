package com.globant.courier.glober.infrastructure.rest.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FormatMessage {
    String code;
    String detail;
}
