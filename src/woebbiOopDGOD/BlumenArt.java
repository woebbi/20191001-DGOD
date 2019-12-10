package woebbiOopDGOD;

public class BlumenArt {
	private int nummer;
	private String name;
	private int tagesVerbrauch;
	private int maximalVorrat;
	private int punkte;
	
	@Override
	public String toString() {
		return "BlumenArt [nummer=" + nummer + ", name=" + name + ", tagesVerbrauch=" + tagesVerbrauch
				+ ", maximalVorrat=" + maximalVorrat + ", punkte=" + punkte + "]";
	}
	
	public BlumenArt(int nummer , String name, int tagesVerbrauch, int maximalVorrat, int punkte) {
		if(nummer >= 0) {
			this.nummer = nummer;
		}else {
			System.out.println("BlumenArt[Nummer] ist falsch mit den Wert" + nummer);
			System.exit(1);
		}
		
		if(name.equals("") || name.length() == 0) {
			System.out.println("BlumenArt[name] ist falsch mit den Wert" + name);
			System.exit(1);
		}else {
			this.name = name;
		}
				
		if(tagesVerbrauch >= 0) {
			this.tagesVerbrauch = tagesVerbrauch;	
		}else {
			System.out.println("BlumenArt[tagesVerbrauch] ist falsch mit den Wert" + tagesVerbrauch);
			System.exit(1);
		}
		
		if(maximalVorrat >= 0) {
			this.maximalVorrat = maximalVorrat;	
		}else {
			System.out.println("BlumenArt[maximalVorrat] ist falsch mit den Wert" + maximalVorrat);
			System.exit(1);
		}
		
		if(punkte >= 0) {
			this.punkte = punkte;	
		}else {
			System.out.println("BlumenArt[punkte] ist falsch mit den Wert" + punkte);
			System.exit(1);
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTagesVerbrauch() {
		return tagesVerbrauch;
	}
	public void setTagesVerbrauch(int tagesVerbrauch) {
		this.tagesVerbrauch = tagesVerbrauch;
	}
	public int getMaximalVorrat() {
		return maximalVorrat;
	}
	public void setMaximalVorrat(int maximalVorrat) {
		this.maximalVorrat = maximalVorrat;
	}
	public int getPunkte() {
		return punkte;
	}
	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}

}
