package map;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestHashMapPessoaCadastro {

	private Map <Cadastro, Pessoa> m;

	@Before
	public void setUp() throws Exception {
		m = new HashMap<Cadastro, Pessoa>();
	}

	@Test
	public void testPut() {
		
		Cadastro c1 = new Cadastro(1);
		Cadastro c2 = new Cadastro(1);
		Pessoa p1 = new Pessoa(0, 0, "eduardo");
		Pessoa p2 = new Pessoa(0, 0, "joao");
		
		m.put(c1, p1);
		m.put(c2, p2);
		
		//testar com e sem hashCode e com e sem equals em cadastro
		assertEquals(1, m.size());
		
		Cadastro cAux = new Cadastro(1);
		System.out.println(m.get(cAux).getNome());

	}

}
