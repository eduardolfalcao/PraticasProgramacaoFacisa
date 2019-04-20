package map;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import set.Correspondencia;

public class TestHashMap {
	
	private Map <String, Integer> m;
	
	@Before
	public void setUp(){
//		m = new HashMap<String, Integer>();
//		m = new Hashtable<String, Integer>();
		m = new LinkedHashMap<String, Integer>();
//		m = new TreeMap<String, String>();
	}
	
	@Test
	public void testPut(){
		m.put("string qualquer", 50);
		assertEquals(1, m.size());
		
		m.put("string qualquer", 30);
		assertEquals(1, m.size());
		
		m.put("string qualquer", 50);
		assertEquals(1, m.size());
		
		
		System.out.println(m.get("string qualquer"));
		
		String c = new String("string qualquer");
		System.out.println(c.hashCode());
		String c1 = new String("String qualquer");
		System.out.println(c1.hashCode());

	}
	
	@Test
	public void testRemove(){
		m.put("string qualquer", 60);
		m.put("outra string", 60);
		assertEquals(2, m.size());
		m.remove("string qualquer");
		assertEquals(1, m.size());
	}

	@Test
	public void testGet(){
		m.put("string qualquer", 20);
		m.put("string qualquer", 30);
		
		assertEquals(1, m.size());
		assertEquals(30,(int)m.get("string qualquer"));
		
		assertNull(m.get(30));
	}
	
	@Test
	public void testIterator(){
		m.put("string1", 1);
		m.put("string2", 2);
		m.put("string3", 3);
		m.put("string4", 4);
		m.put("string5", 4);
		m.put("string11", 4);
		m.put("string22", 4);
		m.put("string33", 4);
		m.put("string44", 4);
		m.put("string55", 4);
		
		Iterator<Entry<String, Integer>> i = m.entrySet().iterator();
		
		while(i.hasNext()){
			Entry<String, Integer> thisEntry = i.next();
			String key = (String) thisEntry.getKey();
			int value = (Integer) thisEntry.getValue();
			System.out.println(key+" - "+value);
			if(key.contains("2"))
				i.remove();
		}
		
		assertEquals(8, m.size());
	}
	
	@Test
	public void testContains(){
		m.put("string1", 20);
		m.put("string2", 20);
		
		assertTrue(m.containsKey("string1"));
		assertTrue(m.containsValue(20));
		assertFalse(m.containsValue("string1"));
		assertEquals(m.get("cadeira1"), m.get("cadeira2"));
		
		
	}

}
