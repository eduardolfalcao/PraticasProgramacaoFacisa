package queue;

import java.util.Comparator;

import queue.Pessoa.TipoConta;

public class TipoContaComparator implements Comparator<Pessoa>{

	public int compare(Pessoa p1, Pessoa p2) {
		if(p1.getTipo() == TipoConta.PRIVILEGIADO && p2.getTipo() == TipoConta.NORMAL)
			return 1;
		else if(p1.getTipo() == TipoConta.NORMAL && p2.getTipo() == TipoConta.PRIVILEGIADO)
			return -1;
		else
			return 0;
	}	
	
}
