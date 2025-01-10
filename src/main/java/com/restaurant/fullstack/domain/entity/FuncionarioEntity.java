package com.restaurant.fullstack.domain.entity;

import com.restaurant.fullstack.domain.enums.CargoENUM;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tb_funcionario")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    private String nome;

    private Integer idade;

    private String numeroDeTelefone;

    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private CargoENUM cargoEnum;

    private BigDecimal salario;

    private LocalDateTime horaInicioExpediente;

    private LocalDateTime horaFimExpediente;

    private LocalDateTime dataInicioAdmissao;

//    @ManyToMany
//    @JoinTable(name = "mesas_funcionarios",
//            joinColumns = @JoinColumn(name = "id_funcionario"),
//            inverseJoinColumns = @JoinColumn(name = "id_mesa"))
//    private List<MesaEntity> mesas;
}
