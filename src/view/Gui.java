package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import model.Kachel;
import model.Labyrinth;
import model.Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Gui extends JFrame{
    Model m;
    ArrayList<Kachel> kacheln;
	
	  JLabel labelx = new JLabel("Gebe die X Position ein");
	  JLabel labely = new JLabel("Gebe die Y Position ein");
	  JLabel labelColor = new JLabel("0: Grau|leer,1: grün|zerbrechbarer Block, 2: blau|fester Block");
	  JLabel lblFile = new JLabel("Geben sie den Filename ein");
	  JTextField textfieldColor = new JTextField();
	  JTextField textfieldX = new JTextField();
	  JTextField textfieldY = new JTextField();
	  JTextField fileName = new JTextField();
	  JButton savebtn = new JButton("Speichern");
      JButton btn = new JButton("Zum Block machen");
	  
    public Gui() {
    Dimension windowSize = new Dimension(1000, 600);
    setSize(windowSize);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int windowPositionX = (screenSize.width - windowSize.width) / 2;
    int windowPositionY = (screenSize.height - windowSize.height) / 2;
    Point windowPosition = new Point(windowPositionX, windowPositionY);
    setLocation(windowPosition);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //createAndAddDrawingPanel();
    setVisible(true);
  }

  public void createAndAddDrawingPanel(int breite, int hoehe) {
    // Das JPanel-Objekt ist ein Objekt einer anonymen Unterklasse von JPanel
    // Siehe Java-Grundkurs Abschnitt 3.9
    add(new JPanel() {
      // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
      // Methode beim Dsiplay aufruft.
      @Override
      protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
          //drawSquare(g, hoehe,breite);

    	  labelx.setBounds(520,10,200,20);
    	  labely.setBounds(520,50,200,20);
    	  labelColor.setBounds(520,90,400,20);
           textfieldX.setBounds(520, 30, 80, 20);
            textfieldColor.setBounds(520,110,80,20);
           textfieldY.setBounds(520, 70, 80, 20);
            lblFile.setBounds(520,160,200, 20);
            fileName.setBounds(520,180,80,20);
            savebtn.setBounds(520,200,80,20);
           btn.setBounds(520, 140, 80, 20);
           add(lblFile);
           add(savebtn);
           add(fileName);
           add(labelx);
           add(labely);
           add(labelColor);
           add(textfieldColor);
          add(textfieldX);
          add(textfieldY);
          add(btn);
      
      }
    });
  }
  
  
public int returnXField(){
        return Integer.parseInt(textfieldX.getText().toString());
}
    public int returnYField(){
        return Integer.parseInt(textfieldY.getText().toString());
    }

    public int returnColorID(){

        return Integer.parseInt(textfieldColor.getText());
    }

 public String returnFileName(){
        return fileName.getText();
 }
  public void drawSquare( int h, int b,ArrayList<Kachel> kachel){
	  				
	  			  Graphics g = this.getGraphics();
	  			 for (int i = 0; i < kachel.size(); i++) {
	  				for (int j = 0;j < kachel.size(); j++) {
	  					for (Kachel k : kachel) {
		  					if(k.getX() == i && k.getY()== j){
		  						g.setColor(k.getColor());
		  						g.fillRect(i*30+10, j*30+32, 29, 29);
		  						
		  		            }
	  					}
	  					
						
	  					
					}
					
				}

  }
  
  
  public void addFieldChangeListener(ActionListener listenForFieldChangeButton){
        btn.addActionListener(listenForFieldChangeButton);
  }

  public void addSaveListener(ActionListener listen){
        savebtn.addActionListener(listen);
  }



    public void displayErrorMessage(String error){
        JOptionPane.showMessageDialog(this,error);
    }

    
    
}
