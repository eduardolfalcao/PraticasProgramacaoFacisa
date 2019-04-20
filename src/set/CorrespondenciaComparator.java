package set;

import java.util.Comparator;

public class CorrespondenciaComparator implements Comparator<Correspondencia>{

	public int compare(Correspondencia c1, Correspondencia c2) {
		if(c1.getAptoDestinatario() < c2.getAptoDestinatario())
			return -1;
		else if(c1.getAptoDestinatario() > c2.getAptoDestinatario())
			return 1;
		else{	//when equal
			return c1.getConteudo().compareTo(c2.getConteudo());
		}
	}

}
