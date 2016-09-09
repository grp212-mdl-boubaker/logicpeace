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
public class EntreePorte  extends Destination {
    private static int nombreEntreePorte=0;
    private String nom;
    private Porte porte;
    
    public EntreePorte(String nom) {
        this.nom = nom;
    }

    public static int getNombreEntreePorte() {
        return nombreEntreePorte;
    }

    public static void setNombreEntreePorte(int nombreEntreePorte) {
        EntreePorte.nombreEntreePorte = nombreEntreePorte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

//    public Entree getEntree() {
//        return lien;
//    }

//    public void addLien(Noeud entree) {
//        try{
//        this.lien = (Entree)entree;
//        }catch(IllegalArgumentException ex){
//            throw new IllegalArgumentException("faire le lien n'est pas possible.");
//        }
//    }
    public void setPorte(Porte porte){
        this.porte = porte;
    }
    public Porte getPorte(){
        return porte;
    }
    @Override
    public String toString() {
        return "EntreePorte{" + "nom=" + nom + " " + porte.getClass().getSimpleName() + '}';//return  nom;
    }
    
    public String afficher() {
        return "EntreePorte{" + "nom=" + nom + '}';
    }


}
