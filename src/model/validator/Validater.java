package model.validator;

import model.Kachel;

import java.util.ArrayList;

public interface Validater {

    boolean validate(ArrayList<Kachel> kacheln,int h, int b);
}
