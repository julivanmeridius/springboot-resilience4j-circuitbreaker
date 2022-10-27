package github.com.julivanmeridius.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import github.com.julivanmeridius.dto.AvaliacaoDTO;
import github.com.julivanmeridius.repository.AvaliacaoRepository;

/**
 * Resource Layer.
 *  
 * @author Julivan Silva 
 */
@RestController
@RequestMapping("/avaliacaos")
public class AvaliacaoResource {
	
	private final AvaliacaoRepository avaliacaos;

	public AvaliacaoResource(AvaliacaoRepository avaliacaos) {
		this.avaliacaos = avaliacaos;
	}
	
	@GetMapping
	public List<AvaliacaoDTO> buscarPorProduto(@RequestParam Long produtoId) {
		return avaliacaos.getAll()
				.stream()
				.filter(avaliacao -> avaliacao.getProdutoId().equals(produtoId))
				.map(AvaliacaoDTO::of)
				.collect(Collectors.toList());
	}
}
