package set;

public class Correspondencia implements Comparable<Correspondencia>{

	private String conteudo;
	private int aptoDestinatario;
	
	public Correspondencia(String conteudo, int aptoDestinatario) {
		this.conteudo = conteudo;
		this.aptoDestinatario = aptoDestinatario;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else if(obj instanceof Correspondencia){
			Correspondencia c = (Correspondencia) obj;
			if(this.conteudo.equals(c.getConteudo()))
				return true;
			else return false;
		}
		else return false;
	}
	
	@Override
	public int hashCode() {
		return this.aptoDestinatario + conteudo.hashCode();
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public int getAptoDestinatario() {
		return aptoDestinatario;
	}
	
	@Override
	public String toString() {
		return "apto: "+aptoDestinatario+"\nconteudo: "+conteudo;
	}

	public int compareTo(Correspondencia c) {
		if(aptoDestinatario < c.getAptoDestinatario())
			return -1;
		else if(aptoDestinatario > c.getAptoDestinatario())
			return 1;
		else{	//when equal
			return conteudo.compareTo(c.getConteudo());
		}
	}
	
	public static void main(String[] args) {
		Correspondencia c1 = new Correspondencia("Veja Abril", 101);
		Correspondencia c2 = new Correspondencia("Istoe Abril", 101);
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}
	
}
