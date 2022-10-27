package github.com.julivanmeridius.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import github.com.julivanmeridius.client.avaliacoes.AvaliacaoModel;
import github.com.julivanmeridius.domain.ProdutoDomain;
import github.com.julivanmeridius.model.ProdutoModel;

/**
 * DTO  
 * @author Julivan Silva
 */
public class ProdutoDTO {

	public Long id;
	public String nome;
		
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public List<AvaliacaoModel> avaliacoes;

	public ProdutoDTO() {

	}

	public ProdutoDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public ProdutoDTO(Long id, String nome, List<AvaliacaoModel> avaliacoes) {
		this.id = id;
		this.nome = nome;
		this.avaliacoes = avaliacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<AvaliacaoModel> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoModel> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public static ProdutoModel of(ProdutoDomain produto) {
		return new ProdutoModel(
				produto.getId(),
				produto.getNome()
		);
	}
	
	public static ProdutoModel of(ProdutoDomain produto, List<AvaliacaoModel> avaliacoes) {
		return new ProdutoModel(
				produto.getId(),
				produto.getNome(),
				avaliacoes
		);
	}
}
