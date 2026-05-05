package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
private String nomeAttrezzo;
	@Override
	public void esegui(Partita partita, IO console) {
		if (nomeAttrezzo == null) {
			console.mostraMessaggio("Che attrezzo vuoi prendere?");
			return;
		}
		Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		    if(attrezzoDaPrendere==null) {
			    console.mostraMessaggio("\nAttrezzo non presente nella stanza\n");
		        return;
		    }
			if (partita.getGiocatore().addAttrezzo(attrezzoDaPrendere)) { 
				partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
				console.mostraMessaggio("\nAttrezzo preso!");
				console.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
			}
			else {
				
			    console.mostraMessaggio("\nBorsa piena o troppo pesante\n");			
			}
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
		
	}

}