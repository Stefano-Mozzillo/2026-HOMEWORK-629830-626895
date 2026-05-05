package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	private Stanza stanzaVincente;
	private Stanza stanzaCorrente;
	
	public Labirinto() {
		this.creaLabirinto();	
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
    public void creaLabirinto() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo passepartout = new Attrezzo("passepartout",1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new StanzaBuia("Atrio");
		Stanza aulaN11 = new StanzaMagica("Aula N11");
		Stanza aulaN10 = new StanzaBloccata("Aula N10", "nord", "passepartout");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza bar = new Stanza("Bar");
		Stanza mensa = new Stanza("Mensa");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		bar.impostaStanzaAdiacente("nord", mensa);
		mensa.impostaStanzaAdiacente("sud", bar);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		aulaN10.addAttrezzo(passepartout);
		atrio.addAttrezzo(osso);

		// la stanza vincente del labirinto è biblioteca 
		stanzaVincente= biblioteca;
		stanzaCorrente=atrio;
    }

    
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}
}
