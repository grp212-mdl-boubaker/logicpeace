/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author shahin.behrooz@gmail.com
 */
public abstract class Destination implements Noeud{
    private Source source;    
    public void setSource(Source src){
        source = src;
        src.setDestination(this);
    }
    public Source getSource(){
        return source;
    }
    public int getValue() throws InvalidCircuitException{
        //dans un circuit valid (pret a calculer) destination est connecté
        // à une source qui fournit une valeur
        if (source == null)
            // le circuit n<est pas encore valide
            throw new InvalidCircuitException("Le noeud " + getNom() + " n'est pas connecté");
        return source.getValue();
    }
}
