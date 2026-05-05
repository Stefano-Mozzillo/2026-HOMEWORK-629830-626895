package it.uniroma3.diadia.comandi;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class ComandoPosaTest {
	private FabbricaDiComandi factory;
	private Comando comandoDaEseguire;
	private Partita partita;
	private Stanza piena;
	private Borsa borsa;
	private IOConsole console;
	private Attrezzo martello;

	@BeforeEach
	void setUp() {
		partita=new Partita();
		console=new IOConsole();
		factory = new FabbricaDiComandiFisarmonica();
		martello=new Attrezzo("martello",1);
		comandoDaEseguire=factory.costruisciComando("posa martello");
		borsa= partita.getGiocatore().getBorsa();
	}




	@Test
	void testAttrezzoPosatoDaBorsa_Trovato_e_RimossoDaBorsa_InseritoInStanzaCorrente() {
		assertEquals(partita.getStanzaCorrente().getNome(),"Atrio");
		assertTrue(borsa.addAttrezzo(martello));
		comandoDaEseguire.esegui(partita, console);
		assertNull(borsa.getAttrezzo("martello"));
		assertEquals(partita.getStanzaCorrente().getAttrezzo("martello"),martello);

	}
	@Test
	void testAttrezzoPosatoDaBorsa_Introvabile() {
		assertEquals(partita.getStanzaCorrente().getNome(),"Atrio");
		assertTrue(borsa.addAttrezzo(new Attrezzo("spada",1)));
		comandoDaEseguire.esegui(partita, console);
		assertEquals(borsa.getAttrezzo("spada").getNome(),"spada");

	}

	@Test
	void testAttrezzoPosatoDaBorsa_ParametroNull() {
		assertEquals(partita.getStanzaCorrente().getNome(),"Atrio");
		comandoDaEseguire=factory.costruisciComando("posa");
		assertTrue(borsa.addAttrezzo(martello));
		comandoDaEseguire.esegui(partita, console);
		assertEquals(borsa.getAttrezzo("martello").getNome(),"martello");

	}

	@Test
	void testAttrezzoPosatoDaBorsa_StanzaPiena() {
		assertEquals(partita.getStanzaCorrente().getNome(),"Atrio");
		comandoDaEseguire=factory.costruisciComando("posa martello");
		assertTrue(borsa.addAttrezzo(martello));
		piena=partita.getStanzaCorrente();
		for(int i=0; i<9;i++)  //atrio ha già un oggetto per costruzione
			assertTrue(piena.addAttrezzo(new Attrezzo("Attrezzo_" +i, i)));
		comandoDaEseguire.esegui(partita, console);
		assertNull(piena.getAttrezzo("martello"));
	}
}
