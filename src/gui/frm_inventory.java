/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author oscar
 */
public class frm_inventory extends javax.swing.JFrame {
    int userRole;
    String userName;
    DefaultTableModel inventory;
    Connection con = DBConnection.getConnection(); // Saving MYSQL Database connection into a variable
    /**
     * Creates new form frm_main
     * @param userRole
     * @param userName
     */
    public frm_inventory(int userRole, String userName) {
        initComponents();
        
        this.userRole = userRole;
        this.userName = userName;
        
        this.inventory = (DefaultTableModel) table_inventory.getModel();

       mostrarTabla("");
    }
    
    private void mostrarTabla(String valorProducto){
        refrescarTabla();
        String[] columnNames = {"idProducto", "nombreProducto", "stockProducto", "costoProducto"};
        inventory = new DefaultTableModel(columnNames, 0); // Setting the column names of the Table Model;
        String sql;
        if(valorProducto.equals("")){
            sql = "SELECT idProducto, nombreProducto, stockProducto, costoProducto FROM producto";
        } else {
            sql = "SELECT idProducto, nombreProducto, stockProducto, costoProducto FROM producto WHERE nombreProducto = '"+ valorProducto + "'";
        }
        
        try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
           while(rs.next()){
                String idProducto = String.valueOf(rs.getInt(1));
                String nombreProducto = rs.getString(2);
                String stockProducto  = String.valueOf(rs.getInt(3));
                String costoProducto  = String.valueOf(rs.getInt(4));
                
                String[] data = {idProducto, nombreProducto, stockProducto, costoProducto}; // Saving one row of data
                
                inventory.addRow(data); // Adding the row to the Table Model
                
                
            }
            table_inventory.setModel(inventory);
        } catch(SQLException ex){
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
        }

    }
    private void refrescarTabla(){
        inventory.setColumnCount(0);
        inventory.setRowCount(0);
        table_inventory.revalidate();
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
        lbl_producto = new javax.swing.JLabel();
        txt_producto = new javax.swing.JTextField();
        lbl_stock = new javax.swing.JLabel();
        txt_stock = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        btn_create = new javax.swing.JButton();
        btn_modify = new javax.swing.JButton();
        btn_report = new javax.swing.JButton();
        jscroll_table = new javax.swing.JScrollPane();
        table_inventory = new javax.swing.JTable();
        lbl_costo = new javax.swing.JLabel();
        txt_costo = new javax.swing.JTextField();

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
                .addGap(18, 18, 18)
                .addComponent(btn_exit)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jp_sidebarLayout.setVerticalGroup(
            jp_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_panel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl_panel.setText("Panel de Inventario");

        lbl_producto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_producto.setText("Producto:");

        txt_producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_productoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_productoKeyTyped(evt);
            }
        });

        lbl_stock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_stock.setText("Stock:");

        txt_stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_stockKeyTyped(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_delete.setText("Borrar");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_create.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_create.setText("Crear");
        btn_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createActionPerformed(evt);
            }
        });

        btn_modify.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_modify.setText("Modificar");
        btn_modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifyActionPerformed(evt);
            }
        });

        btn_report.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_report.setText("Reporte");
        btn_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportActionPerformed(evt);
            }
        });

        table_inventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_inventoryMouseClicked(evt);
            }
        });
        jscroll_table.setViewportView(table_inventory);

        lbl_costo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_costo.setText("Costo:");

        txt_costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costoActionPerformed(evt);
            }
        });
        txt_costo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_costoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jp_panelLayout = new javax.swing.GroupLayout(jp_panel);
        jp_panel.setLayout(jp_panelLayout);
        jp_panelLayout.setHorizontalGroup(
            jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_panelLayout.createSequentialGroup()
                .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jscroll_table, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_panelLayout.createSequentialGroup()
                        .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_panelLayout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(lbl_panel))
                            .addGroup(jp_panelLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_producto)
                                    .addComponent(lbl_stock)
                                    .addComponent(lbl_costo))
                                .addGap(18, 18, 18)
                                .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_panelLayout.createSequentialGroup()
                                        .addComponent(btn_create, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_modify)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_report, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_costo)
                                        .addComponent(txt_stock, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                                        .addComponent(txt_producto)))))
                        .addGap(0, 62, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jp_panelLayout.setVerticalGroup(
            jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_panel)
                .addGap(18, 18, 18)
                .addComponent(jscroll_table, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_producto)
                    .addComponent(txt_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_stock)
                    .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_costo)
                    .addComponent(txt_costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_create, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_report, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jp_sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jp_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed

        String Producto = txt_producto.getText();
        int Stock = Integer.valueOf(txt_stock.getText());
        int Costo = Integer.valueOf(txt_costo.getText());
        String sql = "DELETE FROM producto WHERE nombreProducto = '" + Producto + "' AND stockProducto = " + Stock + " AND costoProducto = " + Costo;
        
        try{
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            
            txt_producto.setText("");
            txt_stock.setText(""); // Cleaning the textfields
            txt_costo.setText("");
            
        } catch(SQLException ex) {
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
        }
        mostrarTabla("");
        
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createActionPerformed
        String Producto = txt_producto.getText();
        int id = 0;
        int Stock = Integer.valueOf(txt_stock.getText());
        int Costo = Integer.valueOf(txt_costo.getText());
        String sql = "SELECT idProducto, nombreProducto FROM producto ORDER BY idProducto DESC LIMIT 1";
        
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.beforeFirst();
            if(rs.next()){
                id = rs.getInt(1);
                id += 1;
            }else{
                id = 1;
            }
            
        }catch(SQLException ex) {
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
        }
        
        sql = "INSERT INTO producto(idProducto,nombreProducto,stockProducto,costoProducto) VALUES("+ id + ",'" + Producto + "'," + Stock +"," + Costo +")";
        
        try{
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            
            txt_producto.setText("");
            txt_stock.setText(""); // Cleaning the textfields
            txt_costo.setText("");
            
        } catch(SQLException ex) {
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
        }
        mostrarTabla("");
    }//GEN-LAST:event_btn_createActionPerformed

    private void btn_modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifyActionPerformed
        String Producto = txt_producto.getText();
        int Stock = Integer.valueOf(txt_stock.getText());
        int Costo = Integer.valueOf(txt_costo.getText());
        String sql = "UPDATE producto SET nombreProducto ='" + Producto + "', stockProducto = " + Stock + ", costoProducto = "+ Costo +" WHERE nombreProducto = '"+ Producto + "'";
        
        try{
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            
            txt_producto.setText("");
            txt_stock.setText(""); // Cleaning the textfields
            txt_costo.setText("");
            
        } catch(SQLException ex) {
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
        }
        mostrarTabla("");
    }//GEN-LAST:event_btn_modifyActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        frm_main Main = new frm_main(userName, userRole);
        Main.setLocationRelativeTo(null);
        Main.pack();
        Main.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    private void txt_productoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_productoKeyTyped
        textFieldsRestrictions.justLetters(evt);
    }//GEN-LAST:event_txt_productoKeyTyped

    private void txt_stockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stockKeyTyped
        textFieldsRestrictions.justNumbers(evt);
    }//GEN-LAST:event_txt_stockKeyTyped

    private void txt_productoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_productoKeyPressed
        try{
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                String b = txt_producto.getText();
                
                mostrarTabla(b);
            }
        } catch (Exception ex){
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
            Logger.getLogger(frm_sell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_productoKeyPressed

    private void table_inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_inventoryMouseClicked
       // Getting the information of the selected row by the user  
       int SelectedRow = table_inventory.getSelectedRow();
       
       txt_producto.setText(table_inventory.getValueAt(SelectedRow, 1).toString());
       txt_stock.setText(table_inventory.getValueAt(SelectedRow, 2).toString());
       txt_costo.setText(table_inventory.getValueAt(SelectedRow, 3).toString());
    }//GEN-LAST:event_table_inventoryMouseClicked

    private void btn_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportActionPerformed
        try{
          JasperReport jr = (JasperReport) JRLoader.loadObject(frm_user.class.getResource("/reportes/reporte_inventario.jasper"));
          //Codigo en comentario es agregando los datos directamente
          Map parametros = new HashMap<>();
          parametros.put("Titulo", "Reporte de Inventario");
            

          JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
          JasperViewer jv = new JasperViewer(jp, false);
          jv.setVisible(true); 
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_btn_reportActionPerformed

    private void txt_costoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_costoKeyTyped
        textFieldsRestrictions.justNumbers(evt);
    }//GEN-LAST:event_txt_costoKeyTyped

    private void txt_costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_create;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_modify;
    private javax.swing.JButton btn_report;
    private javax.swing.JPanel jp_panel;
    private javax.swing.JPanel jp_sidebar;
    private javax.swing.JScrollPane jscroll_table;
    private javax.swing.JLabel lbl_costo;
    private javax.swing.JLabel lbl_panel;
    private javax.swing.JLabel lbl_producto;
    private javax.swing.JLabel lbl_stock;
    private javax.swing.JTable table_inventory;
    private javax.swing.JTextField txt_costo;
    private javax.swing.JTextField txt_producto;
    private javax.swing.JTextField txt_stock;
    // End of variables declaration//GEN-END:variables
}
