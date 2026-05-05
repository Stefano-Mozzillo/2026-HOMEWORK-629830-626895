package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.ambienti.Stanza;

class testPartita {
	
	private Partita partita;
	
	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
	}

	
//vinta()
	@Test
	void testPartitaVintaInStanzaFinale() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaFinale());
		assertTrue(this.partita.vinta());
		assertFalse(this.partita.vinta()==false);
	}
	
	@Test
	void testPartitaVintaNonInStanzaFinale() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaCorrente());
		assertFalse(this.partita.vinta());
	}
	
	
//isFinita()
	@Test
	void testPartitaFinitaCFU_0() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
		assertFalse(this.partita.isFinita()==false);
	}

	@Test
	void testPartitaFinitaVinta() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaFinale());
		assertTrue(this.partita.isFinita());
	}
	
//setStanzaCorrente()
	@Test
	void testCorrettaCreazioneStanzaCorrente() {
		Stanza mensa = new Stanza("Mensa");
		partita.setStanzaCorrente(mensa);
		assertEquals(mensa,partita.getStanzaCorrente());
	}

}
