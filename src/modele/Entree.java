/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Entree extends Source{

    private static int nombreEntree = 0;
    private String nom;
    private int valeur = 0;
    private List lien = new ArrayList<EntreePorte>();
    
    public Entree(String nom) {
        this.nom = nom;
    }

    public static int getNombreEntree() {
        return nombreEntree;
    }

    public static void setNombreEntree(int nombreEntree) {
        Entree.nombreEntree = nombreEntree;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return nom;
    }
    public String afficher(){
        String s = "";
        for (Destination dest:destinations)
            s = dest.getNom() + " ";
        return "Entree{" + "nom=" + nom + ", lien=" + s + '}';
        
    }
    
    public int getValue(){
        return valeur;
    }
    public void setValue(int v){
        valeur = v;
    }
    
}
