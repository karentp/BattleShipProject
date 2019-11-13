/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Mensaje;
import Vista.VentanaChat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Karen TP
 */
public class ControladorCliente  implements ActionListener{

    
    private VentanaChat ventana;
    private Cliente cliente;
    
    public ControladorCliente(Cliente cliente, VentanaChat ventana){
        this.cliente = cliente;
        this.ventana = ventana;
        this.innit();
    }
    
    public void innit(){
        ventana.jButton_Send.addActionListener(this);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ventana.jButton_Send))
            cliente.clientThread.sendPackage(new Mensaje(ventana.jTextField_Chat.getText()));
    }
    
}

