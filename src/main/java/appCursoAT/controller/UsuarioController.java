package appCursoAT.controller;

import appCursoAT.model.domain.Usuario;
import spark.Request;
import spark.Response;
import spark.Route;

public class UsuarioController implements Route {

	@Override
	public Object handle(Request request, Response response) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder html = new StringBuilder();
		html.append(new Usuario());
		return html.toString();
	}

}
