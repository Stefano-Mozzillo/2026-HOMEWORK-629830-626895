package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class testBorsa {

	private Borsa borsa;
	private Borsa borsaConUnMartello;
	private Attrezzo martello;
	
//SetUp	
	@BeforeEach
	void setUp() {
		borsa = new Borsa();
		borsaConUnMartello=new Borsa();
		martello = new Attrezzo("martello",4);
		borsaConUnMartello.addAttrezzo(martello);
	}
	
//getPesoMax()	
	@Test
	void testGetPesoMax() {
		assertEquals(borsa.getPesoMax(),10);
	}
//addAttrezzo()
	@Test
	void testAddAttrezzoCorrettamente() {
		assertTrue(borsa.addAttrezzo(martello));
		assertTrue(borsa.hasAttrezzo("martello"));
	}
	
	@Test
	void testAddAttrezzoTroppoPesante() {
		assertFalse(borsa.addAttrezzo(new Attrezzo("spada", 11)));
		assertFalse(borsa.hasAttrezzo("spada"));
	}
	
	@Test
	void testAddAttrezzoConBorsaPiena() {
		for (int i=0;i<10;i++) {
		borsa.addAttrezzo(new Attrezzo("Attrezzo_"+i,0));
		}
		assertFalse(borsa.addAttrezzo(new Attrezzo("piuma", 0)));
		assertFalse(borsa.hasAttrezzo("piuma"));
	}
  
//getAttrezzo()
	
	@Test
	void getAttrezzo_trovato() {
		assertEquals(borsaConUnMartello.getAttrezzo("martello"), martello);
	}
	
	@Test
	void getAttrezzo_introvabile() {
		assertNull(borsa.getAttrezzo("introvabile"));
	}

//hasAttrezzo
	@Test
    void testBorsaConUnAttrezzo_trovato() {
		assertTrue(borsaConUnMartello.hasAttrezzo("martello"));
    }
    
	@Test
    void testBorsaConUnAttrezzo_introvabile() {
		assertFalse(borsa.hasAttrezzo("martello"));
    }
//removeAttrezzo()	
	
	@Test
    void testRimuoviAttrezzoDaStanzaConUnAttrezzo_trovato() {
	    assertEquals(borsaConUnMartello.removeAttrezzo("martello"),martello);
	    assertFalse(borsaConUnMartello.hasAttrezzo("martello"));
	    }
	@Test
	void testRimuoviAttrezzoDaStanzaConUnAttrezzo_introvabile() {
	    assertNull(borsa.removeAttrezzo("martello"));
	    }
	

}