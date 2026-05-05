package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	private String nomeComando;
	private String parametro;
	public Comando costruisciComando(String istruzione) {
		nomeComando =null;
		parametro = null;
		Comando comando= null;
		Scanner scannerDiParole = new Scanner(istruzione);

		// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); 

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();

		if(nomeComando==null)
			comando = new ComandoNonValido();
		else if ("vai".equals(nomeComando))
			comando = new ComandoVai();
		else if ("prendi".equals(nomeComando))
			comando= new ComandoPrendi();
		else if ("posa".equals(nomeComando))
			comando= new ComandoPosa();
		else if ("aiuto".equals(nomeComando))
			comando= new ComandoAiuto();
		else if("fine".equals(nomeComando)) 
			comando = new ComandoFine();
		else if("guarda".equals(nomeComando))
			comando= new ComandoGuarda();
		else
			comando= new ComandoNonValido();
		comando.setParametro(parametro);
		return comando;


	}
	public String getNome() {
		return this.nomeComando;
	}

	public String getParametro() {
		return this.parametro;
	}
}
