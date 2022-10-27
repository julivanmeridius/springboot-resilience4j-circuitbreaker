package github.com.julivanmeridius.client.avaliacoes;

import java.util.List;

public interface AvaliacaoClient {

	List<AvaliacaoModel> buscarTodosPorProduto(Long productId);
	
}
