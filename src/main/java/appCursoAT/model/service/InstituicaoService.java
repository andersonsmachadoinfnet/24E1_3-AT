package appCursoAT.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import appCursoAT.model.domain.Instituicao;
import appCursoAT.model.interfaces.IServicoDe;

public class InstituicaoService implements IServicoDe<Instituicao> {
    private static Map<Integer, Instituicao> instituicao = new HashMap<Integer, Instituicao>();
	
    @Override
	public void incluir(Instituicao pValor) {
    	pValor.setId(instituicao.size()+1);
    	instituicao.put(pValor.getId(), pValor);
	}
    
    @Override
	public void exclur(Integer pId) {
    	instituicao.remove(pId);
	}

	@Override
	public Instituicao obter(Integer pId) {
		return instituicao.get(pId);
	}

	@Override
	public Collection<Instituicao> lista() {
		return instituicao.values();
	}
	
	/*
	 public void addProfessor(Integer pCursoId, Professor pProf) {
		Curso.get(pCursoId).getProfessores().add(pProf);
	}
	*/

}
