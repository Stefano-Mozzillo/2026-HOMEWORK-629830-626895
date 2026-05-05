package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{
	private String direzione;	

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	@Override
	public void esegui(Partita partita, IO console) {

		if(this.direzione==null) {
			console.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;}
		Stanza prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			console.mostraMessaggio("Direzione inesistente");
			return;}
		partita.setStanzaCorrente(prossimaStanza);
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		partita.getGiocatore().decrementaCFU();
	}	


	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;

	}

}