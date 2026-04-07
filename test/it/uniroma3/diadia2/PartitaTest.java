package it.uniroma3.diadia2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;



class PartitaTest {
	
	private Partita partita;
	private Stanza aulaN11;
	
	
	@BeforeEach
	public void setUp() {
		partita = new Partita();
	}

	
//vinta()
	@Test
	void testPartitaVintaInStanzaFinale() {
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
		assertTrue(partita.vinta());
		assertFalse(partita.vinta()==false);
	}
	
	@Test
	void testPartitaVintaNonInStanzaFinale() {
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaCorrente());
		assertFalse(this.partita.vinta());
	}
	
	
//isFinita()
	@Test
	void testPartitaFinitaCFU_0() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());
	}

	@Test
	void testPartitaFinitaVinta() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(partita.isFinita());
	}
//setStanzaCorrente()
	@Test
	void testNuovaStanzaCorrenteInseritaCorrettamente() {
		aulaN11=new Stanza("aulaN11");
		partita.setStanzaCorrente(aulaN11);
		assertEquals(partita.getStanzaCorrente().getNome(),"aulaN11");
	}
	

}


