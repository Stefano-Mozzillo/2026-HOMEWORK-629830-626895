package it.uniroma3.diadia;

public class IOSimulator implements IO {

	private String[] righeDaInserire;
	private int indiceRigheDaInserire;
	public IOSimulator(String[] comandi) {
		this.righeDaInserire=comandi;	
		this.indiceRigheDaInserire=0;	
	}
	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println("\n" + messaggio);
	}

	@Override
	public String leggiRiga() {
		String comando=new String(righeDaInserire[indiceRigheDaInserire]);
		indiceRigheDaInserire++;
		System.out.println("\n>>> comando inserito: " + comando);
		return comando;
		
	}
}
