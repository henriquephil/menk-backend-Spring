package com.henriquephil.menk.domain;

import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Recebimento {
    @NonNull
    private LocalDateTime data;
    @NonNull
    private BigDecimal valor = BigDecimal.ZERO;
}
