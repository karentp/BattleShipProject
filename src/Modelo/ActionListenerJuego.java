/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Karen TP
 */
import GUI.Boton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.Juego;
import java.awt.Color;

/**
 *
 * @author Karen TP
 */
public class ActionListenerJuego implements ActionListener{
    Juego ventJuego;
    int x;
    int y;
    Boton boton;
    
    public ActionListenerJuego(Juego vent,int filas,int columnas,Boton boton){
        this.ventJuego= vent;
        this.x=filas;
        this.y=columnas;
        this.boton= boton;
    }
    @Override
    public void actionPerformed(ActionEvent e) { 
        selectionButtonPressed();
     } 

      private void selectionButtonPressed() {
        System.out.println("HOLIAS");
        this.ventJuego.setPosXActual(x);
        this.ventJuego.setPosYActual(y);
        this.boton.setBackground(new Color(5,107,166));
        
     }
    
}