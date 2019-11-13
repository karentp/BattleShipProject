/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karen TP
 */
public class ThreadCliente extends Thread{
    private Socket cliente;
    private Server servidor;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private int playerNumber;
    private boolean activo;

    public ThreadCliente(Socket client) {
        this.cliente = client;
        this.activo = true;
    }
    

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(ObjectInputStream entrada) {
        this.entrada = entrada;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public Server getServidor() {
        return servidor;
    }

    public void setServidor(Server servidor) {
        this.servidor = servidor;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    public void setSalida(ObjectOutputStream salida) {
        this.salida = salida;
    }
    
    
    
    public void run()
     {
        while (activo) {
            try {
                entrada = new ObjectInputStream(cliente.getInputStream());
                IObjeto packRecibido = (IObjeto) entrada.readObject();
                switch (packRecibido.getType()) {
                    case MENSAJE: {
                        Mensaje mensaje = (Mensaje) packRecibido;
                        System.out.println(mensaje.getMessage());
                    }
                }
            }
            catch(IOException | ClassNotFoundException e) { 
                 System.out.println(e); 
            }
        } 
     }      
         
       
    public void sendPackage(IObjeto packRecibido){
        try {
            salida = new ObjectOutputStream(cliente.getOutputStream());
            salida.writeObject(packRecibido);
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
