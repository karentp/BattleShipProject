/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Vertice;

/**
 *
 * @author Paola Chinchilla
 */
public class Grafo {
    private Vertice[][] Tablero_logico;

    public Vertice[][] getTablero_logico() {
        return Tablero_logico;
    }

    public void setTablero_logico(Vertice[][] Tablero_logico) {
        this.Tablero_logico = Tablero_logico;
    }
    
    public void setPosTableroLogico(int i, int j, ComponenteObj componente){
        
    }
}
