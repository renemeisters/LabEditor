package model.importer;

import model.Kachel;

import java.util.ArrayList;

public interface Import {

    void importFile(String fName, ArrayList<Kachel> kacheln);
}
