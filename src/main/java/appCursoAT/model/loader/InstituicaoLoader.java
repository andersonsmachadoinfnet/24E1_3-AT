package appCursoAT.model.loader;

import appCursoAT.model.auxiliar.Constantes;
import appCursoAT.model.domain.Instituicao;
import appCursoAT.model.domain.Professor;
import appCursoAT.model.interfaces.IArquivoTxt;
import appCursoAT.model.service.InstituicaoService;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;

public class InstituicaoLoader implements IArquivoTxt {
	private InstituicaoService service;
	
	@Override
	public void lerDoArq(String pNomeDoArq)  {
		try {
			FileReader file = new FileReader(pNomeDoArq);
			BufferedReader leitura = new BufferedReader(file);
			String   lLinha  = leitura.readLine();
			String[] lCampos = null;
			Instituicao lCurso = null;
			while (lLinha != null) {
				lCampos = lLinha.split(Constantes.SEPARADOR);
				if (Constantes.PREFIXO_CLASSE_CURSO.equals(lCampos[0])) {
					if (lCurso != null) {
						service.incluir(lCurso);	
					}
					lCurso = new Instituicao();
					lCurso.setLinha(lLinha);
				}
				else if (Constantes.PREFIXO_CLASSE_PROFESSOR.equals(lCampos[0])) {
					Professor lProf = new Professor();
					lProf.setLinha(lLinha);
					lCurso.getProfessores().add(lProf);
				}
				
				lLinha  = leitura.readLine();
			}
			if (lCurso != null) {
				service.incluir(lCurso);	
			}
			leitura.close();
			file.close();
			
		} catch (IOException e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
	}
}
