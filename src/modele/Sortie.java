/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Admin
 */
public class Sortie  implements Noeud {
    private static int nombreSortie=0;
    private String nom;
    private SortiePorte lien;
    
    public Sortie(String nom) {
        this.nom = nom;
    }

    public static int getNombreSortie() {
        return nombreSortie;
    }

    public static void setNombreSortie(int nombreSortie) {
        Sortie.nombreSortie = nombreSortie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public SortiePorte getSortiePorte() {
        return lien;
    }

    public void addLien(Noeud sortiePorte) {
        try{
        this.lien = (SortiePorte)sortiePorte;
        }catch(IllegalArgumentException ex){
            throw new IllegalArgumentException("faire le lien n'est pas possible.");
        }
    }

    @Override
    public String toString() {
        return "Sortie{" + "nom=" + nom + ", lien=" + lien + '}';
    }

    
  
}
