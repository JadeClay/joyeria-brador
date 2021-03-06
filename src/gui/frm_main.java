/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class frm_main extends javax.swing.JFrame {
    private final int userRole;
    private final String userName;

    /**
     * Creates new form frm_main
     * @param userName
     * @param userRole
     */
    public frm_main(String userName, int userRole) {
        initComponents();
        String welcomeMessage = "Bienvenido, " + userName;
        this.userRole = userRole;
        this.userName = userName;
        
        if(this.userRole == 0){
            btn_usuarios.setEnabled(false); // If user is an employee, disables the user button.
        }
        
        lbl_message.setText(welcomeMessage); // Setting welcome text;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_sidebar = new javax.swing.JPanel();
        jp_general = new javax.swing.JPanel();
        jp_titulo = new javax.swing.JPanel();
        lbl_joyerias = new javax.swing.JLabel();
        lbl_message = new javax.swing.JLabel();
        jp_botones = new javax.swing.JPanel();
        btn_usuarios = new javax.swing.JButton();
        btn_inventario = new javax.swing.JButton();
        btn_clientes = new javax.swing.JButton();
        btn_ventas = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jp_sidebar.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jp_sidebarLayout = new javax.swing.GroupLayout(jp_sidebar);
        jp_sidebar.setLayout(jp_sidebarLayout);
        jp_sidebarLayout.setHorizontalGroup(
            jp_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );
        jp_sidebarLayout.setVerticalGroup(
            jp_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );

        lbl_joyerias.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_joyerias.setText("Joyer??as Brador");

        lbl_message.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btn_usuarios.setText("Usuarios");
        btn_usuarios.setMaximumSize(new java.awt.Dimension(83, 23));
        btn_usuarios.setMinimumSize(new java.awt.Dimension(83, 23));
        btn_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usuariosActionPerformed(evt);
            }
        });

        btn_inventario.setText("Inventario");
        btn_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inventarioActionPerformed(evt);
            }
        });

        btn_clientes.setText("Clientes");
        btn_clientes.setPreferredSize(new java.awt.Dimension(83, 23));
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });

        btn_ventas.setText("Ventas");
        btn_ventas.setMinimumSize(new java.awt.Dimension(83, 23));
        btn_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ventasActionPerformed(evt);
            }
        });

        btn_exit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(255, 0, 0));
        btn_exit.setText("Cerrar sesi??n");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_botonesLayout = new javax.swing.GroupLayout(jp_botones);
        jp_botones.setLayout(jp_botonesLayout);
        jp_botonesLayout.setHorizontalGroup(
            jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_botonesLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
            .addGroup(jp_botonesLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_botonesLayout.setVerticalGroup(
            jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_botonesLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_inventario, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(btn_ventas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jp_tituloLayout = new javax.swing.GroupLayout(jp_titulo);
        jp_titulo.setLayout(jp_tituloLayout);
        jp_tituloLayout.setHorizontalGroup(
            jp_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jp_tituloLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(lbl_joyerias)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jp_tituloLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbl_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp_tituloLayout.setVerticalGroup(
            jp_tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_tituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_joyerias)
                .addGap(1, 1, 1)
                .addComponent(lbl_message, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jp_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jp_generalLayout = new javax.swing.GroupLayout(jp_general);
        jp_general.setLayout(jp_generalLayout);
        jp_generalLayout.setHorizontalGroup(
            jp_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jp_generalLayout.setVerticalGroup(
            jp_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_generalLayout.createSequentialGroup()
                .addComponent(jp_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jp_general, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_general, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jp_sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        int OK_CANCEL_OPTION = JOptionPane.showConfirmDialog(null, "??Est?? seguro que desea cerrar sesi??n?", "Confirmar cerrar sesi??n", JOptionPane.OK_CANCEL_OPTION);
        
        if(OK_CANCEL_OPTION == JOptionPane.OK_OPTION){
            frm_login login = new frm_login();
            login.setLocationRelativeTo(null);
            login.pack();
            login.setVisible(true);
            
            this.dispose();
        }
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuariosActionPerformed
       
        frm_user Usuarios = new frm_user(userRole, userName);
        Usuarios.setLocationRelativeTo(null);
        Usuarios.pack();
        Usuarios.setVisible(true);
        
        this.dispose();
       
    }//GEN-LAST:event_btn_usuariosActionPerformed

    private void btn_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ventasActionPerformed
        frm_sell Ventas = new frm_sell(userRole, userName);
        Ventas.setLocationRelativeTo(null);
        Ventas.pack();
        Ventas.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btn_ventasActionPerformed

    private void btn_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inventarioActionPerformed
        frm_inventory Inventario = new frm_inventory(userRole, userName);
        Inventario.setLocationRelativeTo(null);
        Inventario.pack();
        Inventario.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btn_inventarioActionPerformed

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed
        frm_clients Clientes = new frm_clients(userRole, userName);
        Clientes.setLocationRelativeTo(null);
        Clientes.pack();
        Clientes.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btn_clientesActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_inventario;
    private javax.swing.JButton btn_usuarios;
    private javax.swing.JButton btn_ventas;
    private javax.swing.JPanel jp_botones;
    private javax.swing.JPanel jp_general;
    private javax.swing.JPanel jp_sidebar;
    private javax.swing.JPanel jp_titulo;
    private javax.swing.JLabel lbl_joyerias;
    private javax.swing.JLabel lbl_message;
    // End of variables declaration//GEN-END:variables
}
