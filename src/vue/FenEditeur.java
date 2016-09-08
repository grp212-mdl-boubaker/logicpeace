/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import modele.Circuit;
import modele.Destination;
import modele.Editeur;
import modele.Entree;
import modele.Noeud;
import modele.Observer;
import modele.NamedObject;
import modele.Porte;
import modele.Sortie;
import modele.Source;
import modele.TableVerite;

/**
 *
 * @author Admin
 */
public class FenEditeur extends javax.swing.JFrame implements Observer{

    private Circuit racine;
    static boolean lock = false;
    TableVerite tv;
    DefaultComboBoxModel<Pair> comboModel;
    DefaultListModel<Pair> listModelSources;
    DefaultListModel<Pair> listModelConnectedSources; 
    ComboLsnr lsnr;
    /**
     * Creates new form FenEditeur
     */
    public FenEditeur() {
        initComponents();
    }

    public FenEditeur(Circuit c0) {
        lsnr = new ComboLsnr();
        this.racine = c0;
        initComponents();
        jList1.setModel(new DefaultListModel());
        jList2.setModel(new DefaultListModel());
        jComboBox1.addActionListener(lsnr);
        comboModel = (DefaultComboBoxModel)jComboBox1.getModel();
        listModelSources = (DefaultListModel)jList1.getModel();
        listModelConnectedSources = (DefaultListModel)jList2.getModel();

        updateInterface();//loads combobox with gates contained in circuit
        tv = new TableVerite(racine);
        racine.attache(tv);
        racine.attache(this);
        afficherCircuit();
        TableViewer monitor = new TableViewer(this, false);
        racine.attache(monitor);
        monitor.setVisible(true);
        monitor.update();
    }
    private void updateInterface(){
        //preserver selected item
        Pair selectedPair = (Pair)comboModel.getSelectedItem();
        //pendant update desactiver combo listener
        jComboBox1.removeActionListener(lsnr);
        
        List lst = racine.getElements();
        listModelSources.removeAllElements();
        comboModel.removeAllElements();
        listModelConnectedSources.removeAllElements();
        for (Object node:lst)
        {
            if (node instanceof Porte)
            {
                List<NamedObject> list = ((Porte)node).getEntrees();
                //ajout des entrees
                for (NamedObject dest:list)
                {
                comboModel.addElement(new Pair(dest));
                }
                //ajout de sortie
                listModelSources.addElement(new Pair(((Porte)node).getSortie()));
            }
            else if (node instanceof Sortie)
                comboModel.addElement(new Pair((NamedObject)node));
            else if (node instanceof Source)
            {
                Source sc = (Source)node;
                listModelSources.addElement(new Pair(sc));
                    
            }
                
        }
        
        //update jlist2
        if (selectedPair != null)
        {
            comboModel.setSelectedItem(selectedPair);
        
       
        Pair pair = (Pair)selectedPair;
        //on sait que c'est une destination
        Destination dest = (Destination)pair.getObject();
        if (dest.getSource() != null)
        {
            Pair p = new Pair(dest.getSource());
            listModelConnectedSources.addElement(p);
        }
        }
    //recupere listener    
    jComboBox1.addActionListener(lsnr);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPorteAND = new javax.swing.JButton();
        btnAjouterEntree = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnAjouterSortie = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnConnect = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        btnDisconnect = new javax.swing.JButton();
        btnAjouterPorteOR = new javax.swing.JButton();
        btnAjouterPorteNOT = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editeur de Circuit");
        setAlwaysOnTop(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnPorteAND.setText("ajouter Porte AND");
        btnPorteAND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorteANDActionPerformed(evt);
            }
        });

        btnAjouterEntree.setText("ajouter Entree");
        btnAjouterEntree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterEntreeActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnAjouterSortie.setText("Ajouter Sortie");
        btnAjouterSortie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterSortieActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Sources connectables:");

        jLabel2.setText("Destination");

        btnConnect.setText(">");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        jLabel3.setText("Connectée à:");

        jScrollPane4.setViewportView(jList1);

        jScrollPane5.setViewportView(jList2);

        btnDisconnect.setText("<");
        btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDisconnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnConnect)
                        .addGap(18, 18, 18)
                        .addComponent(btnDisconnect)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAjouterPorteOR.setText("Ajouter Porte OR");
        btnAjouterPorteOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterPorteORActionPerformed(evt);
            }
        });

        btnAjouterPorteNOT.setText("Ajouter Porte NOT");
        btnAjouterPorteNOT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterPorteNOTActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPorteAND)
                    .addComponent(btnAjouterPorteOR))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAjouterSortie)
                        .addGap(35, 35, 35)
                        .addComponent(btnAjouterEntree))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAjouterPorteNOT)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPorteAND)
                            .addComponent(btnAjouterSortie)
                            .addComponent(btnAjouterEntree))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAjouterPorteOR)
                            .addComponent(btnAjouterPorteNOT)
                            .addComponent(jButton1)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPorteANDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorteANDActionPerformed
        Editeur.ajouterPorte("AND");
        afficherCircuit();
    }//GEN-LAST:event_btnPorteANDActionPerformed

    private void btnAjouterEntreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterEntreeActionPerformed
        Editeur.ajouterEntree();
        afficherCircuit();
    }//GEN-LAST:event_btnAjouterEntreeActionPerformed

    private void btnAjouterSortieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterSortieActionPerformed
        Editeur.ajouterSortie();
        afficherCircuit();
    }//GEN-LAST:event_btnAjouterSortieActionPerformed

    private void btnAjouterPorteORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterPorteORActionPerformed
        Editeur.ajouterPorte("OR");
        afficherCircuit();
    }//GEN-LAST:event_btnAjouterPorteORActionPerformed

    private void btnAjouterPorteNOTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterPorteNOTActionPerformed
        Editeur.ajouterPorte("NOT");
        afficherCircuit();
    }//GEN-LAST:event_btnAjouterPorteNOTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //tv.update();
        System.out.println(tv.toString());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed
        // TODO add your handling code here:
            Pair pair = (Pair)comboModel.getSelectedItem();
            int index = jList2.getSelectedIndex();
            Pair pSrc = listModelConnectedSources.elementAt(index);
            Source src = (Source)pSrc.getObject();
            String sourceNom = src.getNom();
            String destNom = pair.getObject().getNom();
            racine.delier(sourceNom, destNom);
    }//GEN-LAST:event_btnDisconnectActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        // TODO add your handling code here:
        Pair pair = (Pair)comboModel.getSelectedItem();
            int index = jList1.getSelectedIndex();
            String sourceNom = listModelSources.getElementAt(index).toString();
            String destNom = pair.toString();
            racine.lier(sourceNom, destNom);
    }//GEN-LAST:event_btnConnectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenEditeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenEditeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenEditeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenEditeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenEditeur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouterEntree;
    private javax.swing.JButton btnAjouterPorteNOT;
    private javax.swing.JButton btnAjouterPorteOR;
    private javax.swing.JButton btnAjouterSortie;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDisconnect;
    private javax.swing.JButton btnPorteAND;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void afficherCircuit() {
        // System.out.println(c0);
        jTextArea1.append("\n--------------------------------\n");
        jTextArea1.append(racine.toString() + "\n");
    }

    @Override
    public void update() {
    updateInterface();
    }
 class ComboLsnr implements java.awt.event.ActionListener {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateInterface();
            }
        };

}
