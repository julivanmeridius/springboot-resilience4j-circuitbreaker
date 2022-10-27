package github.com.julivanmeridius.client.avaliacoes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Client para operacoes de Avaliacao
 * @author Julivan Silva
 */
@Component
public class AvaliacaoClientImpl implements AvaliacaoClient {

	private final Logger logger = LoggerFactory.getLogger(AvaliacaoClientImpl.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final static String API_URL = UriComponentsBuilder //-- CRIAR PROPRIEDADE PARA API EXTERNA NO PROPERTIES
			.fromHttpUrl("http://localhost:8090/avaliacaos")
			.queryParam("produtoId", "{produtoId}")
			.encode()
			.toUriString();
	
	@Override
	public List<AvaliacaoModel> buscarTodosPorProduto(Long productId) {
		logger.info("### Executando Metodo: buscarTodosPorProduto() - productId: {}", productId);
		final List<AvaliacaoModel> avaliacoes = executarRequisicao(productId);
		return avaliacoes;				
	}

	private List<AvaliacaoModel> executarRequisicao(Long productId){
	
		final Map<String, Object> parametros = new HashMap<>();
		parametros.put("produtoId", productId);
		
		logger.info("Recuperando Avaliações para o Produto - ID:: ", productId);
		final AvaliacaoModel[] avaliacoes;
		
		try {
			avaliacoes = restTemplate.getForObject(API_URL, AvaliacaoModel[].class, parametros);
		} catch (Exception e) {
			logger.error("Erro durante processo de recuperacao de Avaliacoes....");
			throw e;
		}

		return Arrays.asList(avaliacoes);
	}
}
