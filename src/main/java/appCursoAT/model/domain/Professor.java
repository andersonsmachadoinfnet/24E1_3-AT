package appCursoAT.model.domain;

import appCursoAT.model.auxiliar.Constantes;
import appCursoAT.model.interfaces.IArquivoTxt_linha;
import appCursoAT.model.interfaces.IPessoa;

public class Professor implements IPessoa, IArquivoTxt_linha {
	private Integer matricula;
	private String nome;
	private String endereco;
	private String telefone;

	@Override
	public String toString() {
		return new StringBuilder().append(matricula).append(Constantes.SEPARADOR)
				                  .append(nome).append(Constantes.SEPARADOR)
				                  .append(endereco).append(Constantes.SEPARADOR)
				                  .append(telefone)
		                          .toString();
	}
	
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
		return this.telefone;
	}

	@Override
	public void setTelefone(String pTelefone) {
		this.telefone = pTelefone;

	}
	
	@Override
	public String getPrefixo() {
		return Constantes.PREFIXO_CLASSE_PROFESSOR;
	}

	@Override
	public boolean isPrefixo(String pPrefixo) {
		return getPrefixo().equals(pPrefixo);
	}
	
	@Override
	public void setLinha(String pLinha) {
		String[] lCampos = pLinha.split(Constantes.SEPARADOR);
		this.matricula= Integer.parseInt(lCampos[1]);
		this.nome     = lCampos[2];
		this.telefone = lCampos[3];
		//this.endereco = lCampos[3];
		
	}

}
