package model.saver;

import model.Kachel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveCSV implements Save {
    @Override
    public void save(String fName, ArrayList<Kachel> kacheln) {
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
}
