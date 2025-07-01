package br.com.projetoVivere.bibliotecasb.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoVivere.bibliotecasb.dto.LivrosCaixaDTO;
import br.com.projetoVivere.bibliotecasb.dto.RelatorioContabilDTO;
import br.com.projetoVivere.bibliotecasb.exception.ResourceNotFoundException;
import br.com.projetoVivere.bibliotecasb.models.Clientes;
import br.com.projetoVivere.bibliotecasb.models.LivrosCaixa;
import br.com.projetoVivere.bibliotecasb.repository.ClientesRepository;
import br.com.projetoVivere.bibliotecasb.repository.LivrosCaixaRepository;

@Service
public class RelatorioContabilService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private LivrosCaixaRepository livrosCaixaRepository;

    public RelatorioContabilDTO gerar(int clienteId, Date dataInicio, Date dataFim) {
        Clientes cliente = clientesRepository.findById(clienteId).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com ID: " + clienteId));

        dataFim = ajusteDateFim(dataFim);
        
        List<LivrosCaixa> lancamentos = livrosCaixaRepository
            .buscarPorClienteEPeriodo(clienteId, dataInicio, dataFim);

        float saldo = 0f;
        List<LivrosCaixaDTO> listaDto = new ArrayList<>();

        for (LivrosCaixa livro : lancamentos) {
            LivrosCaixaDTO dto = new LivrosCaixaDTO();
            dto.setDatalancamento(livro.getDatalancamento());
            dto.setDescricao(livro.getDescricao());
            dto.setTipo(livro.getTipo());
            dto.setValor(livro.getValor());

            if ("C".equalsIgnoreCase(livro.getTipo())) {
                saldo += livro.getValor();
            } else if ("D".equalsIgnoreCase(livro.getTipo())) {
                saldo -= livro.getValor();
            }

            dto.setSaldo(saldo);
            listaDto.add(dto);
        }

        RelatorioContabilDTO relatorio = new RelatorioContabilDTO();
        relatorio.setId(cliente.getId());
        relatorio.setNome(cliente.getNome());
        relatorio.setCpfCnpj(cliente.getCpfCnpj());
        relatorio.setTelefone(cliente.getTelefone());
        relatorio.setContabil(listaDto);

        return relatorio;
    }

	private Date ajusteDateFim(Date dataFim) {

		Calendar c = Calendar.getInstance();
		c.setTime(dataFim);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		dataFim = c.getTime();
		
		return dataFim;
	}
}

