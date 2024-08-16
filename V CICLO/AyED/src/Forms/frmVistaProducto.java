/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import Classes.Consumo;
import Classes.Producto;
import DAO.DAOConsumo;
import DAO.DAOProducto;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jorge
 */
public class frmVistaProducto extends javax.swing.JFrame {

    /**
     * Creates new form frmVistaProducto
     */
    String[] Cabecera = {"IdProducto", "Nombre", "Descripción", "Precio Venta"};

    DefaultTableModel DTM;
    DAOProducto DAO = new DAOProducto();
    List<Producto> LP = new LinkedList<>();
    TableRowSorter<DefaultTableModel> Filtro;

    public frmVistaProducto() {
        initComponents();
        RecuperarDesdeBD();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtfiltrar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(238, 243, 171));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Clientes"));

        jLabel1.setText("Filtrar");

        txtfiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfiltrarfiltrar(evt);
            }
        });

        tablaProducto.setBackground(new java.awt.Color(243, 179, 43));
        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProductoSeleccionar(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProducto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(txtfiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtfiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void RecuperarDesdeBD() {
        LP = DAO.ListarProducto();
        DTM = new DefaultTableModel(null, Cabecera);
        for (Producto P : LP) {
            DTM.addRow(P.Convertir());
        }
        tablaProducto.setModel(DTM);

        Filtro = new TableRowSorter(DTM); //necesario para filtrar
        tablaProducto.setRowSorter(Filtro);  //necesario para filtrar

        Configuracion();
    }

    public void Configuracion() {
        //esconder la columna ID
        tablaProducto.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaProducto.getColumnModel().getColumn(0).setMinWidth(0);
        tablaProducto.getColumnModel().getColumn(0).setPreferredWidth(0);

    }
    

    private void txtfiltrarfiltrar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltrarfiltrar
        // TODO add your handling code here:
        Filtrar();
    }//GEN-LAST:event_txtfiltrarfiltrar

    private void tablaProductoSeleccionar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoSeleccionar
        // TODO add your handling code here:
        if (evt.getClickCount()==2) {
            int fila= tablaProducto.getSelectedRow();
            
            String cod,valor1,valor2;
            
            cod=tablaProducto.getValueAt(fila,0).toString();
            valor1=tablaProducto.getValueAt(fila,1).toString();
            valor2=tablaProducto.getValueAt(fila,3).toString();
            
            frmConsumo.txtidproducto.setText(cod);
            frmConsumo.txtproducto.setText(valor1);
            frmConsumo.txtprecio_venta.setText(valor2);
            
            this.setVisible(false);

        }
    }//GEN-LAST:event_tablaProductoSeleccionar

    private void Filtrar() {
        try {
            String Texto = txtfiltrar.getText();
            Filtro.setRowFilter(RowFilter.regexFilter(Texto));
        } catch (Exception e) {
        }
    }

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
            java.util.logging.Logger.getLogger(frmVistaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVistaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVistaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVistaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVistaProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTextField txtfiltrar;
    // End of variables declaration//GEN-END:variables
}
