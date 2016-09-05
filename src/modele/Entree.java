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
public class Entree implements Noeud {

    private static int nombreEntree = 0;
    private String nom;
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

    //Lier
    public void addLien(Noeud liee) {
        try {
            lien.add((EntreePorte) liee);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("faire le lien n'est pas possible.");
        }
    }

    @Override
    public String toString() {
        return "Entree{" + "nom=" + nom + ", lien=" + lien + '}';
    }

    
}
