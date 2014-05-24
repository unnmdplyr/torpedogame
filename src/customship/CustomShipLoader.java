package customship;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ship.ShipContainer;
import table.Cell;
import table.Point;

public class CustomShipLoader {

//	..XX
//	.XX.
//	X...
//	X...
//	4
	public CustomShipLoader(String fileName, ShipContainer shipContainer, final int tableSize) {
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			String shipTypeData = null;
			while ((shipTypeData = readShipType(reader)) != null) {
				String[] lines = shipTypeData.split("\n");
				int count = Integer.parseInt(lines[4]);
				
				CustomShip base = new CustomShip(shipContainer);
				
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < lines[i].length(); j++) {
						if (lines[i].charAt(j) == 'x') {
							base.addCoveredCell(new Cell(1, j, i));
						}
					}
				}
				
				for (int i = 0; i < count; i++) {
					CustomShip modShip = base.clone();
					Point offset = modShip.determinePlaceForTheShip(tableSize);
					modShip.moveToPosition(offset);
					shipContainer.addShip(modShip);
				}
			}
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	private String readShipType(BufferedReader reader) throws IOException {
		StringBuilder shipTypeData = new StringBuilder();
		
		for (int i = 0; i < 5; i++) {
			String line = reader.readLine();
			
			if (line == null) {
				return null;
			}
			
			shipTypeData.append(line);
			shipTypeData.append('\n');
		}
		
		return shipTypeData.substring(0, shipTypeData.length() - 1);
	}
}
