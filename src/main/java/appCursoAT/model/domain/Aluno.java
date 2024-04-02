package appCursoAT.model.domain;

import appCursoAT.model.interfaces.IPessoa;

public class Aluno implements IPessoa {
	private Integer matricula;
	private String nome;
	private String endereco;
	private String Telefone;

	@Override
	public Integer getMatricula() {
		return this.matricula;
	}

	@Override
	public void setMatricula(Integer pMatricula) {
		this.matricula = pMatricula;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public void setNome(String pNome) {
		this.nome = pNome;
	}

	@Override
	public String getEndereco() {
		return this.endereco;
	}

	@Override
	public void setEndereco(String pEndereco) {
		this.endereco = pEndereco;
	}

	@Override
	public String getTelefone() {
		return this.Telefone;
	}

	@Override
	public void setTelefone(String pTelefone) {
		this.Telefone = pTelefone;

	}

}
