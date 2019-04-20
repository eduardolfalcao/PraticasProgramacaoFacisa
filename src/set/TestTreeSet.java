package set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class TestTreeSet {
	
	private Set<Correspondencia> s;
	
	@Before
	public void setUp(){
		
		
		/**
		 * Se nao passarmos comparator, Correspondencia deve
		 * implementar Comparable. De outro modo, uma exceção
		 * do tipo ClassCastException será lançada.
		 * 
		 * Aqui não precisamos implementar hashCode() nem 
		 * equals(), pois essa lógica estará na implementação
		 * de comparação (seja Comparable ou Comparator)!
		 */
//		s = new TreeSet<Correspondencia>();
		
		CorrespondenciaComparator comp = new CorrespondenciaComparator();
		s = new TreeSet<Correspondencia>(comp);
	}
	
	@Test
	public void testAdd(){
		s.add(new Correspondencia("revista 1", 101));
		s.add(new Correspondencia("revista 1", 101));
		
		//a comparação do TreeSet impede de adicionar duplicatas
		assertEquals(1, s.size());
	}
	
	@Test
	public void testRemove(){
		s.add(new Correspondencia("revista 1", 101));
		s.add(new Correspondencia("revista 1", 101));
		s.add(new Correspondencia("revista 1", 102));
		s.add(new Correspondencia("revista 1", 103));
		
		//a comparação do TreeSet impede de adicionar duplicatas
		assertEquals(3, s.size());
		
		Correspondencia c = new Correspondencia("revista 1", 101);
		s.remove(c);
		
		assertEquals(2, s.size());
	}
	
	@Test
	public void testIterator(){
				
		s.add(new Correspondencia("revista 1", 101));		
		s.add(new Correspondencia("revista 2", 101));		
		s.add(new Correspondencia("revista 1", 102));
		s.add(new Correspondencia("revista 2", 102));
		s.add(new Correspondencia("revista 0", 100));
		
		Iterator<Correspondencia> i = s.iterator();
		
		while(i.hasNext()){
			Correspondencia c = i.next();
			System.out.println(c);
			if(c.getAptoDestinatario()==101)
				i.remove();
		}
		
		assertEquals(3, s.size());			
	}
	
	@Test
	public void testContains(){
		s.add(new Correspondencia("revista 1", 101));		
		s.add(new Correspondencia("revista 2", 101));		
		s.add(new Correspondencia("revista 1", 102));
		s.add(new Correspondencia("revista 2", 102));
		
		assertTrue(s.contains(new Correspondencia("revista 2", 102)));
		assertFalse(s.contains(new Correspondencia("revista 0", 101)));
		assertFalse(s.contains(new Correspondencia("revista 1", 104)));
	}

}
