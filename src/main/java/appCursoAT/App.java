package appCursoAT;

import appCursoAT.controller.AlunoController;
import appCursoAT.controller.ProfessorController;
import appCursoAT.controller.TurmaController;
import appCursoAT.controller.UsuarioController;
import spark.Spark;

public class App {
	
	public static void main(String[] args) {
		AlunoController lAl = new AlunoController();
		ProfessorController lPc = new ProfessorController();
		TurmaController lT = new TurmaController(lAl.srv, lPc.srv);
		
		Spark.port(8080);
		lAl.registrarRotas();
		lPc.registrarRotas();
		lT.registrarRotas();
		
		
		Spark.get("/", (req, resp)->{return App.class.getResourceAsStream("/index.html");});
		Spark.get("/usuario", new UsuarioController());
		System.out.println("Aplicativo em execução, abra o browser na porta 8080.");
	}

}
