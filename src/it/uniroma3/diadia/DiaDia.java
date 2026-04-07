package it.uniroma3.diadia;



import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi"};

	private Partita partita;
	private Giocatore giocatore;
	private IOConsole console;
	

	public DiaDia(IOConsole console) {
		this.console = console; //altrimenti nullPointerException
		this.partita = new Partita();
		this.giocatore = this.partita.getGiocatore();
	}

	public void gioca() {
		String istruzione; 
		console.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		
		do	{	
			istruzione = console.leggiRiga();}
		while (!processaIstruzione(istruzione));
	}   
	

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine") || partita.isFinita()) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posaAttrezzo(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendiAttrezzo(comandoDaEseguire.getParametro());
		else
			console.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			console.mostraMessaggio("Hai vinto!");
			return true;}
		else if (this.partita.isFinita()){
			console.mostraMessaggio("");
			console.mostraMessaggio("Hai perso! Hai finito i cfu.");
			console.mostraMessaggio("Grazie per aver giocato");
			return true;
			}	
		else
			return false;
	}   

	// implementazioni dei comandi dell'utente:
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
		
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			console.mostraMessaggio("Dove vuoi andare?");
			return;}
		Stanza prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			console.mostraMessaggio("Direzione inesistente");
		    return;}
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			this.giocatore.decrementaCFU();
			; //CORREZIONE: in java cfu-- restituisce 20, decrementando la variabile locale
		}                               //settando a 20 i cfu.
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	
	private void posaAttrezzo(String nomeAttrezzo) {
		if (nomeAttrezzo == null) {
			console.mostraMessaggio("Che attrezzo vuoi posare?");
			return;
		}
		if (this.giocatore.getBorsa().isEmpty()) {
			console.mostraMessaggio("\nLa borsa è vuota!\n");
			return;
		}
            Attrezzo attrezzoDaPosare=this.giocatore.getBorsa().getAttrezzo(nomeAttrezzo);
            if(attrezzoDaPosare==null) {
			    console.mostraMessaggio("\nAttrezzo non presente nella borsa\n"); 	
		        return;
		    }
			if (this.partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare)) {
				this.giocatore.removeAttrezzo(nomeAttrezzo);
				console.mostraMessaggio("\nAttrezzo posato!");
				console.mostraMessaggio(this.giocatore.getBorsa().toString());
			}
			else {
				console.mostraMessaggio("\nNon è possibile posare l'attrezzo, la stanza è piena!\n");
			}
	
		}
	
	
	private void prendiAttrezzo(String nomeAttrezzo) {
		if (nomeAttrezzo == null) {
			console.mostraMessaggio("Che attrezzo vuoi prendere?");
			return;
		}
		Attrezzo attrezzoDaPrendere = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		    if(attrezzoDaPrendere==null) {
			    console.mostraMessaggio("\nAttrezzo non presente nella stanza\n");
		        return;
		    }
			if (this.giocatore.addAttrezzo(attrezzoDaPrendere)) { 
				this.partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
				console.mostraMessaggio("\nAttrezzo preso!");
				console.mostraMessaggio(this.giocatore.getBorsa().toString());
			}
			else {
				
			    console.mostraMessaggio("\nBorsa piena o troppo pesante\n");
		        
		        
				
			}
			 
		    
		}
		
	


	/**
	 * Comando "Fine".
	 */
	private void fine() {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia(new IOConsole());
		gioco.gioca();
	}

}
