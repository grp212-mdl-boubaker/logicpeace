/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author shahin.behrooz@gmail.com
 */
public abstract class PorteUniEntree extends Porte{
 
    public PorteUniEntree(String nom){
        super(nom);
        ArrayList<EntreePorte> entrees = new ArrayList<EntreePorte>();
    }
 public int getValue() throws InvalidCircuitException{
    EntreePorte entreePort = entrees.get(0);
    int e = entreePort.getValue();
    Integer addresse = new Integer(e);
    return ((Integer)tableDeValeurs.get(addresse)).intValue();
    }
    @Override
    public String toString() {
        return "Porte{" + "nom=" + getNom() + ", entree=" + entrees.get(0);
    }
}
