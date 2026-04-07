package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class LabirintoTest {
private Labirinto labirinto;

@BeforeEach
	void setUp() {
	labirinto=new Labirinto();
}
	@Test
	void testStanzaVincenteInBiblioteca() {
		assertEquals(labirinto.getStanzaVincente().getNome(),"Biblioteca");
	}
	@Test
	void testStanzaInizialeNonVincente() {
		assertNotEquals(labirinto.getStanzaVincente().getNome(),"Atrio");
	}
	@Test
	void testStanzaInizialeInAtrio() {
		assertEquals(labirinto.getStanzaCorrente().getNome(),"Atrio");
	}
}

