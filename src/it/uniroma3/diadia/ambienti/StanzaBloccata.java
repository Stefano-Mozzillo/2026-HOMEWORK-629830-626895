package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	String direzioneBloccata;
	String oggettoMagico;
	
	public StanzaBloccata(String nome, String direzione, String oggetto) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.oggettoMagico = oggetto;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!super.hasAttrezzo(oggettoMagico) && direzione.equals(direzioneBloccata))
			return null;
		else
			return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(oggettoMagico))
			return super.getDescrizione();
		else {
			StringBuilder risultato = new StringBuilder();
			risultato.append(super.toString());
			risultato.append("\n Direzione Bloccata: "+ direzioneBloccata);
			return risultato.toString();
		}
	}
}
