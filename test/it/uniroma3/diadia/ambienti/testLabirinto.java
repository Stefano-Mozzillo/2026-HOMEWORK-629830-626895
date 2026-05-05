package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class testLabirinto {
	
	private Labirinto labirinto;

	@BeforeEach
	public void setUp() {
		this.labirinto = new Labirinto();
	}

//getStanzaCorrente()
	@Test
	void testEsisteStanzaCorrente() {
		assertFalse(labirinto.getStanzaCorrente()==null);
	}
	
//getStanzaFinale()	
	@Test
	void testEsisteStanzaFinale() {
		assertFalse(labirinto.getStanzaFinale()==null);
	}

//Direzioni	
	@Test
	void testEsistonoUsciteDaAtrio_Nord() {
		Stanza iniziale = labirinto.getStanzaCorrente();
	    String direzione = "nord";
	    Stanza adiacente = iniziale.getStanzaAdiacente(direzione);
		assertFalse(adiacente==null);
	}

	@Test
	void testEsistonoUsciteDaAtrio_Sud() {
		Stanza iniziale = labirinto.getStanzaCorrente();
	    String direzione = "sud";
	    Stanza adiacente = iniziale.getStanzaAdiacente(direzione);
		assertFalse(adiacente==null);
	}
	
	@Test
	void testEsistonoUsciteDaAtrio_Ovest() {
		Stanza iniziale = labirinto.getStanzaCorrente();
	    String direzione = "ovest";
	    Stanza adiacente = iniziale.getStanzaAdiacente(direzione);
		assertFalse(adiacente==null);
	}
	
	@Test
	void testEsistonoUsciteDaAtrio_Est() {
		Stanza iniziale = labirinto.getStanzaCorrente();
	    String direzione = "est";
	    Stanza adiacente = iniziale.getStanzaAdiacente(direzione);
		assertFalse(adiacente==null);
	}
}
