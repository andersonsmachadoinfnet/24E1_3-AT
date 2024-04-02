package appCursoAT.model.interfaces;

import java.util.Collection;

public interface IServicoDe<Tipo> {
	void incluir(Tipo pValor);
	void exclur(Integer pId);
	Tipo obter(Integer pId);
	Collection<Tipo> lista();
}
