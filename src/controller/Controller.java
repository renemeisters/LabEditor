package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import model.Kachel;
import model.Model;
import view.Gui;

import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vmadmin
 */
public class Controller extends JFrame {

    private static Model m;
    private static int hoehe;
    private static int breite;
    private static final Gui g = new Gui();
    private static ArrayList<Kachel> kacheln;



    public void startCreation(int h, int b){
        hoehe = h;
        breite = b;

        m = new Model();
        m.createLabyrinth(hoehe,breite);
        kacheln = m.getKacheln();
        g.createAndAddDrawingPanel(breite, hoehe);
        g.drawSquare(hoehe, breite, kacheln);
       // v.drawLabyrinth(hoehe,breite, m);
        g.addFieldChangeListener(new FieldListener());
        g.addSaveListener(new SaveListener());
    }

    static  class SaveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String fName;
            try{
                fName = g.returnFileName();
                /*if(!m.validate(hoehe, breite)){
                    g.displayErrorMessage("Die Ecken müssen leere Blöcke sein");
                }else {*/
                    m.saveByType(fName);
                //}
            }
            catch (NullPointerException n){
                g.displayErrorMessage("Geben Sie einen Filename ein");
            }
        }
    }

    static class FieldListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int x, y,colorID;
            try{

                x = g.returnXField();
                y = g.returnYField();
                colorID = g.returnColorID();
                Color c;
                switch (colorID){
                    case 0:
                        c = Color.gray;
                        break;
                    case 1:
                        c = Color.green;
                        break;
                    case 2:
                        c = Color.blue;
                        break;
                    default:
                        c = Color.gray;
                        break;
                }

                m.changeKachel(x,y,c);
                kacheln = m.getKacheln();
                g.createAndAddDrawingPanel(breite, hoehe);
                g.drawSquare(hoehe,breite,kacheln);
            }
            catch (NumberFormatException ex){
                g.displayErrorMessage("In beiden Feldern müssen Nummern eigegeben werden!");
            }
        }
    }
    
}
