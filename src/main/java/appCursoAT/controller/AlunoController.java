package appCursoAT.controller;

import com.google.gson.Gson;

import appCursoAT.model.domain.Aluno;
import appCursoAT.model.service.AlunoService;
import spark.Route;
import spark.Spark;

public class AlunoController {
	public AlunoService srv;
	
	
	public AlunoController () {
		srv = new AlunoService();
	}
	
	public void registrarRotas() {
		Spark.get("/aluno/lista", this.lista);
		Spark.post("/aluno/incluir", this.incluir);
		Spark.delete("/aluno/:id/deletar", this.excluir);
		Spark.get("/aluno/:id", this.obter);
	}
	
	public Route lista = (req, res) -> {
		Gson gson = new Gson();
		return gson.toJson(srv.lista());
	};
	
	public Route incluir = (req, res) -> {
		Aluno p = new Gson().fromJson(req.body(), Aluno.class);
		srv.incluir(p);
		return "Aluno ["+p.toString()+"] adicionado.";
	};
	
	public Route excluir = (req, res) -> {
		Integer pId = Integer.valueOf(req.params("id"));
		srv.exclur(pId);		
		return "Aluno ["+pId+"] removido.";
	};
	
	public Route obter = (req, res) -> {
		Integer pId = Integer.valueOf(req.params("id"));
		Gson gson = new Gson();
		return gson.toJson(srv.obter(pId));
	};

}
