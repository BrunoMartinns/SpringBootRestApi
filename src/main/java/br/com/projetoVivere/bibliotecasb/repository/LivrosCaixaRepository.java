package br.com.projetoVivere.bibliotecasb.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.projetoVivere.bibliotecasb.models.Clientes;
import br.com.projetoVivere.bibliotecasb.models.LivrosCaixa;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosCaixaRepository extends JpaRepository<LivrosCaixa, Integer> {
    List <LivrosCaixa> findByClientes(Clientes clientes);
    
    List<LivrosCaixa> findByClientesIdAndDatalancamentoBetweenOrderByDatalancamentoAsc(int clienteId, Date inicio, Date fim);

    @Query(value = "SELECT * FROM livros_caixa WHERE clientes_id = :clienteId "
    		+ "AND data_lancamento BETWEEN STR_TO_DATE(:dataInicio, '%Y-%m-%d') AND STR_TO_DATE(:dataFim, '%Y-%m-%d')", nativeQuery = true)
    List<LivrosCaixa> buscarPorClienteEPeriodo(@Param("clienteId") int clienteId, @Param("dataInicio") Date dataInicio, @Param("dataFim") Date dataFim);
}
