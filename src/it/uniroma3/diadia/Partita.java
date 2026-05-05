package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	public Stanza stanzaCorrente;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore();
		stanzaCorrente = labirinto.getStanzaCorrente();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.labirinto.getStanzaFinale();
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public boolean giocatoreIsVivo() {
		return giocatore.getCfu()!=0;
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return !giocatoreIsVivo() || vinta();
	}
		
	/**
	 * Restituisce il labirinto della classe partita alla classe DiaDia
	 * Per avere un solo labirinto
	 * @return riferimento a questo labirinto
	 */
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	/**
	 * Restituisce il giocatore della classe partita alla classe DiaDia
	 * Per avere un solo giocatore
	 * @return riferimento a questo giocatore
	 */
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
}
