package com.operadora.saude.dto;

import com.operadora.saude.utils.EspecialidadeEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AlterarConsultaDTO {
    private String especialidade;
    private LocalDateTime datahora;
}
