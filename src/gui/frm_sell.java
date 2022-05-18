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
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
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
        this.sell = (DefaultTableModel) table_sell.getModel();
        if(this.userRole == 0){
            btn_delete.setEnabled(false);
        }
        mostrarTabla(0, 0);
        
        
        
       
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
    
     private void mostrarTabla(int valorCliente, int valorProducto){
        refrescarTabla();
        String[] columnNames = {"Cliente", "Monto", "ITBIS", "Subtotal", "Fecha" };
        sell = new DefaultTableModel(columnNames, 0); // Setting the column names of the Table Model
        String sql;
        if(valorCliente == 0 && valorProducto == 0){
            sql = "SELECT id_cliente, Monto, ITBIS, Subtotal, Fecha FROM factura";
        } else {
            sql = "SELECT id_cliente, Monto, ITBIS, Subtotal, Fecha FROM factura WHERE id_cliente = "+ valorCliente + " OR idProducto = "+ valorProducto;
        }
        
        try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
           while(rs.next()){
                String idCliente = String.valueOf(rs.getInt(1));
                String Monto = String.valueOf(rs.getInt(2));
                String ITBIS = String.valueOf(rs.getInt(3));
                String Subtotal = String.valueOf(rs.getInt(4));
                String Fecha = String.valueOf(rs.getDate(5));
                
                
                String[] data = {idCliente, Monto, ITBIS, Subtotal, Fecha}; // Saving one row of data
                
                sell.addRow(data); // Adding the row to the Table Model
            }
           table_sell.setModel(sell);
        } catch(SQLException ex){
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
        }

    }
    private void refrescarTabla(){
        sell.setColumnCount(0);
        sell.setRowCount(0);
        table_sell.revalidate();
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
        jscroll_table = new javax.swing.JScrollPane();
        table_sell = new javax.swing.JTable();
        lbl_panel = new javax.swing.JLabel();
        lbl_cliente = new javax.swing.JLabel();
        lbl_producto = new javax.swing.JLabel();
        lbl_monto = new javax.swing.JLabel();
        btn_delete = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        txt_monto = new javax.swing.JTextField();
        cmb_cliente = new javax.swing.JComboBox<>();
        cmb_producto = new javax.swing.JComboBox<>();
        btn_facturar = new javax.swing.JButton();

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

        table_sell.setModel(new javax.swing.table.DefaultTableModel(
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
        table_sell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_sellMouseClicked(evt);
            }
        });
        jscroll_table.setViewportView(table_sell);

        lbl_panel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl_panel.setText("Panel de Ventas");

        lbl_cliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_cliente.setText("Cliente:");

        lbl_producto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_producto.setText("Producto:");

        lbl_monto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_monto.setText("Monto:");

        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_delete.setText("Borrar producto");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_add.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_add.setText("Agregar producto");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        txt_monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_montoKeyTyped(evt);
            }
        });

        cmb_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona:" }));
        cmb_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_clienteActionPerformed(evt);
            }
        });

        cmb_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona:" }));

        btn_facturar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_facturar.setText("Facturar");
        btn_facturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_facturarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_panelLayout = new javax.swing.GroupLayout(jp_panel);
        jp_panel.setLayout(jp_panelLayout);
        jp_panelLayout.setHorizontalGroup(
            jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_panel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jscroll_table, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
            .addGroup(jp_panelLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_monto)
                    .addComponent(lbl_producto)
                    .addComponent(lbl_cliente))
                .addGap(21, 21, 21)
                .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_facturar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_monto, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                        .addComponent(cmb_cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmb_producto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jp_panelLayout.createSequentialGroup()
                            .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_delete))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_panelLayout.setVerticalGroup(
            jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_panel)
                .addGap(18, 18, 18)
                .addComponent(jscroll_table, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cliente)
                    .addComponent(cmb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_producto)
                    .addComponent(cmb_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_monto)
                    .addComponent(txt_monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_facturar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
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
        int Monto = Integer.valueOf(txt_monto.getText());
        String sql = "DELETE FROM factura WHERE id_cliente = " + Cliente + " AND idProducto = " + Producto + " AND Monto = " + Monto;
        
        try{
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            
            cmb_cliente.setSelectedIndex(0);
            cmb_producto.setSelectedIndex(0);
            txt_monto.setText(""); // Cleaning the textfields
            
        } catch(SQLException ex) {
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
        }
        mostrarTabla(0,0);
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        
        int Producto = cmb_producto.getSelectedIndex();
  
        String sql = "INSERT INTO detalle_factura(fk_factura, fk_producto) VALUES("+ fk_factura + ", '" + Producto + "')";
        
        try{
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            
            cmb_producto.setSelectedIndex(0);// Cleaning the text fields
            
        } catch(SQLException ex) {
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
        }
        mostrarTabla(0,0);
           
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        frm_main Main = new frm_main(userName, userRole);
        Main.setLocationRelativeTo(null);
        Main.pack();
        Main.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    private void txt_montoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoKeyTyped
        textFieldsRestrictions.justNumbers(evt);
    }//GEN-LAST:event_txt_montoKeyTyped

    private void table_sellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_sellMouseClicked
       // Getting the information of the selected row by the user
       
       int SelectedRow = table_sell.getSelectedRow();
       
       cmb_cliente.setSelectedIndex(Integer.parseInt(table_sell.getValueAt(SelectedRow, 0).toString()));
       cmb_producto.setSelectedIndex(Integer.parseInt(table_sell.getValueAt(SelectedRow, 1).toString()));
       txt_monto.setText(table_sell.getValueAt(SelectedRow, 2).toString());
       
    }//GEN-LAST:event_table_sellMouseClicked

    private void cmb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_clienteActionPerformed

    private void btn_facturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_facturarActionPerformed
        
        int Cliente = cmb_cliente.getSelectedIndex();
        int Monto = Integer.valueOf(txt_monto.getText());
        int ITBIS = (Monto * 18)/100; // Calculating the taxes
        int Subtotal = Monto + ITBIS; // Adding taxes to the amount, and getting the total amount from the 
        String Fecha = String.valueOf(formatter.format(java.util.Calendar.getInstance().getTime()));
  
        String sql = "INSERT INTO factura(id_cliente, Monto, ITBIS, Subtotal, Fecha) VALUES('"+ Cliente + "', " + Monto + ", "+ ITBIS + ", " + Subtotal + ", '" + Fecha + "')";
        
        try{
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            
            cmb_cliente.setSelectedIndex(0);
            cmb_producto.setSelectedIndex(0);
            txt_monto.setText(""); // Cleaning the text fields
            
            fk_factura = setfk_factura();
            
        } catch(SQLException ex) {
            String err = ex.toString(); // Saving the error to a variable while converting it into a string
            
            JOptionPane.showConfirmDialog(this, err);
        }
        
        try{
          JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/factura.jasper"));
          
          Map parametros = new HashMap<>();
          parametros.put("id_factura", fk_factura);
            
          JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
          JasperViewer jv = new JasperViewer(jp);
          jv.setVisible(true); 
        }catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            System.out.println(ex);
        }
        mostrarTabla(0,0);
        
        
    }//GEN-LAST:event_btn_facturarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_facturar;
    private javax.swing.JComboBox<String> cmb_cliente;
    private javax.swing.JComboBox<String> cmb_producto;
    private javax.swing.JPanel jp_panel;
    private javax.swing.JPanel jp_sidebar;
    private javax.swing.JScrollPane jscroll_table;
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JLabel lbl_monto;
    private javax.swing.JLabel lbl_panel;
    private javax.swing.JLabel lbl_producto;
    private javax.swing.JTable table_sell;
    private javax.swing.JTextField txt_monto;
    // End of variables declaration//GEN-END:variables
}
