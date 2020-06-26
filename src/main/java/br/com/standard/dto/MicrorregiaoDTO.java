package br.com.standard.dto;

public class MicrorregiaoDTO {

	private Long id;
	private String nome;
	private MesorregiaoDTO mesorregiao;

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

	public MesorregiaoDTO getMesorregiao() {
		return mesorregiao;
	}

	public void setMesorregiao(MesorregiaoDTO mesorregiao) {
		this.mesorregiao = mesorregiao;
	}

}
