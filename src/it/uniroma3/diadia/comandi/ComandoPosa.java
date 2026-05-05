package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	@Override
	public void esegui(Partita partita, IO console) {
		if (nomeAttrezzo == null) {
			console.mostraMessaggio("Che attrezzo vuoi posare?");
			return;
		}
		if (partita.getGiocatore().getBorsa().isEmpty()) {
			console.mostraMessaggio("\nLa borsa è vuota!\n");
			return;
		}
		Attrezzo attrezzoDaPosare=partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(attrezzoDaPosare==null) {
			console.mostraMessaggio("\nAttrezzo non presente nella borsa\n"); 	
			return;
		}
		if (partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare)) {
			partita.getGiocatore().removeAttrezzo(nomeAttrezzo);
			console.mostraMessaggio("\nAttrezzo posato!");
			console.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		}
		else {
			console.mostraMessaggio("\nNon è possibile posare l'attrezzo, la stanza è piena!\n");
		}


	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;

	}

}