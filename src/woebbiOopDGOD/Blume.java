package woebbiOopDGOD;

public class Blume {
	private int aktVorrat;
	private BlumenArt blumenArt;
	
	@Override
	public String toString() {
		return "Blume [aktVorrat=" + aktVorrat + ", blumenArt=" + blumenArt + "]";
	}
	
	public Blume(BlumenArt blumenArt) {
		if(DGOD.getSTARTWASSERVORRAT() * blumenArt.getTagesVerbrauch() > blumenArt.getMaximalVorrat()) {
			this.aktVorrat = blumenArt.getMaximalVorrat();
		}else {
			this.aktVorrat = DGOD.getSTARTWASSERVORRAT() * blumenArt.getTagesVerbrauch();
		}
		this.blumenArt = blumenArt;
	}
	
	public boolean istAmLeben() {
		if( this.aktVorrat < 0 || this.aktVorrat > this.blumenArt.getMaximalVorrat() ) {
			return false;
		}
		return true;
	}
	
	public void verbrauchtWasser() {
		this.aktVorrat = this.aktVorrat - this.blumenArt.getTagesVerbrauch();
	}
	
	//
	//GETTER UND SETTTER
	//
	public int getAktVorrat() {
		return aktVorrat;
	}

	public void setAktVorrat(int aktVorrat) {
		this.aktVorrat = aktVorrat;
	}

	public BlumenArt getBlumenArt() {
		return blumenArt;
	}

	public void setBlumenArt(BlumenArt blumenArt) {
		this.blumenArt = blumenArt;
	}

}
