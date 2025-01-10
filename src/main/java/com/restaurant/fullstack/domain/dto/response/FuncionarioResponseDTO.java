package com.restaurant.fullstack.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class FuncionarioResponseDTO {

    private Long id;

    private String cpf;

    private String nome;

    private Integer idade;

    private String numeroDeTelefone;

    private String email;

    private BigDecimal salario;

    private LocalDateTime horaInicioExpediente;

    private LocalDateTime horaFimExpediente;

    private LocalDateTime dataInicioAdmissao;
}
