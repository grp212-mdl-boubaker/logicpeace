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
public class Sortie  extends Destination {
    private static int nombreSortie=0;
    private String nom;
    private Source source;
    
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

//    public SortiePorte getSortiePorte() {
//        return lien;
//    }
//peut cncter a entreecircuit ou sortieporte
    public void connecter(Source src) {
        try{
        source = src;
        }catch(IllegalArgumentException ex){
            throw new IllegalArgumentException("faire le lien n'est pas possible.");
        }
    }

    @Override
    public String toString() {
        return "Sortie{" + "nom=" + nom + ", lien=" + source + '}';
    }

    
  
}
