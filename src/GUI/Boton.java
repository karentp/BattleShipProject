/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Karen TP
 */
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Boton extends JButton{
    
    //-------- Constructor con parametros para posicionar a los labels ------//
    public Boton( int pos_x, int pos_y, int ancho, int alto ){ 
        //Se coloca el label en un lugar y se le da un tamanio
        setBounds(pos_x, pos_y, ancho, alto);

    }
    public ImageIcon getIconoNuevos (String string){

        ImageIcon imagen = new javax.swing.ImageIcon(string);        
        ImageIcon img = new ImageIcon(imagen.getImage().getScaledInstance(34, 34, 34));
        return img;
    }
    public JButton setNombre(String nombre ){
        setText(nombre);
        return this;
    }


}
