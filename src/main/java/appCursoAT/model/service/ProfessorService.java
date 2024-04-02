package appCursoAT.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import appCursoAT.model.domain.Professor;
import appCursoAT.model.interfaces.IServicoDe;

public class ProfessorService implements IServicoDe<Professor> {
	private static Map<Integer, Professor> professores = new HashMap<Integer, Professor>();

	@Override
	public void incluir(Professor pValor) {
		pValor.setMatricula(professores.size()+1);
		professores.put(pValor.getMatricula(), pValor);
	}

	@Override
	public void exclur(Integer pId) {
		professores.remove(pId);
	}

	@Override
	public Professor obter(Integer pId) {
		return professores.get(pId);
	}

	@Override
	public Collection<Professor> lista() {
		return professores.values();
	}
	
	
}
