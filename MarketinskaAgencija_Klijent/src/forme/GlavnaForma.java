/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Zaposleni;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author djurd
 */
public class GlavnaForma extends javax.swing.JFrame {

    Zaposleni trenutnoUlogovani;

    /**
     * Creates new form GlavnaForma
     */
    public GlavnaForma() {
        initComponents();
        srediFormu();

    }

    public Zaposleni getTrenutnoUlogovani() {
        return trenutnoUlogovani;
    }

    public void setTrenutnoUlogovani(Zaposleni trenutnoUlogovani) {
        this.trenutnoUlogovani = trenutnoUlogovani;
        lblTrenutnoUlogovani.setText(trenutnoUlogovani + ", dobro došli na sistem!");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTrenutnoUlogovani = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmKlijent = new javax.swing.JMenu();
        jmiUnosKlijenta = new javax.swing.JMenuItem();
        jmiPretragaKlijenata = new javax.swing.JMenuItem();
        jmZahtev = new javax.swing.JMenu();
        jmiUnosZahteva = new javax.swing.JMenuItem();
        jmiPretragaZahteva = new javax.swing.JMenuItem();
        jmOpcije = new javax.swing.JMenu();
        jmiOdjava = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));
        setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        lblTrenutnoUlogovani.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lblTrenutnoUlogovani.setText("jLabel1");

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setInheritsPopupMenu(true);
        jPanel1.setMinimumSize(new java.awt.Dimension(422, 230));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(422, 230));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        jmKlijent.setText("Klijent");
        jmKlijent.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        jmiUnosKlijenta.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jmiUnosKlijenta.setText("Unos klijenta");
        jmiUnosKlijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosKlijentaActionPerformed(evt);
            }
        });
        jmKlijent.add(jmiUnosKlijenta);

        jmiPretragaKlijenata.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jmiPretragaKlijenata.setText("Pretraga klijenata");
        jmiPretragaKlijenata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaKlijenataActionPerformed(evt);
            }
        });
        jmKlijent.add(jmiPretragaKlijenata);

        jMenuBar1.add(jmKlijent);

        jmZahtev.setText("Zahtev");
        jmZahtev.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        jmiUnosZahteva.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jmiUnosZahteva.setText("Unos zahteva");
        jmiUnosZahteva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosZahtevaActionPerformed(evt);
            }
        });
        jmZahtev.add(jmiUnosZahteva);

        jmiPretragaZahteva.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jmiPretragaZahteva.setText("Pretraga zahteva");
        jmiPretragaZahteva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaZahtevaActionPerformed(evt);
            }
        });
        jmZahtev.add(jmiPretragaZahteva);

        jMenuBar1.add(jmZahtev);

        jmOpcije.setText(" Opcije");
        jmOpcije.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        jmiOdjava.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jmiOdjava.setText("Odjava");
        jmiOdjava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOdjavaActionPerformed(evt);
            }
        });
        jmOpcije.add(jmiOdjava);

        jMenuBar1.add(jmOpcije);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrenutnoUlogovani)
                .addContainerGap(360, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrenutnoUlogovani)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiPretragaZahtevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaZahtevaActionPerformed
        JDialog d = new FrmPretragaKlijenata(this, true, false);
        d.setVisible(true);
        d.setSize(this.getWidth(), this.getHeight());

    }//GEN-LAST:event_jmiPretragaZahtevaActionPerformed

    private void jmiUnosZahtevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosZahtevaActionPerformed
        FrmPretragaKlijenata f = new FrmPretragaKlijenata(this, true);
        f.srediFormuZaUnos();
        f.setVisible(true);
    }//GEN-LAST:event_jmiUnosZahtevaActionPerformed

    private void jmiPretragaKlijenataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaKlijenataActionPerformed
        JDialog d = new FrmPretragaKlijenata(this, true);
        d.setVisible(true);

    }//GEN-LAST:event_jmiPretragaKlijenataActionPerformed

    private void jmiUnosKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosKlijentaActionPerformed
        JOptionPane.showMessageDialog(null, "Sistem je kreirao novog klijenta!");
        JDialog d = new FrmUnosKlijenta(this, true);
        d.setVisible(true);
    }//GEN-LAST:event_jmiUnosKlijentaActionPerformed

    private void jmiOdjavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOdjavaActionPerformed
        // TODO add your handling code here:
        int odgovor = JOptionPane.showConfirmDialog(this, "Da li ste stigurni da želite da se odjavite?",
                "Odjava", JOptionPane.YES_NO_OPTION);
        if (odgovor == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            return;
        }
    }//GEN-LAST:event_jmiOdjavaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu jmKlijent;
    private javax.swing.JMenu jmOpcije;
    private javax.swing.JMenu jmZahtev;
    private javax.swing.JMenuItem jmiOdjava;
    private javax.swing.JMenuItem jmiPretragaKlijenata;
    private javax.swing.JMenuItem jmiPretragaZahteva;
    private javax.swing.JMenuItem jmiUnosKlijenta;
    private javax.swing.JMenuItem jmiUnosZahteva;
    private javax.swing.JLabel lblTrenutnoUlogovani;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        setLocationRelativeTo(null);
        setTitle("BG Media");
        setExtendedState(MAXIMIZED_BOTH);
    }

}