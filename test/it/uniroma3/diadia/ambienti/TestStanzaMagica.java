package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanzaMagica {
	private Stanza magica;
	@BeforeEach
	void setUp() {
		magica= new StanzaMagica("magica");

	}
	@Test
	void testAttrezzoAggiuntoPrime3VolteRimaneInvariato() {
		for(int i=0; i<3;i++) 
			assertTrue(magica.addAttrezzo(new Attrezzo("Attrezzo_" +i, 0)));
		for(int i=0; i<3;i++) 
			assertTrue(magica.hasAttrezzo("Attrezzo_" +i));
	}

	@Test
	void testQuartoAttrezzoAggiuntoInverteNome() {
		for(int i=0; i<4;i++) 
			assertTrue(magica.addAttrezzo(new Attrezzo("Attrezzo_" +i, 1)));
		assertFalse(magica.hasAttrezzo("Attrezzo_" +3));
		assertTrue(magica.hasAttrezzo(3+"_ozzerttA"));
	}
	@Test
	void testQuartoAttrezzoAggiuntoRaddoppiaPeso() {
		for(int i=0; i<4;i++) 
			assertTrue(magica.addAttrezzo(new Attrezzo("Attrezzo_" +i, 1)));
		assertTrue(magica.hasAttrezzo(3+"_ozzerttA"));
		assertEquals(magica.getAttrezzo(3+"_ozzerttA").getPeso(),2);

	}
}