package set;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;


public class TestHashSet {

	private Set<Correspondencia> s;
	
	@Before
	public void setUp(){
		
		/**
		 * Aqui não precisamos implementar Comparable ou 
		 * Comparator, mas precisamos implementar hashCode()
		 * e equals().
		 */
		s = new HashSet<Correspondencia>();
	}
	
	@Test
	public void testAdd(){
		Correspondencia c1 = new Correspondencia("revista 1", 101);
		Correspondencia c2 = new Correspondencia("revista 1", 101);
		Correspondencia c3 = new Correspondencia("revista 1", 101);
		
		System.out.println("c1: "+c1.hashCode());
		System.out.println("c2: "+c2.hashCode());
		System.out.println("c3: "+c3.hashCode());
		
		s.add(c1);
		s.add(c2);
		s.add(c3);
		
		//esse teste só passa se o equals e hash estiverem implementado
		assertEquals(1, s.size());
		
		s.add(new Correspondencia("revista 2", 101));
		assertEquals(2, s.size());
		
		s.add(new Correspondencia("revista 1", 102));
		s.add(new Correspondencia("revista 2", 102));
		assertEquals(4, s.size());
	}
	
	@Test
	public void testRemove(){
		s.add(new Correspondencia("revista 1", 101));		
		s.add(new Correspondencia("revista 2", 101));		
		s.add(new Correspondencia("revista 1", 102));
		s.add(new Correspondencia("revista 2", 102));
		
		Correspondencia c = new Correspondencia("revista 1", 101);
		s.remove(c);
		assertEquals(3, s.size());
	}
	
	
	
	@Test
	public void testIterator(){
		s.add(new Correspondencia("revista 1", 101));		
		s.add(new Correspondencia("revista 2", 101));		
		s.add(new Correspondencia("revista 1", 102));
		s.add(new Correspondencia("revista 2", 102));
		
		Iterator<Correspondencia> i = s.iterator();
		
		while(i.hasNext()){
			Correspondencia c = i.next();
			System.out.println(c);
			if(c.getAptoDestinatario()==101)
				i.remove();
		}
		
		assertEquals(2, s.size());			
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
