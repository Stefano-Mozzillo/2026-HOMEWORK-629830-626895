package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class GiocatoreTest {
private Giocatore giocatore;
	
@BeforeEach
void setUp() {
	giocatore = new Giocatore();
}
	
//getCfu()
	@Test
	void testLaPartitaIniziaCon20CFU() {
		assertEquals(giocatore.getCfu(),20);
	}
//decrementaCfu()	
	@Test
	void testDecrementaCfu() {
		giocatore.decrementaCFU();
		assertEquals(giocatore.getCfu(),19);
	}
//addAttrezzo()
	@Test
	void testSeAttrezzoVieneAggiuntoRitornaTrue() {		
		Attrezzo spada= new Attrezzo("spada",4);
		assertTrue(giocatore.addAttrezzo(spada));
		
//setAttrezzzo()	
	}
	@Test
	void testSeAttrezzoNonVieneAggiuntoRitornaFalse() {
		Attrezzo spada= new Attrezzo("spada",50); //la spada è troppo pesante
		assertFalse(giocatore.addAttrezzo(spada));}
//setCfu();	
	@Test
	void testSetCfu() {
		giocatore.setCfu(0);
		assertEquals(0,giocatore.getCfu());
	}
}

		
		

