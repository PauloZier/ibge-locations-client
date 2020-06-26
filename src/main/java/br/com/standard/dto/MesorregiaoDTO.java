package br.com.standard.dto;

public class MesorregiaoDTO {

	private Long id;
	private String nome;
	private UfDTO UF;

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

	public UfDTO getUf() {
		return UF;
	}

	public void setUf(UfDTO uf) {
		UF = uf;
	}
}
