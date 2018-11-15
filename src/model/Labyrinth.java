package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.Gui;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Labyrinth extends JPanel{

    private int hoehe;
    private int breite;
    private ArrayList<Kachel> kacheln = new ArrayList<Kachel>();

    
    public Labyrinth(int hoehe, int breite) {
        this.breite = breite;
        this.hoehe = hoehe;
        createKacheln();
    }
    
    private void createKacheln(){
      
        for (int x = 0; x < hoehe; x++) {
              for (int y = 0; y < breite; y++) {
                kacheln.add(new Kachel(x,y,Color.gray));     
              }
             
        }
        
    }
    
    public ArrayList<Kachel> getKacheln(){
    	
    	return kacheln;
    }
    
    public void changeKachel(int xPos, int yPos, Color c){
        
        for (Kachel kachel : kacheln) {
            if(kachel.getX() == xPos && kachel.getY()== yPos){
                
            	kachel.setColor(c);
               
             }
        }
        
    }
    

    
 
    

    
  
    
    
    
}
