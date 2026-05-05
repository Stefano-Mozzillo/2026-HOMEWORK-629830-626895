package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita, IO console) {
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		console.mostraMessaggio("Contenuto borsa: " + partita.getGiocatore().getBorsa().toString());
		console.mostraMessaggio("CFU:" + partita.getGiocatore().getCfu());		
	}

	@Override
	public void setParametro(String parametro) {
		
	}

}