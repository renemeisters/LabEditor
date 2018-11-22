package model;

import java.io.*;
import java.util.ArrayList;
import java.awt.Color;
import java.util.Scanner;

public class Model {
	private Labyrinth l;
	private ArrayList<Kachel> kacheln;

	public void createLabyrinth(int hoehe, int breite) {
		
		l = new Labyrinth(hoehe, breite);
	}

	public void changeKachel(int x, int y, Color c) {
		l.changeKachel(x,y,c);
		
	}

	public ArrayList<Kachel> getKacheln() {
		// TODO Auto-generated method stub
		kacheln = l.getKacheln();
		return kacheln;
	}

	public void saveState(String fName ){

			fName = fName+".csv";
		try ( BufferedWriter bw =
					  new BufferedWriter (new FileWriter(fName)) )
		{
			for (Kachel k : kacheln) {
				String x = String.valueOf(k.getX()) + ";";
				String y = String.valueOf(k.getY()) + ";";
				String color = String.valueOf(k.getColor()) + ";";

				bw.write (x+y+color + "\n");
			}



		} catch (IOException e) {
			e.printStackTrace ();
		}
	}

	public void importLabyrinth(String fName){
		try {
			Scanner scn = new Scanner(new File(fName));
			scn.useDelimiter(";");
			while(scn.hasNext()){
				for (Kachel kachel : kacheln) {
					if(kachel.getX() == Integer.parseInt(scn.next()) && kachel.getY()== Integer.parseInt(scn.next())){

					//	kachel.setColor();

					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}





}
