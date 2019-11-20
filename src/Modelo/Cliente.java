/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControladorCliente;
import GUI.VentanaChat;
import GUI.Juego;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Componentes;
import java.util.ArrayList;
/**
 *
 * @author Karen TP
 */
public class Cliente {
    public ThreadCliente clientThread;     
    private Hashtable<Componentes, Integer> componentesHashTable;
    private ArrayList<ComponenteObj> componentesCaracteristicas;
    private Grafo grafo;
    private ComponenteFactory fabricaComponentes;
    private Juego juego;
    
    public Cliente(){
        this.componentesHashTable =new Hashtable<>(); 
        this.grafo= new Grafo();
        this.fabricaComponentes= new ComponenteFactory();
        this.componentesCaracteristicas= new ArrayList<ComponenteObj>();
    }

    public void setComponentesInicialesCliente(){
        componentesHashTable.put(Componentes.MERCADO,1);
        componentesHashTable.put(Componentes.FUENTEENERGÍA,1);
        componentesHashTable.put(Componentes.DINERO,4000);
        componentesHashTable.put(Componentes.ACERO,0);
        componentesHashTable.put(Componentes.BARCO,0);
        componentesHashTable.put(Componentes.BOMBA,0);
        componentesHashTable.put(Componentes.CONECTOR,0);
        componentesHashTable.put(Componentes.ARMERIA,0);
        componentesHashTable.put(Componentes.MINA,0);
        componentesHashTable.put(Componentes.TEMPLO,0);
        componentesHashTable.put(Componentes.TORPEDO,0);
        componentesHashTable.put(Componentes.TRUMPEDO,0);
        componentesHashTable.put(Componentes.REMOLINO,0);
        componentesHashTable.put(Componentes.MULTISHOT,0);
        
        setComponentesInformacion();
    }
    
    public void setComponentesInformacion(){
        componentesCaracteristicas.add(fabricaComponentes.crearComponente(Componentes.MERCADO));
        componentesCaracteristicas.add(fabricaComponentes.crearComponente(Componentes.FUENTEENERGÍA));
        componentesCaracteristicas.add(fabricaComponentes.crearComponente(Componentes.ARMERIA));
        componentesCaracteristicas.add(fabricaComponentes.crearComponente(Componentes.BARCO));
        componentesCaracteristicas.add(fabricaComponentes.crearComponente(Componentes.BOMBA));
        componentesCaracteristicas.add(fabricaComponentes.crearComponente(Componentes.CONECTOR));
        componentesCaracteristicas.add(fabricaComponentes.crearComponente(Componentes.MINA));
        componentesCaracteristicas.add(fabricaComponentes.crearComponente(Componentes.MULTISHOT));
        componentesCaracteristicas.add(fabricaComponentes.crearComponente(Componentes.REMOLINO));
        componentesCaracteristicas.add(fabricaComponentes.crearComponente(Componentes.TEMPLO));
        componentesCaracteristicas.add(fabricaComponentes.crearComponente(Componentes.TEMPLO));
        componentesCaracteristicas.add(fabricaComponentes.crearComponente(Componentes.TORPEDO));
        componentesCaracteristicas.add(fabricaComponentes.crearComponente(Componentes.TRUMPEDO));
           
    }

    public ComponenteFactory getFabricaComponentes() {
        return fabricaComponentes;
    }

    public void setFabricaComponentes(ComponenteFactory fabricaComponentes) {
        this.fabricaComponentes = fabricaComponentes;
    }
    
    
    
    public Hashtable<Componentes, Integer> getComponentesHashTable() {
        return componentesHashTable;
    }

    public void setComponentesHashTable(Hashtable<Componentes, Integer> componentesHashTable) {
        this.componentesHashTable = componentesHashTable;
    }

    public ThreadCliente getClientThread() {
        return clientThread;
    }

    public void setClientThread(ThreadCliente clientThread) {
        this.clientThread = clientThread;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public ArrayList<ComponenteObj> getComponentesCaracteristicas() {
        return componentesCaracteristicas;
    }

    public void setComponentesCaracteristicas(ArrayList<ComponenteObj> componentesCaracteristicas) {
        this.componentesCaracteristicas = componentesCaracteristicas;
    }

    
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public ComponenteObj getComponentInfo(Componentes tipo){
        for(ComponenteObj componente: componentesCaracteristicas){
            if (componente.getTipo()==tipo){
                return componente;
            }
        }
        return null;
    }
    
    public void connect(String direccionIP, int puerto){
        try {
            
            Socket cliente = new Socket(direccionIP, puerto);
            clientThread = new ThreadCliente(cliente);
            setComponentesInicialesCliente();
            clientThread.start();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        Cliente clienteNuevo = new Cliente();
        clienteNuevo.connect("localhost", 8082);
        //ControladorCliente controller = new ControladorCliente(clienteNuevo, new VentanaChat());
        Juego vetJuego= new Juego(clienteNuevo);
        clienteNuevo.setJuego(vetJuego);
        vetJuego.setVisible(true);
        vetJuego.colocarCantidadesComponentes();
        vetJuego.setMatrizGrafica();
        //ControladorCliente controller = new ControladorCliente(clienteNuevo, ventJuego);
    }
    
}
