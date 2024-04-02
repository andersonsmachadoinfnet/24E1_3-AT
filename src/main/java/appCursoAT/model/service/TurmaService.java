package appCursoAT.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import appCursoAT.model.domain.Turma;
import appCursoAT.model.interfaces.IServicoDe;

public class TurmaService implements IServicoDe<Turma>  {
	private static Map<Integer, Turma> turmas = new HashMap<Integer, Turma>();

	@Override
	public void incluir(Turma pValor) {
		pValor.setCodigo(turmas.size()+1);
		turmas.put(pValor.getCodigo(), pValor);
	}

	@Override
	public void exclur(Integer pId) {
		turmas.remove(pId);
	}

	@Override
	public Turma obter(Integer pId) {
		return turmas.get(pId);
	}

	@Override
	public Collection<Turma> lista() {
		return turmas.values();
	}
	


}
