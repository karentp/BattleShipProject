/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paola Chinchilla
 */
class Vertice {
    Componente componente;
    List<Arista> aristas = new ArrayList();

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(List<Arista> aristas) {
        this.aristas = aristas;
    }
    public void addAristas(Arista edges) {
        if (aristas == null) {
            aristas = new ArrayList<Arista>();
        }
        aristas.add(edges);
    }
    
}
