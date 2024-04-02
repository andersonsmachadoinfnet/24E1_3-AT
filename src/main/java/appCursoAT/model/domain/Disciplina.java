package appCursoAT.model.domain;

import appCursoAT.model.auxiliar.Constantes;

public class Disciplina {
	private    int codigo;
	private String disciplina;
	
	@Override
	public String toString() {
		return new StringBuilder().append(codigo).append(Constantes.SEPARADOR)
				                  .append(disciplina)
		                          .toString();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}
