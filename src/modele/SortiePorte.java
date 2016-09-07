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
public class SortiePorte  extends Source {
    static int nombreSortiePorte=0;
    private String nom;
    Porte porte;
    private Destination destination;
    
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



    @Override
    public String toString() {
        return "SortiePorte{" + "nom=" + nom + ", lien=" + destination + '}';
    }

    @Override
    public int getValue() throws InvalidCircuitException{
        return porte.getValue();
    }
    
}
