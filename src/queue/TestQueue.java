package queue;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

public class TestQueue {

	private Queue <Pessoa> q;

	@Test
	public void testSemPrioridade() {
		q = new LinkedList<Pessoa>();
		
		//add e offer têm o mesmo efeito		
		q.add(new Pessoa("Eduardo", 27));
		q.offer(new Pessoa("Joao", 20));
		q.offer(new Pessoa("Maria", 100));
		q.offer(new Pessoa("Ana", 50));
		
		assertEquals(q.size(),4);
		
		Pessoa p1 = q.peek();
		assertEquals("Eduardo",p1.getNome());
		assertEquals(q.size(),4);
		
		p1 = q.poll();
		assertEquals("Eduardo",p1.getNome());
		assertEquals(q.size(),3);
		
		p1 = q.poll();
		assertEquals("Joao",p1.getNome());
		assertEquals(q.size(),2);
		
	}
	
	@Test
	public void testComPrioridade() {
		q = new PriorityQueue<Pessoa>();
		
		q.add(new Pessoa("Eduardo", 27));
		q.offer(new Pessoa("Joao", 20));
		q.offer(new Pessoa("Maria", 100));
		q.offer(new Pessoa("Ana", 50));
		
		assertEquals(q.size(),4);
		
		Pessoa p1 = q.peek();
		assertEquals("Maria",p1.getNome());
		assertEquals(q.size(),4);
		
		p1 = q.poll();
		assertEquals("Maria",p1.getNome());
		assertEquals(q.size(),3);
		
		p1 = q.poll();
		assertEquals("Ana",p1.getNome());
		assertEquals(q.size(),2);
		
	}

}
