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
public class SortiePorte  implements Noeud {
    static int nombreSortiePorte=0;
    private String nom;
    private List lien=new ArrayList<Sortie>();
    
    public SortiePorte(String nom) {
        this.nom = nom;
    }

    public static int getNombreSortiePorte() {
        return nombreSortiePorte;
    }

    public static void setNombreSortiePorte(int nombreSortiePorte) {
        SortiePorte.nombreSortiePorte = nombreSortiePorte;
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
            lien.add((Sortie) liee);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("faire le lien n'est pas possible.");
        }
    }

    @Override
    public String toString() {
        return "SortiePorte{" + "nom=" + nom + '}';
    }
    
}
