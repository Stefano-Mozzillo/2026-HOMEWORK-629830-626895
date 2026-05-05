package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	/**
	 * Stampa informazioni di aiuto.
	 */

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi", "guarda"};

	@Override
	public void esegui(Partita partita, IO console) {
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");

	}

	@Override
	public void setParametro(String parametro) {

	}
}