package github.com.julivanmeridius.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import github.com.julivanmeridius.client.avaliacoes.AvaliacaoModel;
import github.com.julivanmeridius.domain.ProdutoDomain;
import github.com.julivanmeridius.dto.ProdutoDTO;
import github.com.julivanmeridius.exception.RecursoNaoEncontradoException;
import github.com.julivanmeridius.model.ProdutoModel;

/**
 * Classe Mapper
 * @author Julivan Silva
 */
@Component
public class Mapper {
	
	Logger logger = LoggerFactory.getLogger(Mapper.class);
	
	public ProdutoDTO createProdutoDTOFromProdutoDomain(ProdutoDomain produto) {
		logger.info("### Executando Metodo:  createProdutoDTOFromProdutoDomain()");
		
		return new ProdutoDTO(
				produto.getId(),
				produto.getNome()
		);
	}
	
	public ProdutoDTO createProdutoDTOFromProdutoDomain(Optional<ProdutoDomain> optional) {
		logger.info("### Executando Metodo:  createProdutoDTOFromProdutoDomain()");
		
		ProdutoDomain domain = optional.orElseThrow(RecursoNaoEncontradoException::new);				
		ProdutoDTO dto = new ProdutoDTO();				
		dto.setId(domain.getId());
		dto.setNome(domain.getNome());
		
		return dto;
	}
	
	public ProdutoDTO createProdutoDTOFromDomainAndReviews(ProdutoDomain produto, List<AvaliacaoModel> avaliacoes) {
		logger.info("### Executando Metodo:  createProdutoDTOFromDomainAndReviews()");
		
		return new ProdutoDTO(
				produto.getId(),
				produto.getNome(),
				avaliacoes
		);
	}
	
	public List<ProdutoModel> createListProductsFromListDomain(List<ProdutoDomain> lsProdutosDomain){
		logger.info("### Executando Metodo:  createListProductsFromListDomain()");
		
		return lsProdutosDomain.stream()
								.map(this::converterProdutoParaModelo)
								.collect(Collectors.toList());
	}
	
	public ProdutoModel converterProdutoParaModelo(ProdutoDomain produto) {
		logger.info("### Executando Metodo:  converterProdutoParaModelo()"); //remover depois
		
		ProdutoModel pm  = new ProdutoModel();
		pm.setId(produto.getId());
		pm.setNome(produto.getNome());
		
		return pm;
	}
	
	public ProdutoModel createProdutoModelFromDomain(Optional<ProdutoDomain> optional) {
		logger.info("### Executando Metodo:  createProdutoDTOFromDomain()");
		
		ProdutoDomain domain = optional.orElseThrow(RecursoNaoEncontradoException::new);				
		ProdutoModel produtoModel = new ProdutoModel();				
		produtoModel.setId(domain.getId());
		produtoModel.setNome(domain.getNome());
		
		return produtoModel;
	}
	
	public ProdutoModel createProdutoModelFromDomainAndReviews(ProdutoDomain produto, List<AvaliacaoModel> avaliacoes) {
		logger.info("### Executando Metodo:  createProdutoModelFromDomainAndReviews()");
		
		return new ProdutoModel(
				produto.getId(),
				produto.getNome(),
				avaliacoes
		);
	}
}
