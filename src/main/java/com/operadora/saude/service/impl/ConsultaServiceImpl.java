package com.operadora.saude.service.impl;

import com.operadora.saude.dto.AlterarConsultaDTO;
import com.operadora.saude.dto.ConsultaDTO;
import com.operadora.saude.entity.Consulta;
import com.operadora.saude.repository.ConsultaRepository;
import com.operadora.saude.service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaServiceImpl(
            ConsultaRepository consultaRepository
    ) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public ResponseEntity<ConsultaDTO> cadastrarConsulta(ConsultaDTO consulta) {
        consultaRepository.save(
                Consulta.builder()
                        .beneficiario(consulta.getBeneficiario())
                        .especialidade(consulta.getEspecialidade())
                        .datahora(consulta.getDatahora())
                        .build()
        );
        return ResponseEntity.ok(consulta);
    }

    @Override
    public ResponseEntity<List<ConsultaDTO>> obterTudo() {
        List<ConsultaDTO> consultaDTO = new ArrayList<>();
        var consultaList = consultaRepository.findAll();
        for (Consulta consulta : consultaList) {
            consultaDTO.add(consultaToDTO(consulta));
        }
        return ResponseEntity.ok(consultaDTO);
    }

    @Override
    public ResponseEntity<ConsultaDTO> obter(Long id) {
        var consultaOptional = encontrarConsultaPorId(id);
        if (consultaOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var consulta = consultaOptional.get();
        return ResponseEntity.ok(consultaToDTO(consulta));
    }

    @Override
    public ResponseEntity<ConsultaDTO> alterar(Long id, AlterarConsultaDTO alterarConsulta) {
        var consultaOptional = encontrarConsultaPorId(id);
        if (consultaOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var consulta = consultaOptional.get();
        if (alterarConsulta.getEspecialidade() != null) {
            consulta.setEspecialidade(alterarConsulta.getEspecialidade());
        }
        if (alterarConsulta.getDatahora() != null) {
            consulta.setDatahora(alterarConsulta.getDatahora());
        }
        consultaRepository.save(consulta);
        return ResponseEntity.ok(consultaToDTO(consulta));
    }

    @Override
    public ResponseEntity<ConsultaDTO> deletar(Long id) {
        var consultaOptional = encontrarConsultaPorId(id);
        if (consultaOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var consulta = consultaOptional.get();
        consultaRepository.delete(consulta);
        return ResponseEntity.ok(consultaToDTO(consulta));
    }

    private Optional<Consulta> encontrarConsultaPorId(Long id) {
        return consultaRepository.findById(id);
    }

    private ConsultaDTO consultaToDTO(Consulta consulta) {
        return (ConsultaDTO.builder()
                .beneficiario(consulta.getBeneficiario())
                .especialidade(consulta.getEspecialidade())
                .datahora(consulta.getDatahora())
                .build());
    }
}
