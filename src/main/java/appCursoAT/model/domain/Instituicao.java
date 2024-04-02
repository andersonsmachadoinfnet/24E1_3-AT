package appCursoAT.model.domain;

import java.util.ArrayList;
import java.util.List;

import appCursoAT.model.auxiliar.Constantes;
import appCursoAT.model.interfaces.IArquivoTxt_linha;
import appCursoAT.model.interfaces.ITemEndereco;
import appCursoAT.model.interfaces.ITemProfessores;

public class Instituicao implements ITemProfessores, ITemEndereco, IArquivoTxt_linha {
	private         Integer id;
	private          String nome;
	private List<Professor> professores;
	private        Endereco endereco; 
	
	public Instituicao() {
		this.id          = Constantes.NAODEFINIDO;
		this.nome        = "";
		this.professores = new ArrayList<Professor>();
		this.endereco    = new Endereco();
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(id).append(Constantes.SEPARADOR)
				                  .append(nome)
		                          .toString();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String getPrefixo() {
		return Constantes.PREFIXO_CLASSE_CURSO;
	}

	@Override
	public boolean isPrefixo(String pPrefixo) {
		return getPrefixo().equals(pPrefixo);
	}

	@Override
	public void setLinha(String pLinha) {
		String[] lCampos = pLinha.split(Constantes.SEPARADOR);
		this.id   = Integer.parseInt(lCampos[1]);
		this.nome  = lCampos[2];
	}
	
}
