package github.com.julivanmeridius.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.com.julivanmeridius.client.avaliacoes.AvaliacaoClient;
import github.com.julivanmeridius.client.avaliacoes.AvaliacaoModel;
import github.com.julivanmeridius.model.ProdutoModel;
import github.com.julivanmeridius.service.ProdutoService;

/**
 * Produto Controller 
 * 
 * @author Julivan Silva
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service; 
	
	@Autowired
	private AvaliacaoClient avaliacoes;

	@GetMapping("/all")
	public List<ProdutoModel> buscarTodos() {
		return service.buscarTodosProdutos();
	}

	@GetMapping("/{produtoId}")
	public ProdutoModel buscarPorId(@PathVariable Long produtoId) {
		return service.findProductById(produtoId);
	}
		
	@GetMapping("/reviews/{produtoId}")
	public List<AvaliacaoModel> buscarAvaliacaoDoProduto(Long productId) {
		return avaliacoes.buscarTodosPorProduto(productId);
	}
}
