package appCursoAT.controller;

import com.google.gson.Gson;

import appCursoAT.model.domain.Aluno;
import appCursoAT.model.domain.Professor;
import appCursoAT.model.domain.Turma;
import appCursoAT.model.service.AlunoService;
import appCursoAT.model.service.ProfessorService;
import appCursoAT.model.service.TurmaService;
import spark.Route;
import spark.Spark;

public class TurmaController {
    private TurmaService srv;
    private AlunoService alunoSrv;
	private ProfessorService professorSrv;
	
	public TurmaController (AlunoService pAlunoSrv, ProfessorService pProfessorSrv) {
		srv = new TurmaService();
		alunoSrv = pAlunoSrv;
		professorSrv = pProfessorSrv;
	}
	
	public void registrarRotas() {
		Spark.get("/turma/lista", this.lista);
		Spark.post("/turma/incluir", this.incluir);
		Spark.post("/turma/:id/aluno/:alunoid", this.incluirAluno);
		Spark.delete("/turma/:id", this.excluir);
		Spark.delete("/turma/:id/aluno/:alunoid", this.excluirAluno);
		Spark.post("/turma/:id/professor/:professorid", this.incluirProfessor);
		Spark.delete("/turma/:id/professor", this.excluirProfessor);
		Spark.get("/turma/:id", this.obter);
	}
	
	public Route lista = (req, res) -> {
		Gson gson = new Gson();
		return gson.toJson(srv.lista());
	};
	
	public Route incluir = (req, res) -> {
		Turma p = new Gson().fromJson(req.body(), Turma.class);
		srv.incluir(p);
		return "Turma ["+p.toString()+"] adicionada.";
	};
	
	public Route incluirAluno = (req, res) -> {
		Integer pId = Integer.valueOf(req.params("id"));
		Integer pAlunoId = Integer.valueOf(req.params("alunoid"));
		Aluno   lAluno = alunoSrv.obter(pAlunoId);
		srv.obter(pId).addAluno(lAluno);
		return "Aluno ["+lAluno.toString()+"] adicionado na turma.";
	};
	
	public Route incluirProfessor = (req, res) -> {
		Integer pId = Integer.valueOf(req.params("id"));
		Integer pAlunoId = Integer.valueOf(req.params("professorid"));
		Professor p = professorSrv.obter(pAlunoId);
		srv.obter(pId).setProfessor(p);
		return "Professor ["+p.toString()+"] adicionado na turma.";
	};
	
	public Route excluir = (req, res) -> {
		Integer pId = Integer.valueOf(req.params("id"));
		srv.exclur(pId);		
		return "Aluno ["+pId+"] removido.";
	};
	
	public Route excluirAluno = (req, res) -> {
		Integer pId = Integer.valueOf(req.params("id"));
		int pAlunoId = Integer.valueOf(req.params("alunoid"));
		srv.obter(pId).getAlunos().remove(pAlunoId);		
		return "Aluno ["+pAlunoId+"] removido da turma.";
	};
	
	public Route excluirProfessor = (req, res) -> {
		Integer pId = Integer.valueOf(req.params("id"));
		srv.obter(pId).setProfessor(null);		
		return "Professor removido.";
	};
	
	
	public Route obter = (req, res) -> {
		Integer pId = Integer.valueOf(req.params("id"));
		Gson gson = new Gson();
		return gson.toJson(srv.obter(pId));
	};
}
