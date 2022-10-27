package github.com.julivanmeridius.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.com.julivanmeridius.mapper.Mapper;
import github.com.julivanmeridius.model.ProdutoModel;
import github.com.julivanmeridius.repository.ProdutoRepository;
import github.com.julivanmeridius.service.ProdutoService;

/**
 * Service Layer
 * @author Julivan Silva
 */
@Service
public class ProdutoServiceImpl implements ProdutoService {

	Logger logger = LoggerFactory.getLogger(ProdutoServiceImpl.class);
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public List<ProdutoModel> buscarTodosProdutos() {
		logger.info("### Executando Metodo:  buscarTodosProdutos()");
		return mapper.createListProductsFromListDomain(repository.findAll());
	}

	@Override
	public ProdutoModel findProductById(Long idProduto) {
		logger.info("### Executando Metodo: findProductById() - idProduto: {}", idProduto);
		return mapper.createProdutoModelFromDomain(repository.findById(idProduto));
	}

	@Override
	public ProdutoModel findProductByName(String nomeProduto) {
		logger.info("### Executando Metodo: findProductByName() - nomeProduto: {}", nomeProduto);
				
		return null;
	}
}
