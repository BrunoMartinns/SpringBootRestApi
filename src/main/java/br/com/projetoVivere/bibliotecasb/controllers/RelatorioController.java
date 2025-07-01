package br.com.projetoVivere.bibliotecasb.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoVivere.bibliotecasb.dto.RelatorioContabilDTO;
import br.com.projetoVivere.bibliotecasb.service.RelatorioContabilService;

@RestController
@RequestMapping("/api/relatorio")
public class RelatorioController {

    @Autowired
    private RelatorioContabilService service;

    @GetMapping("/contabil")
    public ResponseEntity<RelatorioContabilDTO> gerarRelatorioContabil(
        @RequestParam int clienteId,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicio,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFim) {
        
        RelatorioContabilDTO dto = service.gerar(clienteId, dataInicio, dataFim);
        return ResponseEntity.ok(dto);
    }
}

