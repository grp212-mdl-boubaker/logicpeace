/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.util.Objects;
import modele.Noeud;
import modele.Porte;

/**
 * a name value pair to be set in combobox
 * @author shahin.behrooz@gmail.com
 */
public class Pair {
    private Noeud node;
    Pair(Noeud node){
        this.node = node;
    }
    public Noeud getNoeud() {
        return node;
    }

    @Override
    public String toString() {
        return node.getNom();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        if (!Objects.equals(this.node, other.node)) {
            return false;
        }
        return true;
    }
    
}
