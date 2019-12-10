package woebbiOopDGOD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

	public static void main(String[] args) {
		String csvFile = "c:/Users/Administrator/Documents/woebke/PT - Lan - Java/dieGartenSimulationOFDEATH/gartensimulationBlumenarten.CSV";
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ";";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] blumentypDaten = line.split(csvSplitBy);
				System.out.println("Blumentyp [ID=" + blumentypDaten[0] + " , Name=" + blumentypDaten[1] + "] , Verbrauch="
						+ blumentypDaten[2] + "] , Vorrat=" + blumentypDaten[3] + "] , Quotient=" + blumentypDaten[4]
						+ "]");
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
	}
	
}