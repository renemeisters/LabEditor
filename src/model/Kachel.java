package model;
import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vmadmin
 */
public class Kachel extends JFrame {
   
    private int y;
    private int x;
    private Color color;

    public Kachel(int x, int y,Color color) {

        this.x = x;
        this.y = y;
        this.color = color;
    }
 
    
    public Color getColor(){
    	return this.color;
    }
    
    public void setColor(Color color) {
    	this.color = color;
    }
    
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int returnNumber(){
        int comb = this.y +this.x;
        return comb;
    }
    
    
    
}
