package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @s-'ee Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private Giocatore giocatore;
	private Stanza stanzaCorrente;
	//private Stanza stanzaVincente;//labirinto
	
	
	public Partita(){
		this.labirinto=new Labirinto();
		this.giocatore= new Giocatore();
		stanzaCorrente = labirinto.getStanzaCorrente();
	}



	public Giocatore getGiocatore() {	
		return this.giocatore;
	}


	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == labirinto.getStanzaVincente();
	}
	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return vinta() || giocatore.getCfu()==0;
	}

	public Labirinto getLabirinto() {	
		return this.labirinto;
	}
	
}

	

