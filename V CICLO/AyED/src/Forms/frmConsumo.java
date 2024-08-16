/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import Classes.Consumo;
import DAO.DAOConsumo;
import DAO.DAOReserva;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jorge
 */
public class frmConsumo extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmConsumo
     */
    public static String cliente;
    public static String idreserva;

    String[] Cabecera = {"Id Consumo", "Id Reserva", "Id Producto", "Cantidad", "Precio Venta", "Estado"};

    DefaultTableModel DTM;
    DAOConsumo DAO = new DAOConsumo();
    DAOReserva DaoR = new DAOReserva();
    List<Consumo> LC = new LinkedList<>();
    TableRowSorter<DefaultTableModel> Filtro;

    public frmConsumo() {
        initComponents();
        RecuperarDesdeBD();
        txtcliente.setText(cliente);
        txtidreserva.setText(idreserva);

        DecimalFormat df = new DecimalFormat("#.00");

        int idReserva = Integer.parseInt(txtidreserva.getText());

        BigDecimal totalConsumos = DaoR.calcularTotalConsumos(idReserva);

        String totalConsumoFormateado = df.format(totalConsumos);

        lbltotalregistros.setText(totalConsumoFormateado);

        inhabilitar();
    }

    public void RecuperarDesdeBD() {
        LC = DAO.listarConsumosPorReserva(idreserva);
        DTM = new DefaultTableModel(null, Cabecera);
        for (Consumo C : LC) {
            DTM.addRow(C.Convertir());
        }
        tablaConsumo.setModel(DTM);

        Filtro = new TableRowSorter(DTM); //necesario para filtrar
        tablaConsumo.setRowSorter(Filtro);  //necesario para filtrar

        Configuracion();
    }

    public void Configuracion() {
        tablaConsumo.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaConsumo.getColumnModel().getColumn(0).setMinWidth(0);
        tablaConsumo.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablaConsumo.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaConsumo.getColumnModel().getColumn(1).setMinWidth(0);
        tablaConsumo.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablaConsumo.getColumnModel().getColumn(2).setMaxWidth(0);
        tablaConsumo.getColumnModel().getColumn(2).setMinWidth(0);
        tablaConsumo.getColumnModel().getColumn(2).setPreferredWidth(0);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidreserva = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtidproducto = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        txtprecio_venta = new javax.swing.JTextField();
        comboEstado = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtcliente = new javax.swing.JTextField();
        txtproducto = new javax.swing.JTextField();
        txtidconsumo = new javax.swing.JTextField();
        LblConsumo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsumo = new javax.swing.JTable();
        txtfiltrar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbltotalregistros = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(203, 249, 232));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Consumos"));

        jLabel1.setText("Reserva:");

        jLabel2.setText("Producto:");

        Cantidad.setText("Cantidad:");

        jLabel4.setText("Precio Total:");

        jLabel3.setText("Estado:");

        txtidreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidreservaActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupita.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Producto(evt);
            }
        });

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aceptado", "Cancelado" }));

        btnNuevo.setBackground(new java.awt.Color(244, 245, 244));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(244, 245, 244));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(244, 245, 244));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelado.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Cantidad)
                                        .addComponent(jLabel2)))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtprecio_venta, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcantidad, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtcliente)
                                            .addComponent(txtproducto, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar)))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtidconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cantidad)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtprecio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LblConsumo.setBackground(new java.awt.Color(225, 249, 203));
        LblConsumo.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Consumos"));

        tablaConsumo.setBackground(new java.awt.Color(182, 226, 99));
        tablaConsumo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaConsumo);

        txtfiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfiltrarfiltrar(evt);
            }
        });

        jLabel10.setText("Filtrar:");

        btnCerrar.setBackground(new java.awt.Color(244, 245, 244));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel5.setText("Total de Consumos:");

        lbltotalregistros.setText("jLabel7");

        btnSeleccionar.setBackground(new java.awt.Color(244, 245, 244));
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/seleccione.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(244, 245, 244));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LblConsumoLayout = new javax.swing.GroupLayout(LblConsumo);
        LblConsumo.setLayout(LblConsumoLayout);
        LblConsumoLayout.setHorizontalGroup(
            LblConsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LblConsumoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(LblConsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(LblConsumoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalregistros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSeleccionar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LblConsumoLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtfiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        LblConsumoLayout.setVerticalGroup(
            LblConsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LblConsumoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(LblConsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnCerrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(LblConsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LblConsumoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(LblConsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(lbltotalregistros))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LblConsumoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(LblConsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSeleccionar)
                            .addComponent(btnModificar))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfiltrarfiltrar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltrarfiltrar
        Filtrar();
    }//GEN-LAST:event_txtfiltrarfiltrar

    private void Producto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Producto
        // TODO add your handling code here:
        frmVistaProducto form = new frmVistaProducto();
        form.toFront();
        form.setVisible(true);

    }//GEN-LAST:event_Producto

    private boolean Validar() {
        if (txtcliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente");
            txtcliente.requestFocus();
            return false;
        }
        if (txtcantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad");
            txtcantidad.requestFocus();
            return false;
        }
        if (txtprecio_venta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el precio de venta");
            txtprecio_venta.requestFocus();
            return false;
        }
        if (comboEstado.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un estado");
            comboEstado.requestFocus();
            return false;
        }
        return true;
    }


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try {
            int idReserva = Integer.parseInt(txtidreserva.getText().trim());

            String estadoR = DaoR.obtenerEstadoReserva(idReserva); // Método hipotético

            if (estadoR.equals("Hospedaje-Pagado")) {
                JOptionPane.showMessageDialog(this, "La reserva ya está pagada. Utilice el formulario frmCompra para agregar consumos adicionales.", "Reserva Pagada", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int idProducto = Integer.parseInt(txtidproducto.getText().trim());
            BigDecimal cantidad = new BigDecimal(txtcantidad.getText().trim());
            BigDecimal precioVenta = new BigDecimal(txtprecio_venta.getText().trim());
            String estado = "Aceptado";

            Consumo consumo = new Consumo(0, idReserva, idProducto, cantidad, precioVenta, estado);

            DAO.Guardar(consumo);

            JOptionPane.showMessageDialog(this, "Consumo registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            LimpiarControles();
            RecuperarDesdeBD();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en el formato de los datos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el consumo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtidreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidreservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidreservaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tablaConsumo.getSelectedRow();

        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila", "Resultado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el registro, ¿desea continuar?", "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }

        int idConsumo = Integer.parseInt(tablaConsumo.getValueAt(filaSeleccionada, 0).toString());

        if (DAO.Eliminar(idConsumo)) {
            JOptionPane.showMessageDialog(null, "Consumo eliminado correctamente", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            RecuperarDesdeBD();
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el consumo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        LimpiarControles();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int filaSeleccionada = tablaConsumo.getSelectedRow();
        int columnaId = 0;
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila", "Resultado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idConsumo = Integer.parseInt(tablaConsumo.getValueAt(filaSeleccionada, columnaId).toString());
        Consumo consumo = DAO.Leer(idConsumo);

        if (consumo != null) {
            txtidconsumo.setText(String.valueOf(consumo.getIdConsumo()));
            txtidreserva.setText(String.valueOf(consumo.getIdReserva()));
            txtidproducto.setText(String.valueOf(consumo.getIdProducto()));
            txtcantidad.setText(String.valueOf(consumo.getCantidad()));
            txtprecio_venta.setText(String.valueOf(consumo.getPrecioVenta()));
            comboEstado.setSelectedItem(consumo.getEstado());
        }

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (Validar() == false) {
            JOptionPane.showMessageDialog(null, "Falta ingresar datos");
            return;
        }

        int ID_Recuperado = Integer.parseInt(txtidconsumo.getText());

        int idConsumo = ID_Recuperado;

        int idReserva = Integer.parseInt(txtidreserva.getText());
        int idProducto = Integer.parseInt(txtidproducto.getText());
        BigDecimal cantidad = new BigDecimal(txtcantidad.getText());
        BigDecimal precioVenta = new BigDecimal(txtprecio_venta.getText());
        String estado = comboEstado.getSelectedItem().toString();

        Consumo consumo = new Consumo(idConsumo, idReserva, idProducto, cantidad, precioVenta, estado);

        DAO.Actualizar(consumo);
        JOptionPane.showMessageDialog(null, "Consumo Actualizado Correctamente");

        LimpiarControles();
        RecuperarDesdeBD();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void inhabilitar() {

        txtidproducto.setVisible(false);
        txtidconsumo.setVisible(false);
        txtidreserva.setVisible(false);
        txtcliente.setEnabled(false);
        txtproducto.setEnabled(false);
    }

    private void LimpiarControles() {
        txtcantidad.setText("");
        comboEstado.setSelectedIndex(0);
    }

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
            java.util.logging.Logger.getLogger(frmConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsumo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cantidad;
    private javax.swing.JPanel LblConsumo;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablaConsumo;
    private javax.swing.JTextField txtcantidad;
    public static javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtfiltrar;
    private javax.swing.JTextField txtidconsumo;
    public static javax.swing.JTextField txtidproducto;
    public static javax.swing.JTextField txtidreserva;
    public static javax.swing.JTextField txtprecio_venta;
    public static javax.swing.JTextField txtproducto;
    // End of variables declaration//GEN-END:variables
}
