package github.com.julivanmeridius.service;

import java.util.List;

import github.com.julivanmeridius.model.ProdutoModel;

public interface ProdutoService {
	
	List<ProdutoModel> buscarTodosProdutos();
	
	ProdutoModel findProductById(Long idProduto);
	
	ProdutoModel findProductByName(String nomeProduto);
	
}
