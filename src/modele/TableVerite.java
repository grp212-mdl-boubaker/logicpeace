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
 * @author shahin.behrooz@gmail.com
 */
public class TableVerite implements Observer{
    private int nbEntree;
    private int nbSortie;
    List<Entree> lstEntree;
    List<Sortie> lstSortie;
    Circuit circuit;
    private Hashtable<Integer,List<Integer>> table;
    public TableVerite(Circuit c){
         
        circuit = c;
        lstEntree = c.getEntrees();
        lstSortie = c.getSorties();
        
    }

    @Override
    public void update() {
        lstEntree = circuit.getEntrees();
        lstSortie = circuit.getSorties();
        int rowNumber = (int)Math.pow(2, lstEntree.size());
        for (int i = 0; i < rowNumber; i++)
        {
            /*
            mettre valeur sur les entree. par exemple si on veut evaluer troisiem rangee de table
            on doit mettre (11) sur les entree. dependement de nombre d<entree c<est peut etre
            011 (pour 3 entrees), 0011 (pour 4) et ainsi de suit
            */
            setSurLesEntrees(i);
            examinerLesSorties(i);//evaluer les sorties et les mettre dans hashtable
        }
        
    }
    private void setSurLesEntrees(int k){
        
        for (int i=0; i < lstEntree.size();i++ )
        {
            int mask = 1;//mask pour faire and et obtenir le chiffre le plus droit
            // 
            int a = k >> i;//shift right
            int result = a & mask;
            lstEntree.get(i).setValue(result);
        }
    }
    private void examinerLesSorties(int rowNumber){
        ArrayList<Integer> outputValues = new ArrayList<Integer>();
        for (Sortie sortie:lstSortie)
            outputValues.add(new Integer(sortie.getValue()));
        table.put(new Integer(rowNumber), outputValues);
    }
    
}
