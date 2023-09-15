package com.operadora.saude.service;

import com.operadora.saude.dto.AlterarConsultaDTO;
import com.operadora.saude.dto.ConsultaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ConsultaService {
    ResponseEntity<ConsultaDTO> cadastrarConsulta(ConsultaDTO consulta);

    ResponseEntity<List<ConsultaDTO>> obterTudo();

    ResponseEntity<ConsultaDTO> obter(Long id);

    ResponseEntity<ConsultaDTO> alterar(Long id, AlterarConsultaDTO alterarConsulta);

    ResponseEntity<ConsultaDTO> deletar(Long id);
}
