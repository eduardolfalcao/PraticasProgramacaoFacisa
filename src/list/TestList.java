package list;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class TestList {

	List<String> l;
	
	/**
	 * Não importa qual tipo de lista é usado, o resultado final
	 * será o mesmo. No entanto, em determinados aspectos, como
	 * por exemplo, desempenho (tempo) e utilização eficiente da
	 * memória, um tipo de lista pode ser mais adequado do que 
	 * outro tipo de lista. 
	 */
	@Before
	public void setUp(){		
//		l = new ArrayList<String>();
//		l = new Vector<String>();
		l = new LinkedList<String>();
	}
	
	@Test
	public void testAddPorObject() {
		l.add("eduardo");
		l.add("joao");
		l.add("maria");
		
		assertEquals("eduardo", l.get(0));
	}
	
	@Test
	public void testAddPorIndice() {
		l.add("eduardo");
		l.add("joao");
		l.add(0, "maria");
		
		assertEquals("maria", l.get(0));
		assertEquals("eduardo", l.get(1));
		assertEquals("joao", l.get(2));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddPorIndiceForaDosLimites() {
		l.add("eduardo");
		l.add("joao");
		l.add(0, "maria");
		
		l.add(10, "jose");
				
		assertEquals("jose", l.get(10));
	}
	
	@Test
	public void testAddPorIndiceDentroDosLimites() {
		l.add("eduardo");
		l.add("joao");
		l.add(0, "maria");
		
		l.add(0, "jose");
		
		assertEquals("jose", l.get(0));
	}
	
	@Test
	public void testRemovePorIndice() {
		l.add("eduardo");
		l.add("joao");
		l.add("maria");
		
		l.remove(0);
		assertEquals("joao", l.get(0));
	}
	
	@Test
	public void testRemovePorObject() {
		l.add("eduardo");
		l.add("joao");
		l.add("maria");
		
		l.remove("joao");
		assertEquals("maria", l.get(1));
	}
	
	@Test(expected=ConcurrentModificationException.class)
	public void testRemoveDentroDeForEach() {
		l.add("eduardo_prof");
		l.add("joao");
		l.add("maria");
		
		for(String n : l){
			if(n.contains("_prof"))
				l.remove(n);				
		}
	}
	
	@Test
	public void testRemoveDentroDeFor() {
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("maria");
		
		for(int i = 0; i < l.size(); i++){
			if(l.get(i).contains("_prof"))
				l.remove(i);				
		}
		
		//o tamanho do arrayList diminui e o for fica inconsistente
		//por esta razão, este assert está incorreto
		assertEquals(1, l.size());
	}
	
	@Test
	public void testRemoveComIterator() {
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("eduardo_prof");
		l.add("maria");
		
		Iterator<String> i = l.iterator();
		while(i.hasNext()){
			String n = i.next();
			if(n.contains("_prof"))
				i.remove();	
		}
		
		//com o iterator funciona
		assertEquals(1, l.size());
	}
	
	@Test
	public void testGetPorIndice() {
		l.add("eduardo");
		l.add("joao");
		l.add("maria");
		
		assertEquals("joao", l.get(1));
	}
	
	@Test
	public void testIndexOf() {
		l.add("eduardo");
		l.add("joao");
		l.add("joao");
		l.add("maria");
		
		assertEquals(1, l.indexOf("joao"));
	}
	
	@Test
	public void testContains() {
		l.add("eduardo");
		l.add("joao");
		l.add("joao");
		l.add("maria");
		
		assertTrue(l.contains("maria"));
	}	

}
