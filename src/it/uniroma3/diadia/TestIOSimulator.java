package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestIOSimulator {
	
	private Partita partita;

	@Test
	void testPartitaBase_VinciAndandoVersoNord() {
		String[] comandi={"vai nord"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		partita=gioco.getPartita();
		gioco.gioca();
		assertTrue(partita.isFinita());

	}
	
	@Test
	void testPartitaBase_NessunAttrezzoInBorsa() {
		String[] comandi={"vai nord"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		partita=gioco.getPartita();
		gioco.gioca();
		assertTrue(partita.getGiocatore().getBorsa().isEmpty());
	}
	
	@Test
	void testPartitaBase_PrendoOssoDaAtrio() {
		String[] comandi={"prendi osso", "vai nord"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		partita=gioco.getPartita();
		gioco.gioca();
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
	
	@Test
	void testPartitaBase_PrendoOssoDaAtrio_PosoOsso() {
		String[] comandi={"prendi osso","posa osso", "vai nord"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		partita=gioco.getPartita();
		gioco.gioca();
		assertTrue(partita.getGiocatore().getBorsa().isEmpty());
	}

	@Test
	void testPartitaBase_PersaFineCFU() {
		String[] comandi = new String[40];
		for(int i=0; i<20; i++) {
			comandi[i*2]="vai sud";
			comandi[i*2+1]= "vai nord";
		}
		IOSimulator io = new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		partita=gioco.getPartita();
		gioco.gioca();
		assertTrue(partita.isFinita());
		assertFalse(partita.vinta());
	}
	
	@Test
	void testPartitaBase_PrendoOsso_CambioStanza_PosoOsso_TornoInAtrio() {
		String[] comandi={"prendi osso","vai est","posa osso", "vai ovest", "vai nord"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		partita=gioco.getPartita();
		gioco.gioca();
		assertTrue(partita.getGiocatore().getBorsa().isEmpty());
		assertTrue(partita.isFinita());
		assertTrue(partita.vinta());
	}
	
	@Test
	void testPartitaBase_VadoSud_PrendoLanterna_TornoInAtrio_PrendoOsso_VadoNord() {
		String[] comandi={"vai sud", "prendi lanterna", "vai nord", "prendi osso", "vai nord"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		partita=gioco.getPartita();
		gioco.gioca();
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
		assertTrue(partita.isFinita());
		assertTrue(partita.vinta());
	}
	
}
