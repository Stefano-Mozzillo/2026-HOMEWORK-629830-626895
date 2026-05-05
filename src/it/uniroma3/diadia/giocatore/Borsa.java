package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Borsa per tenere conto dell'inventario
 * del giocatore
 * Ha ha un limite di peso e numero di attrezzi
 * @author docente di poo
 * @see Attrezzo
 */

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;	//peso massimo della borsa
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	/**
	 * Crea la borsa. Definisce il numero massimo di attrezzi
	 * Non ci sono attrezzi
	 * @param il peso massimo della borsa
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	
	/**
	 * Verifica la possibilità di aggiungere un attrezzo alla borsa
	 * @param attrezzo
	 * @return true se ha aggiunto l'attrezzo in borsa
	 * 		   false se il peso supera il limite o se la borsa è piena
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	/**
	 * Metodo per inserire il peso massimo
	 * @return peso massimo
	 */
	public int getPesoMax() {
		return pesoMax;
	}
	
	/**
	 * Cerca l'attrezzo nella borsa e salva il riferimento in a
	 * @param nomeAttrezzo
	 * @return a: rierimento all'attrezzo
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}
	
	/**
	 * Aggiunge il peso dell'attrezzo trovato
	 * @return peso aggiornato
	 */
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
		}
	
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	/**
	 * Controlla se nella borsa è presente l'attrezzo
	 * @param nomeAttrezzo
	 * @return	true se è presente
	 * 		    false se non è presente
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i=0; i<this.numeroAttrezzi; i++) {
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a=attrezzi[i];
				this.attrezzi[i]=this.attrezzi[this.numeroAttrezzi-1];
				this.numeroAttrezzi = this.numeroAttrezzi-1;
				return a;
			}
		}
		return a;
	}
	
	/**
	 * Stampa il contenuto della borsa
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
