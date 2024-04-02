package appCursoAT.model.domain;

public class Usuario {
	private    int id;
	private String nome;
	
	public Usuario() {
		this.setId(-1);
		this.setNome("Usu�rio an�nimo");
	}
	
	public Usuario(String pNome) {
		super();
		this.setNome(pNome);
	}
	
	@Override
	public String toString() {
		return "Usu�rio: "+this.nome;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
