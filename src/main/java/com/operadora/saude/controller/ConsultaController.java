package com.operadora.saude.controller;

import com.operadora.saude.dto.AlterarConsultaDTO;
import com.operadora.saude.dto.ConsultaDTO;
import com.operadora.saude.service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(
            ConsultaService consultaService
    ) {
        this.consultaService = consultaService;
    }


    @PostMapping("/cadastrar")
    public ResponseEntity<ConsultaDTO> cadastrarConsulta(@RequestBody ConsultaDTO consulta) {
        return consultaService.cadastrarConsulta(consulta);
    }

    @GetMapping("/obterTudo")
    public ResponseEntity<List<ConsultaDTO>> obterTudo() {
        return consultaService.obterTudo();
    }

    @GetMapping("/{id}/obter")
    public ResponseEntity<ConsultaDTO> obter(@PathVariable Long id) {
        return consultaService.obter(id);
    }

    @PutMapping("/{id}/alterar")
    public ResponseEntity<ConsultaDTO> alterar(@PathVariable Long id, @RequestBody AlterarConsultaDTO alterarConsulta) {
        return consultaService.alterar(id, alterarConsulta);
    }

    @DeleteMapping("/{id}/deletar")
    public ResponseEntity<ConsultaDTO> deletar(@PathVariable Long id) {
        return consultaService.deletar(id);
    }

}
