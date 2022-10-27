package github.com.julivanmeridius.client.avaliacoes;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AvaliacaoModel {

	private Long id;
	private Integer nota;
	private String descricao;
	private String nomeAvaliador;
	
	public AvaliacaoModel() {
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
