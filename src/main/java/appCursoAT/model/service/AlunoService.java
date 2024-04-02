package appCursoAT.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import appCursoAT.model.domain.Aluno;
import appCursoAT.model.interfaces.IServicoDe;

public class AlunoService  implements IServicoDe<Aluno>{
    private static Map<Integer, Aluno> alunos = new HashMap<Integer, Aluno>();

	@Override
	public void incluir(Aluno pValor) {
		pValor.setMatricula(alunos.size()+1);
		alunos.put(pValor.getMatricula(), pValor);
	}

	@Override
	public void exclur(Integer pId) {
		alunos.remove(pId);
	}

	@Override
	public Aluno obter(Integer pId) {
		return alunos.get(pId);
	}

	@Override
	public Collection<Aluno> lista() {
		return alunos.values();
	}
	
	

}
