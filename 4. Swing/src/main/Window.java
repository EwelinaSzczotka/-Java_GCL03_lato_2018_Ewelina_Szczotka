/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ewelinaa
 */
public class Window extends javax.swing.JFrame implements FocusListener{

    private DefaultTableModel model;
    /**
     * Creates new form Window
     */
    public Window(DefaultTableModel m) {
        initComponents();
        model = m;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        studentTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        studentLBL = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tematTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pracaLBL = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        stronyTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        stronyLBL = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        promotorTF = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        promotorLBL = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pMark = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        recenzentTF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        recenzentLBL = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rMark = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuZamknij = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        oknoZamknij = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new java.awt.GridLayout(0, 2, 3, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nazwa studenta:");
        jPanel2.add(jLabel1);

        studentTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentTFActionPerformed(evt);
            }
        });
        studentTF.addFocusListener(this);
        jPanel2.add(studentTF);
        jPanel2.add(jLabel9);

        studentLBL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        studentLBL.setForeground(new java.awt.Color(255, 0, 0));
        studentLBL.setText("Nieprawidłowa nazwa");
        studentLBL.setVisible(false);
        jPanel2.add(studentLBL);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Temat pracy:");
        jPanel2.add(jLabel3);

        tematTF.addFocusListener(this);
        jPanel2.add(tematTF);
        jPanel2.add(jLabel10);

        pracaLBL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pracaLBL.setForeground(new java.awt.Color(255, 0, 0));
        pracaLBL.setText("Nieprawidlowa nazwa");
        pracaLBL.setVisible(false);
        jPanel2.add(pracaLBL);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Stron:");
        jPanel2.add(jLabel4);

        stronyTF.addFocusListener(this);
        jPanel2.add(stronyTF);
        jPanel2.add(jLabel12);

        stronyLBL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        stronyLBL.setForeground(new java.awt.Color(255, 0, 0));
        stronyLBL.setText("Nieprawidłowa ilość");
        stronyLBL.setVisible(false);
        jPanel2.add(stronyLBL);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nazwa promotora:");
        jPanel2.add(jLabel5);

        promotorTF.addFocusListener(this);
        jPanel2.add(promotorTF);
        jPanel2.add(jLabel14);

        promotorLBL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        promotorLBL.setForeground(new java.awt.Color(255, 0, 0));
        promotorLBL.setText("Nieprawidłowa nazwa");
        promotorLBL.setVisible(false);
        jPanel2.add(promotorLBL);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Ocena promotora:");
        jPanel2.add(jLabel2);

        pMark.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5.0", "4.0", "3.0", "2.0", " " }));
        jPanel2.add(pMark);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nazwa recenzenta:");
        jPanel2.add(jLabel6);

        recenzentTF.addFocusListener(this);
        jPanel2.add(recenzentTF);
        jPanel2.add(jLabel16);

        recenzentLBL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        recenzentLBL.setForeground(new java.awt.Color(255, 0, 0));
        recenzentLBL.setText("Nieprawidłowa nazwa");
        recenzentLBL.setVisible(false);
        jPanel2.add(recenzentLBL);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Ocena recenzenta:");
        jPanel2.add(jLabel7);

        rMark.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5.0", "4.0", "3.0", "2.0" }));
        jPanel2.add(rMark);

        addButton.setText("Dodaj");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jMenu1.setText("Program");

        menuZamknij.setText("Zamknij");
        menuZamknij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuZamknijActionPerformed(evt);
            }
        });
        jMenu1.add(menuZamknij);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Okno");

        oknoZamknij.setText("Zamknij");
        oknoZamknij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oknoZamknijActionPerformed(evt);
            }
        });
        jMenu2.add(oknoZamknij);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuZamknijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuZamknijActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuZamknijActionPerformed

    private void oknoZamknijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oknoZamknijActionPerformed
        this.dispose();
    }//GEN-LAST:event_oknoZamknijActionPerformed

    private void studentTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentTFActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        
        
       if(studentLBL.isVisible() || pracaLBL.isVisible() || promotorLBL.isVisible() || recenzentLBL.isVisible() ||
          stronyLBL.isVisible()){ 
            JOptionPane.showMessageDialog(new JFrame(),"Nieodpowiednie dane!","Error",JOptionPane.ERROR_MESSAGE);
       }
       else{   
                int strony = Integer.parseInt(stronyTF.getText());
                double rM = Double.parseDouble((String)rMark.getSelectedItem());
                double pM= Double.parseDouble((String)pMark.getSelectedItem());
                model.addRow(new Object[]{studentTF.getText(),tematTF.getText(),strony,
                promotorTF.getText(), pM, recenzentTF.getText(), rM});
       }
    }//GEN-LAST:event_addButtonActionPerformed

    public void focusGained(FocusEvent e){}
    
    public void focusLost(FocusEvent e){
        if(e.getSource().equals(studentTF)){
            if(!validateName(studentTF.getText()))
                studentLBL.setVisible(true);
            else studentLBL.setVisible(false);
        }
        if(e.getSource().equals(tematTF)){
            if(!validateTopic(tematTF.getText()))
                pracaLBL.setVisible(true);
            else pracaLBL.setVisible(false);
        }
        if(e.getSource().equals(promotorTF)){
            if(!validateName(promotorTF.getText()))
                promotorLBL.setVisible(true);
            else promotorLBL.setVisible(false);
        }
        if(e.getSource().equals(recenzentTF)){
            if(!validateName(recenzentTF.getText()))
                recenzentLBL.setVisible(true);
            else recenzentLBL.setVisible(false);
        }
        if(e.getSource().equals(stronyTF)){
            if(!validateName(stronyTF.getText()))
                stronyLBL.setVisible(true);
            else stronyLBL.setVisible(false);
        }
    }
    
    public boolean validateName(String text){
        if(((text.length())<3)||((text.length())>30))
            return false;
        else return true;
    }
    
    public boolean validateTopic(String text){
        if(((text.length())<5)||((text.length())>50))
            return false;
        else return true;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void display() {
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
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem menuZamknij;
    private javax.swing.JMenuItem oknoZamknij;
    private javax.swing.JComboBox<String> pMark;
    private javax.swing.JLabel pracaLBL;
    private javax.swing.JLabel promotorLBL;
    private javax.swing.JTextField promotorTF;
    private javax.swing.JComboBox<String> rMark;
    private javax.swing.JLabel recenzentLBL;
    private javax.swing.JTextField recenzentTF;
    private javax.swing.JLabel stronyLBL;
    private javax.swing.JTextField stronyTF;
    private javax.swing.JLabel studentLBL;
    private javax.swing.JTextField studentTF;
    private javax.swing.JTextField tematTF;
    // End of variables declaration//GEN-END:variables
}
