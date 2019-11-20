/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import battleship.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paola Chinchilla
 */
class Vertice {
    Componentes componente;
    ComponenteObj componenteObj;
    List<Arista> aristas = new ArrayList();

    public Componentes getComponente() {
        return componente;
    }

    public void setComponente(Componentes componente) {
        this.componente = componente;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(List<Arista> aristas) {
        this.aristas = aristas;
    }

    public ComponenteObj getComponenteObj() {
        return componenteObj;
    }

    public void setComponenteObj(ComponenteObj componenteObj) {
        this.componenteObj = componenteObj;
    }
    
    
    public void addAristas(Arista edges) {
        if (aristas == null) {
            aristas = new ArrayList<Arista>();
        }
        aristas.add(edges);
    }
    
}
