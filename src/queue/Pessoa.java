package queue;


public class Pessoa implements Comparable<Pessoa>{

	private String nome;
	private int idade;
	private TipoConta tipo;
	
	enum TipoConta{
	       NORMAL, PRIVILEGIADO;
	  }
	
	public Pessoa(String nome, int idade){
		this.nome = nome;
		this.idade = idade;
		this.tipo = TipoConta.NORMAL;
	}
	
	public Pessoa(String nome, int idade, TipoConta tipo){
		this.nome = nome;
		this.idade = idade;
		this.tipo = tipo;
	}
	
	public int compareTo(Pessoa p1) {
		if(idade < p1.getIdade())
			return 1;
		else if(getIdade() > p1.getIdade())
			return -1;
		else
			return 0;
	}
		
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	@Override
	public String toString() {
		return "Nome: "+nome+"; Idade: "+idade+"; Tipo: "+tipo;
	}
	
	public TipoConta getTipo() {
		return tipo;
	}

}
