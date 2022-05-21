/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author oscar
 */
public class frm_sell extends javax.swing.JFrame {
    private final int userRole;
    private final String userName;
    DefaultTableModel sell;
    private final Connection con = DBConnection.getConnection(); // Saving MYSQL Database connection into a variable
    private int fk_factura = setfk_factura();
    
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Instancing a formatter to save the date into mysql

    
    
    /**
     * Creates new form frm_main
     * @param userRole
     * @param userName
     */
    
    public frm_sell(int userRole, String userName) {
        initComponents();
        
        this.userRole = userRole;
        this.userName = userName;

        if(this.userRole == 0){
            btn_delete.setEnabled(false);
        }
        
        
        
       
        try {
            String sql = "SELECT nombre, apellidos FROM cliente";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String cliente_text = rs.getString(1) + " " + rs.getString(2);
                cmb_cliente.addItem(cliente_text);
            }
                
        }catch(SQLException ex){
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
           
            JOptionPane.showConfirmDialog(this, err);
        } // cmb_cliente values
        
        try {
            String sql = "SELECT nombreProducto FROM producto";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
                while(rs.next()){
                    String producto_text = rs.getString(1);
                    cmb_producto.addItem(producto_text);
                }
        }catch(SQLException ex){
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
           
            JOptionPane.showConfirmDialog(this, err);
        } // cmb_producto

    }
    
    private int setfk_factura(){
        String sql = "SELECT id_factura FROM factura";
        int id_factura = 0;
        
            try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
           while(rs.next()){
                id_factura = rs.getInt(1);
           }
           
           id_factura += 1;
           
           } catch(SQLException ex){
                String err = ex.toString(); // Saving the error to a variable while converting it into a string

                JOptionPane.showConfirmDialog(this, err);
            }
               
        return id_factura;
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
        btn_exit = new javax.swing.JButton();
        jp_panel = new javax.swing.JPanel();
        lbl_panel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        btn_delete = new javax.swing.JButton();
        lbl_monto = new javax.swing.JLabel();
        cmb_producto = new javax.swing.JComboBox<>();
        cmb_cliente = new javax.swing.JComboBox<>();
        lbl_producto = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        btn_facturar = new javax.swing.JButton();
        lbl_cliente = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_factura = new javax.swing.JLabel();
        txt_factura = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jp_sidebar.setBackground(new java.awt.Color(0, 102, 102));

        btn_exit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(255, 0, 0));
        btn_exit.setText("<-");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_sidebarLayout = new javax.swing.GroupLayout(jp_sidebar);
        jp_sidebar.setLayout(jp_sidebarLayout);
        jp_sidebarLayout.setHorizontalGroup(
            jp_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_sidebarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btn_exit)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jp_sidebarLayout.setVerticalGroup(
            jp_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_panel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl_panel.setText("Panel de Ventas");

        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_delete.setText("Borrar producto");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        lbl_monto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_monto.setText("Cantidad:");

        cmb_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona:" }));

        cmb_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona:" }));
        cmb_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_clienteActionPerformed(evt);
            }
        });

        lbl_producto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_producto.setText("Producto:");

        txt_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyTyped(evt);
            }
        });

        btn_facturar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_facturar.setText("Facturar");
        btn_facturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_facturarActionPerformed(evt);
            }
        });

        lbl_cliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_cliente.setText("Cliente:");

        btn_add.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_add.setText("Agregar producto");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(btn_delete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl_monto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cmb_producto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cmb_cliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl_producto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txt_cantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btn_facturar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl_cliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btn_add, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_monto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_producto))
                .addGap(23, 23, 23)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete))
                    .addComponent(txt_cantidad)
                    .addComponent(cmb_cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_producto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_facturar, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cliente)
                    .addComponent(cmb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_producto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lbl_monto)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_facturar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Facturar", jLayeredPane1);

        lbl_factura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_factura.setText("# de Factura:");

        txt_factura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_facturaKeyTyped(evt);
            }
        });

        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(lbl_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_factura, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_factura))
                .addGap(18, 18, 18)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buscar Factura", jPanel1);

        javax.swing.GroupLayout jp_panelLayout = new javax.swing.GroupLayout(jp_panel);
        jp_panel.setLayout(jp_panelLayout);
        jp_panelLayout.setHorizontalGroup(
            jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_panelLayout.createSequentialGroup()
                .addGap(0, 172, Short.MAX_VALUE)
                .addComponent(lbl_panel)
                .addContainerGap(182, Short.MAX_VALUE))
            .addGroup(jp_panelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_panelLayout.setVerticalGroup(
            jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_panel)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int Cliente = cmb_cliente.getSelectedIndex();
        int Producto = cmb_producto.getSelectedIndex();
        int Monto = Integer.valueOf(txt_cantidad.getText());
        String sql = "DELETE FROM detalle_factura WHERE fk_factura = " + fk_factura + " ORDER BY id DESC LIMIT 1";
        
        try{
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            
            cmb_producto.setSelectedIndex(0);// Cleaning the text fields
            
        } catch(SQLException ex) {
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
        }
        
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        
        int Producto = cmb_producto.getSelectedIndex();
        int Cantidad = Integer.valueOf(txt_cantidad.getText());
        int Costo, ITBIS, Total = 0;
        
        String sql = "SELECT costoProducto FROM producto WHERE idProducto =" + Producto;
        
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            rs.beforeFirst();
            if(rs.next()){
                Costo = rs.getInt(1);
            }else{
                Costo = 1;
            }
            
            ITBIS = (Costo * 18)/100; // Calculating the taxes
            Total = (Costo + ITBIS) * Cantidad; // Adding the taxes to the cost
            
        } catch(SQLException ex) {
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            System.out.println(err);
            JOptionPane.showConfirmDialog(this, err);
        }
        
        sql = "INSERT INTO detalle_factura(fk_factura, fk_producto, monto, cantidad) VALUES("+ fk_factura + ", " + Producto + "," + Total + "," + Cantidad + ")";
        
        try{
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            
            cmb_producto.setSelectedIndex(0);// Cleaning the text fields
            
        } catch(SQLException ex) {
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
        }
           
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        frm_main Main = new frm_main(userName, userRole);
        Main.setLocationRelativeTo(null);
        Main.pack();
        Main.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    private void txt_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyTyped
        textFieldsRestrictions.justNumbers(evt);
    }//GEN-LAST:event_txt_cantidadKeyTyped

    private void cmb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_clienteActionPerformed

    private void btn_facturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_facturarActionPerformed
        
        int Producto = cmb_producto.getSelectedIndex();
        int Cliente = cmb_cliente.getSelectedIndex();
        String Fecha = String.valueOf(formatter.format(java.util.Calendar.getInstance().getTime()));
        
        String sql = "INSERT INTO factura(id_cliente, Fecha) VALUES("+ Cliente + ", '" + Fecha + "')";
        
        try{
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            
            cmb_cliente.setSelectedIndex(0);
            cmb_producto.setSelectedIndex(0);
            txt_cantidad.setText(""); // Cleaning the text fields
            
        } catch(SQLException ex) {
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
        }
        
        File reporte = new File("src/reportes/factura.jrxml");
        
        try{
          System.out.println(fk_factura);  
            
          JasperReport jr = JasperCompileManager.compileReport(reporte.getPath());
          
          Map parametros = new HashMap<>();
          parametros.put("idf", fk_factura);
            
          JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
          JasperViewer jv = new JasperViewer(jp, false);
          jv.setTitle("Reporte de Factura");
          jv.setVisible(true); 
          
          
          
        }catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            System.out.println(ex);
        }
        fk_factura = setfk_factura();
        
        
    }//GEN-LAST:event_btn_facturarActionPerformed

    private void txt_facturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_facturaKeyTyped
        textFieldsRestrictions.justNumbers(evt);
    }//GEN-LAST:event_txt_facturaKeyTyped

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        int idf = Integer.valueOf(txt_factura.getText());
        String sql = "SELECT * FROM factura WHERE id_factura = " + idf;
        
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                JOptionPane.showMessageDialog(this, "La factura se ha encontrado con éxito");
                
                        File reporte = new File("src/reportes/factura.jrxml");

                        JasperReport jr = JasperCompileManager.compileReport(reporte.getPath());

                        Map parametros = new HashMap<>();
                        parametros.put("idf", idf);

                        JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
                        JasperViewer jv = new JasperViewer(jp, false);
                        jv.setTitle("Reporte de Factura");
                        jv.setVisible(true); 
                    
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la factura");
                // If the ResultSet doesn't even have one column, the username and the password doesn't coincide nor exists.
            }
        } catch (SQLException | JRException ex){
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
            Logger.getLogger(frm_login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_facturar;
    private javax.swing.JComboBox<String> cmb_cliente;
    private javax.swing.JComboBox<String> cmb_producto;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jp_panel;
    private javax.swing.JPanel jp_sidebar;
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JLabel lbl_factura;
    private javax.swing.JLabel lbl_monto;
    private javax.swing.JLabel lbl_panel;
    private javax.swing.JLabel lbl_producto;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_factura;
    // End of variables declaration//GEN-END:variables
}
