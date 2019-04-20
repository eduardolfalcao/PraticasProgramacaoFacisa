package queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import queue.Pessoa.TipoConta;

public class Agencia {
	
	/**
	 * Usada para alternar entre as 3 filas
	 */
	private Queue<Queue<Pessoa>> filaDeFilas;
	
	private Queue<Pessoa> filaDePrioridadePorIdade;
	private Queue<Pessoa> filaDePrivilegiado;
	private Queue<Pessoa> filaNormal;
	
	public Agencia(){
		
		//pode ser instanciado das duas seguintes formas
		this.filaDePrioridadePorIdade = new PriorityQueue<Pessoa>();
		//this.filaDePrioridadePorIdade = new PriorityQueue<Pessoa>(new IdadeComparator());
		
		//preciso obrigatoriamente passar o comparator de conta, senão
		//comparará por idade (comparable de Pessoa)
		this.filaDePrivilegiado = new PriorityQueue<Pessoa>(new TipoContaComparator());
		
		//não precisa de comparador, pois é uma fila convencional
		this.filaNormal = new LinkedList<Pessoa>();
		
		//instanciando fila de filas
		this.filaDeFilas = new LinkedList<Queue<Pessoa>>();
		this.filaDeFilas.offer(filaDePrioridadePorIdade);
		this.filaDeFilas.offer(filaDePrivilegiado);
		this.filaDeFilas.offer(filaNormal);
	}
		
	public void addPessoa(Pessoa p){
		if(p.getIdade()>=60)
			filaDePrioridadePorIdade.add(p);
		else if(p.getTipo() == TipoConta.PRIVILEGIADO)
			filaDePrivilegiado.add(p);
		else
			filaNormal.add(p);
	}
	
	public Pessoa proximo(){
		/**
		 * Avoid infinity loop
		 */
		boolean isEmpty = true;
		for(Queue<Pessoa> q : filaDeFilas)
			if(!q.isEmpty())
				isEmpty = false;
		
		if(!isEmpty){
			Queue<Pessoa> filaAtual = filaDeFilas.poll();
			Pessoa p = filaAtual.poll();
			
			if(p==null){
				filaDeFilas.offer(filaAtual);
				p = proximo();
			} else{
				filaDeFilas.offer(filaAtual);
			}		
			
			return p;
		} else{
			return null;
		} 
	}
	
	public static void main(String[] args) {
		Agencia a = new Agencia();
		
		a.addPessoa(new Pessoa("Eduardo", 29, TipoConta.NORMAL));
		a.addPessoa(new Pessoa("Joao", 30, TipoConta.NORMAL));
		a.addPessoa(new Pessoa("Joana", 33, TipoConta.PRIVILEGIADO));
		a.addPessoa(new Pessoa("Idoso1", 60, TipoConta.NORMAL));
		a.addPessoa(new Pessoa("Idoso2", 60, TipoConta.PRIVILEGIADO));
		
		System.out.println(a.proximo());//idoso1
		System.out.println(a.proximo());//joana
		System.out.println(a.proximo());//eduardo
		System.out.println(a.proximo());//idoso2
		System.out.println(a.proximo());//joao
		System.out.println(a.proximo());//null
		
		a.addPessoa(new Pessoa("Eduardo", 29, TipoConta.NORMAL));
		a.addPessoa(new Pessoa("Joao", 30, TipoConta.NORMAL));
		a.addPessoa(new Pessoa("Joana", 33, TipoConta.PRIVILEGIADO));
		a.addPessoa(new Pessoa("Idoso1", 60, TipoConta.NORMAL));
		a.addPessoa(new Pessoa("Idoso2", 60, TipoConta.PRIVILEGIADO));
		
		System.out.println(a.proximo());//idoso1
		System.out.println(a.proximo());//joana
		System.out.println(a.proximo());//eduardo
		System.out.println(a.proximo());//idoso2
		System.out.println(a.proximo());//joao
		System.out.println(a.proximo());//null
	}

}
