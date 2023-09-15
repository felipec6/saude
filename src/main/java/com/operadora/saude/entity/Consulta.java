package com.operadora.saude.entity;

import com.operadora.saude.utils.EspecialidadeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consul_id")
    private Long id;
    @Column(name = "consul_beneficiario")
    private String beneficiario;
    @Column(name = "consul_especialidade")
    private String especialidade;
    @Column(name = "consul_datahora")
    private LocalDateTime datahora;

}
