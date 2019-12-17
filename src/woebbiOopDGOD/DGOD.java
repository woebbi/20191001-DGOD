package woebbiOopDGOD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class DGOD {
    private int punkteStand;
    private int tag;
    private Beet[] beeteListe;

    private static final int ANZAHLBLUMENAMSTART = 7;
    private static final int GIESSKANNEGROESSE = 12;
    private static final int STARTWASSERVORRAT = 3;
    private static final double WARSCHEINLICHKEITNEUEBLUME = 0.5;
    private static final int TAGEBISARMAGEDDON = 60;

    @Override
    public String toString() {
        return "DGOD [punkteStand=" + punkteStand + ", tag=" + tag + ", beeteListe=" + Arrays.toString(beeteListe)
                + ", ANZAHLBLUMENAMSTART=" + ANZAHLBLUMENAMSTART + ", GIESSKANNEGROESSE=" + GIESSKANNEGROESSE
                + ", STARTWASSERVORRAT=" + STARTWASSERVORRAT + ", WARSCHEINLICHKEITNEUEBLUME="
                + WARSCHEINLICHKEITNEUEBLUME + ", TAGEBISAMAGEDON=" + TAGEBISARMAGEDDON + "]";
    }

    public DGOD(int punkteStand, int tag, Beet[] beeteListe) {
        if (punkteStand >= 0) {
            this.punkteStand = punkteStand;
        } else {
            System.out.println("DGOD[punkteStand] ist falsch mit den Wert" + punkteStand);
            System.exit(1);
        }

        if (tag >= 0) {
            this.tag = tag;
        } else {
            System.out.println("DGOD[tag] ist falsch mit den Wert" + tag);
            System.exit(1);
        }

        if (beeteListe.length > 0) {
            this.beeteListe = beeteListe;
        } else {
            System.out.println("DGOD[beeteListe] ist falsch mit den Wert" + Arrays.toString(beeteListe));
            System.exit(1);
        }

    }


    public void bienchenSchwarm(Beet bQ, Beet bZ) {
        //TODO
        for (Blume QuellBeet : bQ.getBlumeListe()) {
            //QuellBeet. = ;
            System.out.println(QuellBeet);
        }
    }

    public static String[][] getArten() {
        String csvFile = "c:/Users/Administrator/Documents/woebke/PT - Lan - Java/dieGartenSimulationOFDEATH/gartensimulationBlumenarten.CSV";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ";";
        String[][] liste = new String[5][5];
        int littleCounter = 0;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] stuff = line.split(csvSplitBy);
                for (int i = 0; i < stuff.length; i++) {
                    liste[littleCounter][i] = stuff[i];
                }
                //liste[littleCounter] = stuff;
                //System.out.println("Blumentyp [ID=" + blumentypDaten[0] + " , Name=" + blumentypDaten[1] + "] , Verbrauch=" + blumentypDaten[2] + "] , Vorrat=" + blumentypDaten[3] + "] , Quotient=" + blumentypDaten[4] + "]");
                littleCounter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return liste;
    }

    //
    //GETTER UND SETTTER
    //
    public int getPunkteStand() {
        return punkteStand;
    }

    public void setPunkteStand(int punkteStand) {
        this.punkteStand = punkteStand;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public Beet[] getBeeteListe() {
        return beeteListe;
    }

    public void setBeeteListe(Beet[] beeteListe) {
        this.beeteListe = beeteListe;
    }

    public static int getANZAHLBLUMENAMSTART() {
        return ANZAHLBLUMENAMSTART;
    }

    public static int getGIESSKANNEGROESSE() {
        return GIESSKANNEGROESSE;
    }

    public static int getSTARTWASSERVORRAT() {
        return STARTWASSERVORRAT;
    }

    public static double getWARSCHEINLICHKEITNEUEBLUME() {
        return WARSCHEINLICHKEITNEUEBLUME;
    }

    public static int getTAGEBISARMAGEDDON() {
        return TAGEBISARMAGEDDON;
    }


    public static void main(String[] args) {
		/*
ZUERST VORBEREITUNG
		csv einlesen um arten zumachen
		7 blumena jede art muss vorhanden sein
		7 blumen auf 5 beete verteil zufall
		liste mit den 5 beeten erstellen

der TAG ablauf
        mit füß schleife DO WEHILE laufe solange:
                q                                     benutzer nicht abgebrochen hat
                                                      noch nicht tag 60 vorbei
                                                      blumen exestieren
        tag nummer ausgeben
        beete mit den blumen(wenn vorhanden)
                        blumen füllstand angeben
        schleife für beet ob geißen
               abfrage ov gegegngen werden soll
               auswertung ob ja oder nein
               ja: gißen, aller blume pro beet , prüfen ob ertrunken
               nein:foo
        endsvhleife
        abfrage ob bienschawr, kommmt
        ja:
            abfrage start und ziel beet
        nein:




		 *

		 */

        String[][] blumenArtListe = getArten();
        BlumenArt[] Blumen = new BlumenArt[blumenArtListe.length];
        //Füllt die blumenarten in "Blumen"
        for (int k = 0; k < blumenArtListe.length; k++) {
            Blumen[k] = new BlumenArt(Integer.parseInt(blumenArtListe[k][0]), blumenArtListe[k][1], Integer.parseInt(blumenArtListe[k][2]), Integer.parseInt(blumenArtListe[k][3]), Integer.parseInt(blumenArtListe[k][4]));
        }


        //Eine Liste mit 7 Blumen wird generiert
        Blume[] blumenListe = new Blume[ANZAHLBLUMENAMSTART];
        for (int f = 0; f < ANZAHLBLUMENAMSTART; f++) {
            if (f < blumenArtListe.length) { // für die ersten 5 wird einfach die
                blumenListe[f] = new Blume(Blumen[f]);
            } else { //für den rest wird random genommen
                Random random = new Random();
                int num = random.nextInt(blumenArtListe.length);
                blumenListe[f] = new Blume(Blumen[num]);
            }

        }

        //Test Ausgabe
        for (int f = 0; f < ANZAHLBLUMENAMSTART; f++) {
            System.out.println(blumenListe[f].getBlumenArt().getNummer() + " " + blumenListe[f].getBlumenArt().getName());
        }


        //die Blumen auf die Beete verteilen
        Blume[][] blumenBeeteListe = new Blume[5][10];
        for (int i = 0; i < ANZAHLBLUMENAMSTART; i++) {
            Random random = new Random();
            int num = random.nextInt(5);
            blumenBeeteListe[num][i] = blumenListe[i];
        }

        //neue Beete erstellen und in beeteListe werfen
        Beet[] beeteListe = new Beet[5];
        for (int i = 0; i < beeteListe.length; i++) {
            beeteListe[i] = new Beet(i, blumenBeeteListe[i]);
        }
        System.out.println("\n");

        //Test Ausgabe um zu sehen welche blume auf welchen beet steht
        for (int i = 0; i < beeteListe.length; i++) {
            for (int j = 0; j < beeteListe[i].getBlumeListe().length; j++) {
                try {
                    System.out.println(beeteListe[i].getNummer() + " " + beeteListe[i].getBlumeListe()[j].getBlumenArt().toString());
                } catch (NullPointerException e) {
                    // TODO: handle exception
                }
            }

        }
        //
        //DER TAG
        //TODO
        DGOD game = new DGOD(0,0,beeteListe);
        do{
            //Ein neuer Tag beginnt
            game.setTag(game.getTag() + 1);
            System.out.println(game.getTag());
        /*
            tag nummer ausgeben
            beete mit den blumen(wenn vorhanden)
            blumen füllstand angeben
            schleife für beet ob geißen
            abfrage ov gegegngen werden soll
            auswertung ob ja oder nein
            ja: gißen, aller blume pro beet , prüfen ob ertrunken
            nein:foo
                    endsvhleife
            abfrage ob bienschawr, kommmt
            ja:
            abfrage start und ziel beet
            nein:
*/


        }while(game.getTag() < TAGEBISARMAGEDDON);
    }



}
