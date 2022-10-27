package github.com.julivanmeridius.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.com.julivanmeridius.domain.ProdutoDomain;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoDomain, Long> {

	Optional<ProdutoDomain> findById(Long idProduto);
	
	Optional<ProdutoDomain> findByNome(String nomeProduto);
	
}
