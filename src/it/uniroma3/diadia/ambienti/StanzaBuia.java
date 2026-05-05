package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String oggettoMagico;
	
	public StanzaBuia(String nome) {
		this(nome, "lanterna");
	}
	
	public StanzaBuia(String nome, String oggetto) {
		super(nome);
		this.oggettoMagico = oggetto;
	}
	
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(oggettoMagico))
			return super.toString();
		else
			return "Qui c'è buio pesto";
	}
}
