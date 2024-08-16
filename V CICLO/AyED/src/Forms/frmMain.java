/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

/**
 *
 * @author herma
 */
public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmMain
     */
    public void setRecepcionista(String usuario) {
        lblRecepcionista.setText(usuario);
    }

    public frmMain() {
        initComponents();
        this.setExtendedState(frmMain.MAXIMIZED_BOTH);
        this.setTitle("Sistema de Reserva de Habitaciones y Gestión de ventas - JH Hotel Residencial");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        lblRecepcionista = new javax.swing.JLabel();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        menuHabitacion = new javax.swing.JMenuItem();
        menuProductos = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        menuReservas = new javax.swing.JMenuItem();
        menuHospedar = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        menuClientes = new javax.swing.JMenuItem();
        menuPagos = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        menuUsuarios = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRecepcionista.setText("jLabel1");

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/archivo.png"))); // NOI18N
        jMenu11.setText("Archivo");

        menuHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cama.png"))); // NOI18N
        menuHabitacion.setText("Habitaciones");
        menuHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHabitacionActionPerformed(evt);
            }
        });
        jMenu11.add(menuHabitacion);

        menuProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        menuProductos.setText("Productos");
        menuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirFrmProducto(evt);
            }
        });
        jMenu11.add(menuProductos);

        jMenuBar1.add(jMenu11);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/hospedar.png"))); // NOI18N
        jMenu7.setText("Reserva");
        jMenu7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuReservas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/keyboard.png"))); // NOI18N
        menuReservas.setText("Reservas");
        menuReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirFrmReserva(evt);
            }
        });
        jMenu7.add(menuReservas);

        menuHospedar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/hospedar.png"))); // NOI18N
        menuHospedar.setText("Hospedar");
        menuHospedar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHospedarActionPerformed(evt);
            }
        });
        jMenu7.add(menuHospedar);

        jMenuBar1.add(jMenu7);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buyer.png"))); // NOI18N
        jMenu8.setText("Clientes");
        jMenu8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add-user.png"))); // NOI18N
        menuClientes.setText("Agregar");
        menuClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirFrmCliente(evt);
            }
        });
        jMenu8.add(menuClientes);

        menuPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pago.png"))); // NOI18N
        menuPagos.setText("Compras");
        menuPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPagosActionPerformed(evt);
            }
        });
        jMenu8.add(menuPagos);

        jMenuBar1.add(jMenu8);

        jMenu12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/config.png"))); // NOI18N
        jMenu12.setText("Configuraciones");

        menuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exportar.png"))); // NOI18N
        menuUsuarios.setText("Exportar");
        menuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuariosActionPerformed(evt);
            }
        });
        jMenu12.add(menuUsuarios);

        jMenuBar1.add(jMenu12);

        jMenu13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ayuda.png"))); // NOI18N
        jMenu13.setText("Ayuda");

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/info.png"))); // NOI18N
        jMenuItem6.setText("Acerca de...");
        jMenu13.add(jMenuItem6);

        jMenuItem10.setText("Ayuda");
        jMenu13.add(jMenuItem10);

        jMenuBar1.add(jMenu13);

        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exit.png"))); // NOI18N
        menuSalir.setText("Salir");
        menuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuSalirMousePressed(evt);
            }
        });
        jMenuBar1.add(menuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(954, Short.MAX_VALUE)
                .addComponent(lblRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecepcionista))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirFrmCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirFrmCliente
        // TODO add your handling code here:
        frmCliente inst= null;

        if (inst == null || inst.isClosed()) {
            inst = new frmCliente();
            escritorio.add(inst);
        }
        inst.setVisible(true);
    }//GEN-LAST:event_abrirFrmCliente

    private void abrirFrmReserva(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirFrmReserva
        // TODO add your handling code here:
        frmReserva inst= null;

        if (inst == null || inst.isClosed()) {
            inst = new frmReserva();
            escritorio.add(inst);
        }

        inst.setVisible(true);
    }//GEN-LAST:event_abrirFrmReserva

    private void menuSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSalirMousePressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_menuSalirMousePressed

    private void abrirFrmProducto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirFrmProducto
        // TODO add your handling code here:
        frmProducto inst= null;

        if (inst == null || inst.isClosed()) {
            inst = new frmProducto();
            escritorio.add(inst);
        }

        inst.setVisible(true);
    }//GEN-LAST:event_abrirFrmProducto

    private void menuHospedarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHospedarActionPerformed
        // TODO add your handling code here:
        frmHospedaje inst= null;

        if (inst == null || inst.isClosed()) {
            inst = new frmHospedaje();
            escritorio.add(inst);
        }

        inst.setVisible(true);
    }//GEN-LAST:event_menuHospedarActionPerformed

    private void menuHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHabitacionActionPerformed
        // TODO add your handling code here:
        frmHabitacion inst= null;

        if (inst == null || inst.isClosed()) {
            inst = new frmHabitacion();
            escritorio.add(inst);
        }

        inst.setVisible(true);
    }//GEN-LAST:event_menuHabitacionActionPerformed

    private void menuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuariosActionPerformed
        // TODO add your handling code here:
        frmExportar inst= null;

        if (inst == null || inst.isClosed()) {
            inst = new frmExportar();
            escritorio.add(inst);
        }

        inst.setVisible(true);
    }//GEN-LAST:event_menuUsuariosActionPerformed

    private void menuPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPagosActionPerformed
        // TODO add your handling code here:
        frmCompra inst= null;

        if (inst == null || inst.isClosed()) {
            inst = new frmCompra();
            escritorio.add(inst);
        }

        inst.setVisible(true);
    }//GEN-LAST:event_menuPagosActionPerformed

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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JLabel lblRecepcionista;
    private javax.swing.JMenuItem menuClientes;
    private javax.swing.JMenuItem menuHabitacion;
    private javax.swing.JMenuItem menuHospedar;
    private javax.swing.JMenuItem menuPagos;
    private javax.swing.JMenuItem menuProductos;
    private javax.swing.JMenuItem menuReservas;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JMenuItem menuUsuarios;
    // End of variables declaration//GEN-END:variables
}