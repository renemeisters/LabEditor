package model.validator;

import model.Kachel;

import java.awt.*;
import java.util.ArrayList;

public class ValidateCourner implements  Validater{
    @Override
    public boolean validate(ArrayList<Kachel> kacheln, int h, int b) {
        boolean upperLeft = false;
        boolean upperRight = false;
        boolean underLeft = false;
        boolean underRight = false;
        for(Kachel kachel : kacheln){
            if(kachel.getX() == 0 && kachel.getY()== 0){
                upperLeft = checkIfFree(kachel);
            }
            if(kachel.getX() == b && kachel.getY()== 0){
                upperRight = checkIfFree(kachel);
            }
            if(kachel.getX() == 0 && kachel.getY()== h){
                underLeft = checkIfFree(kachel);
            }
            if(kachel.getX() == b && kachel.getY()== h){
                underRight = checkIfFree(kachel);
            }


        }
        if(underLeft && underRight && upperLeft && upperRight){
            return true;
        }
        else{
            return false;
        }

    }

    private static boolean checkIfFree(Kachel k){
        if(k.getColor() == Color.gray){
            return true;
        }else{
            return false;
        }
    }
}
