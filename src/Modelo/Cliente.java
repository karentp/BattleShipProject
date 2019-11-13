/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControladorCliente;
import Vista.VentanaChat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karen TP
 */
public class Cliente {
    public ThreadCliente clientThread;
    
    public void connect(String direccionIP, int puerto){
        try {
            Socket cliente = new Socket(direccionIP, puerto);
            clientThread = new ThreadCliente(cliente);
            clientThread.start();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Cliente clienteNuevo = new Cliente();
        clienteNuevo.connect("localhost", 8082);
        ControladorCliente controller = new ControladorCliente(clienteNuevo, new VentanaChat());
    }
    
}
