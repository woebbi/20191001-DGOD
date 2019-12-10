package woebbiOopDGOD;

import java.util.Arrays;

public class Beet {
	private int nummer;
	private Blume blumenListe[];

	@Override
	public String toString() {
		return "Beet [nummer=" + nummer + ", blumenListe=" + Arrays.toString(blumenListe) + "]";
	}
	
	public Beet(int nummer, Blume[] blumenListe) {
		this.nummer = nummer;
		this.blumenListe = blumenListe;
	}
	
	public void giessen() {
		for (Blume blume : blumenListe) {
			blume.setAktVorrat(blume.getAktVorrat() + DGOD.getGIESSKANNEGROESSE()); 
		}
	}
	
	
	//
	//GETTER UND SETTTER
	//
	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	public Blume[] getBlumeListe() {
		return blumenListe;
	}
	public void setBlumeListe(Blume[] blumenListe) {
		this.blumenListe = blumenListe;
	}
	
}
