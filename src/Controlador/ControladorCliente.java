/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import GUI.Juego;
import Modelo.Cliente;
import Modelo.Mensaje;
import GUI.VentanaChat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Karen TP
 */
public class ControladorCliente  implements ActionListener{
    
    
    private Juego ventana;
    private Cliente cliente;
    
    public ControladorCliente(Cliente cliente, Juego ventana){
        this.cliente = cliente;
        this.ventana = ventana;
        //this.innit();
    }
    public void init(){
        ventana.getBtn_Fabrica().addActionListener(this);
    }
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(ventana.getBtn_Fabrica())){
            cliente.clientThread.sendPackage(ventana.getComponenteActual());
            
            //cliente.clientThread.sendPackage(new Mensaje(ventana.jTextField_Chat.getText()));
        }
    }
    
    
    
    
    
//    }
//
//    public void innit(){
//        ventana.jButton_Send.addActionListener(this);
//        ventana.setLocationRelativeTo(null);
//        ventana.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource().equals(ventana.jButton_Send))
//            cliente.clientThread.sendPackage(new Mensaje(ventana.jTextField_Chat.getText()));
//    }
//    public void actionPerformed(ActionEvent event) {
//        if (e.getSource().equals(ventana.jButton_Send))
//            cliente.clientThread.sendPackage(new Mensaje(ventana.jTextField_Chat.getText()));
////    }
//    public void innit(){
//        ventana.jButton_Send.addActionListener(this);
//        ventana.setLocationRelativeTo(null);
//        ventana.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource().equals(ventana.jButton_Send))
//            cliente.clientThread.sendPackage(new Mensaje(ventana.jTextField_Chat.getText()));
//    }

//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}

