package map;

public class Cadastro {

	private int codigo;
	
	public Cadastro(int codigo) {
		this.codigo = codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else if(obj instanceof Cadastro){
			Cadastro c = (Cadastro) obj;
			if(c.getCodigo() == codigo)
				return true;
			else return false;
		}
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		return this.codigo;
	}
	
}
