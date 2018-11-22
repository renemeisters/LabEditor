package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCSV implements Save {
    @Override
    public void save(String fName) {
        fName = fName+".csv";
        try ( BufferedWriter bw =
                      new BufferedWriter (new FileWriter(fName)) )
        {
           /* for (Kachel k : kacheln) {
                String x = String.valueOf(k.getX()) + ";";
                String y = String.valueOf(k.getY()) + ";";
                String color = String.valueOf(k.getColor()) + ";";

                bw.write (x+y+color + "\n");
            }*/



        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
