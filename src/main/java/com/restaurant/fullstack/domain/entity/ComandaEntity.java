package com.restaurant.fullstack.domain.entity;

import com.restaurant.fullstack.domain.enums.FormaDePagamentoENUM;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_comanda")
public class ComandaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Integer codigoDaComanda;

    private LocalDateTime horaInicioAtendimento;

    private LocalDateTime horaFimAtendimento;

    private BigDecimal precoTotal;

    private FormaDePagamentoENUM formaDePagamentoEnum;

    @OneToOne(mappedBy = "comanda")
    private MesaEntity mesa;
}
