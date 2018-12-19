package com.henriquephil.menk.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString
public class Recebimento {
    @NonNull
    private LocalDateTime data;
    @NonNull
    private BigDecimal valor = BigDecimal.ZERO;
}
