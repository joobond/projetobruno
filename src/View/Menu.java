/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JOptionPane;


/**
 *
 * @author Arthur
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();        
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPainel1 = new javax.swing.JPanel();
        jbCliente = new javax.swing.JButton();
        jbFuncionario = new javax.swing.JButton();
        jbProduto = new javax.swing.JButton();
        jbRelatorio = new javax.swing.JButton();
        jpPainel2 = new javax.swing.JPanel();
        jlLanchonet = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jpPainel1.setBackground(new java.awt.Color(255, 255, 255));

        jbCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/botão Cliente.png"))); // NOI18N
        jbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClienteActionPerformed(evt);
            }
        });

        jbFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/botão Funcionario.png"))); // NOI18N
        jbFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFuncionarioActionPerformed(evt);
            }
        });

        jbProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/botão Produto.png"))); // NOI18N

        jbRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/botão Relatório.png"))); // NOI18N

        javax.swing.GroupLayout jpPainel1Layout = new javax.swing.GroupLayout(jpPainel1);
        jpPainel1.setLayout(jpPainel1Layout);
        jpPainel1Layout.setHorizontalGroup(
            jpPainel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPainel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jpPainel1Layout.setVerticalGroup(
            jpPainel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPainel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpPainel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpPainel2.setBackground(new java.awt.Color(18, 30, 49));

        jlLanchonet.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jlLanchonet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lanchonet.png"))); // NOI18N

        javax.swing.GroupLayout jpPainel2Layout = new javax.swing.GroupLayout(jpPainel2);
        jpPainel2.setLayout(jpPainel2Layout);
        jpPainel2Layout.setHorizontalGroup(
            jpPainel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPainel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlLanchonet, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPainel2Layout.setVerticalGroup(
            jpPainel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPainel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlLanchonet, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jmSair.setText("Sair");
        jmSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPainel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpPainel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpPainel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpPainel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClienteActionPerformed
      new Cliente().setVisible(true);
    }//GEN-LAST:event_jbClienteActionPerformed

    private void jmSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmSairMouseClicked
       int resp = JOptionPane.showConfirmDialog(null,"Deseja sair?");
        if (resp == JOptionPane.YES_OPTION) {
           System.exit(0);
        }
    }//GEN-LAST:event_jmSairMouseClicked

    private void jbFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbFuncionarioActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jbCliente;
    private javax.swing.JButton jbFuncionario;
    private javax.swing.JButton jbProduto;
    private javax.swing.JButton jbRelatorio;
    private javax.swing.JLabel jlLanchonet;
    private javax.swing.JMenu jmSair;
    private javax.swing.JPanel jpPainel1;
    private javax.swing.JPanel jpPainel2;
    // End of variables declaration//GEN-END:variables
}
