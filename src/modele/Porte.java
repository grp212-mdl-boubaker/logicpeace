/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Admin
 */
public abstract class Porte implements Noeud {

    static int nombrePorte = 0;
    Hashtable tableDeValeurs;
    private String nom;
    private List elements = new ArrayList<Noeud>();
    EntreePorte[] entrees;
    public abstract String getSigne();

    public Porte(String nom) {
        this.nom = nom;
       
    }

    public static int getNombrePorte() {
        return nombrePorte;
    }

    public static void setNombrePorte(int nombrePorte) {
        Porte.nombrePorte = nombrePorte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void ajouterEntree(EntreePorte entree,int i) {
        entrees[i] = entree;
    }


  //creation un objet de type EntreePorte

    public EntreePorte creerEntreePorte() {
        int n = EntreePorte.getNombreEntreePorte();
        if (n >= 5) {
            // JOptionPane.showMessageDialog(null, "Le nombre d'entre est au maximum 5.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String nom = "ep" + n;
        EntreePorte.setNombreEntreePorte(n + 1);
        EntreePorte ep = new EntreePorte(nom);
        return ep;
    }
//creation un objet de type SortiePorte
    public SortiePorte creerSortiePorte() {
        int n = SortiePorte.getNombreSortiePorte();
        String nom = "sp" + n;
        SortiePorte.setNombreSortiePorte(n + 1);
        SortiePorte sp = new SortiePorte(nom);
        return sp;
    }
    public void ajouterSortie(SortiePorte sortiePorte){
        sortiePorte.porte = this;
    }
}
