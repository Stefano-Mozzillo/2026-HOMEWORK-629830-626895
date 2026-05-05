package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanzaBuia {

	private Stanza stanzaBuia;
	private Attrezzo lanterna;
	private String descrizioneSenzaLanterna;
	private Stanza nord;

	@BeforeEach
	void SetUp() {
		stanzaBuia= new StanzaBuia("buia");
		nord= new Stanza ("nord");
		lanterna= new Attrezzo("lanterna", 3);
		descrizioneSenzaLanterna=stanzaBuia.getDescrizione();
	}


	@Test
	void testDescrizioneStanzaSenzaVicini() {
		assertFalse(stanzaBuia.hasAttrezzo("lanterna"));
		assertEquals(descrizioneSenzaLanterna, stanzaBuia.getDescrizione());
		assertTrue(stanzaBuia.addAttrezzo(lanterna));
		assertNotEquals(descrizioneSenzaLanterna, stanzaBuia.getDescrizione());
	}	
	@Test
	void testDescrizioneStanzaConVicini() {
		stanzaBuia.impostaStanzaAdiacente("nord", nord);
		assertFalse(stanzaBuia.hasAttrezzo("lanterna"));
		assertEquals(descrizioneSenzaLanterna, stanzaBuia.getDescrizione());
		assertTrue(stanzaBuia.addAttrezzo(lanterna));
		assertNotEquals(descrizioneSenzaLanterna, stanzaBuia.getDescrizione());
	}	
	@Test
	void testDescrizioneStanzaConAttrezzoDiversoDaLanterna() {
		stanzaBuia.impostaStanzaAdiacente("nord", nord);
		assertTrue(stanzaBuia.addAttrezzo(new Attrezzo("martello",1)));
		assertFalse(stanzaBuia.hasAttrezzo("lanterna"));
		assertEquals(descrizioneSenzaLanterna, stanzaBuia.getDescrizione());

	}	
}