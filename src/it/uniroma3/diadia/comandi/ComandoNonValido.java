package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	@Override
	public void esegui(Partita partita, IO console) {
		console.mostraMessaggio("comando non valido, riprova");
		
	}

	@Override
	public void setParametro(String parametro) {
		
	}

}