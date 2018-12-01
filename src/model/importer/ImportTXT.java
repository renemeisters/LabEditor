package model.importer;

import model.Kachel;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportTXT implements Import {

    @Override
    public void importFile(String fName, ArrayList<Kachel> kacheln) {
        try {
            Scanner scan = new Scanner(new File(fName));
            scan.useDelimiter(";");
            while (scan.hasNextLine()){
                int x = Integer.parseInt(String.valueOf(scan.hasNext()));
                int y = Integer.parseInt(String.valueOf(scan.hasNext()));
                Color c =  Color.decode(String.valueOf(scan.hasNext()));
                for (Kachel kachel : kacheln) {
                    if (kachel.getX() == x && kachel.getY() == y) {
                        kachel.setColor(c);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
