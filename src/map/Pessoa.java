package map;

public class Pessoa {
	
	private int idade, cpf;
	private String nome;
	
	public Pessoa(int idade, int cpf, String nome) {
		super();
		this.idade = idade;
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	

}
