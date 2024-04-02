package appCursoAT.controller;

import com.google.gson.Gson;

import appCursoAT.model.domain.Professor;
import appCursoAT.model.service.ProfessorService;
import spark.Route;
import spark.Spark;

public class ProfessorController {
	public ProfessorService srv;
	
	public ProfessorController () {
		srv = new ProfessorService();
	}
	
	public void registrarRotas() {
		Spark.get("/professor/lista", this.lista);
		Spark.post("/professor/incluir", this.incluir);
		Spark.delete("/professor/:id/deletar", this.excluir);
		Spark.get("/professor/:id", this.obter);
	}
	
	public Route lista = (req, res) -> {
		Gson gson = new Gson();
		return gson.toJson(srv.lista());
	};
	
	public Route incluir = (req, res) -> {
		Professor p = new Gson().fromJson(req.body(), Professor.class);
		srv.incluir(p);
		return "Professor ["+p.toString()+"] adicionado.";
	};
	
	public Route excluir = (req, res) -> {
		Integer pId = Integer.valueOf(req.params("id"));
		srv.exclur(pId);		
		return "Professor ["+pId+"] removido.";
	};
	
	public Route obter = (req, res) -> {
		Integer pId = Integer.valueOf(req.params("id"));
		Gson gson = new Gson();
		return gson.toJson(srv.obter(pId));
	};

}
