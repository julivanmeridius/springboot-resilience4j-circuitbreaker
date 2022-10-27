package github.com.julivanmeridius.repository;

import java.util.List;
import java.util.Optional;

import github.com.julivanmeridius.domain.Avaliacao;

/**
 * Repository
 * 
 * @author Julivan Silva
 */
public interface AvaliacaoRepository {

	void save(Avaliacao avaliacao);

	Optional<Avaliacao> getOne(Long id);

	List<Avaliacao> getAll();

}
