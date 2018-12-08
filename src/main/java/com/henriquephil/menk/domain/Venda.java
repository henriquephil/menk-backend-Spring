package com.henriquephil.menk.domain;

import com.henriquephil.menk.domain.enums.VendaStatus;
import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document
public class Venda implements ContaReceberOrigem {
    private String id;
    @NonNull
    private VendaStatus status = VendaStatus.PENDENTE;
    @DBRef
    @NonNull
    private Entidade cliente;
    @NonNull
    private LocalDateTime dataHoraCriacao = LocalDateTime.now();
    private LocalDateTime dataHoraEmissao;
    private String observacao;
    @NonNull
    private List<VendaItem> itens = new ArrayList<>();
    @DBRef
    private CondicaoPagamento condicaoPagamento;
    @DBRef(lazy = true)
    private List<ContaReceber> contasReceber = new ArrayList<>();

    public BigDecimal getTotalBruto() {
        return itens.stream()
                .map(VendaItem::getTotalBruto)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal getTotalLiquido() {
        return itens.stream()
                .map(VendaItem::getTotalLiquido)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public void finalizar() {
        Assert.isTrue(status == VendaStatus.PENDENTE, "Operação não permitida");
        Assert.notNull(condicaoPagamento, "Condição de pagamento não definida");
        status = VendaStatus.FINALIZADA;
        dataHoraEmissao = LocalDateTime.now();
    }

    public void estornar() {
        Assert.isTrue(status == VendaStatus.FINALIZADA, "Operação não permitida");
        status = VendaStatus.PENDENTE;
        dataHoraEmissao = null;
    }
}
