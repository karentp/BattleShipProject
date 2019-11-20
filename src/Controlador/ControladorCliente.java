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
////    }
//    public void actionPerformed(ActionEvent event) {
//        for (int i = 0; i < this.ventana.getFilas(); i++) {
//            for (int j = 0; j < this.ventana.getColumnas(); j++) {
//                if(event.getSource().equals(this.ventana.getJuegoPanel().getComponentAt(i, j))){
//                    System.out.println(i+ ", " +j);
//                    this.cliente.getGrafo().setPosTableroLogico(i, j,this.ventana.getComponenteActual());
//                    
//                    
//                    
//                    his.player.definePosFija(i, j);
//                    this.player.definePosiciones(i, j);
//                    this.tableroVista.pintarButtonSelec(this.player.getPosOrigen(), this.player.getPosDestino());
//                    
//                    switch (this.player.getTableroLogico().getTableroLogico()[i][j].getComponent().getType()){
//                        case MERCADO:
//                            this.vistaMercado.show();
//                            break;
//                        case MINA:
//                            this.player.getTableroLogico().getTableroLogico()[i][j].getComponent().setShowVista(true);
//                            break;
//                    }
//                    break;
//                }   
//            }
//        }
//        if (e.getSource().equals(ventana.jButton_Send))
//            cliente.clientThread.sendPackage(new Mensaje(ventana.jTextField_Chat.getText()));
//    }
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

