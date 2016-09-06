/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author shahin.behrooz@gmail.com
 * les portes avec 2 entrees comme AND, OR
 */
public abstract class PorteDoubleEntree extends Porte{
   public PorteDoubleEntree(String nom){
       super(nom);
   }
    public int getValue() {
    EntreePorte entreePort1 = entrees[0];
    EntreePorte entreePort2 = entrees[1];
    int e1 = entreePort1.getValue();
    int e2 = entreePort2.getValue();
    Integer addresse = new Integer(e1 + e2 * 2);
    return ((Integer)tableDeValeurs.get(addresse)).intValue();
    }

}