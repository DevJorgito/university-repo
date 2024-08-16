/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import Classes.Reserva;
import DAO.DAOHabitacion;
import DAO.DAOReserva;
import static Forms.frmMain.escritorio;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
public class frmHospedaje extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmHospedaje
     */
    String[] Cabecera = {"Id Reserva", "Id Habitación", "Id Cliente", "Fecha de Llegada", "Fecha de Salida", "Número de Noches", "Estado"};

    DefaultTableModel DTM;
    DAOReserva DAO = new DAOReserva();
    List<Reserva> LH = new LinkedList<>();
    TableRowSorter<DefaultTableModel> Filtro;

    public frmHospedaje() {
        initComponents();
        RecuperarDesdeBD();
        inhabilitar();
        setFechaLlegada();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        txtcliente = new javax.swing.JTextField();
        txtnoches = new javax.swing.JTextField();
        buscarHabitacion = new javax.swing.JButton();
        BuscarCliente = new javax.swing.JButton();
        datFechaL = new com.toedter.calendar.JDateChooser();
        datFechaS = new com.toedter.calendar.JDateChooser();
        cmbEstado = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtidreserva = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        txtidhabitacion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHospedaje = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtfiltrar = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        btnConsumos = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnPago = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtnumero1 = new javax.swing.JTextField();
        txtcliente1 = new javax.swing.JTextField();
        txtnoches1 = new javax.swing.JTextField();
        buscarHabitacion1 = new javax.swing.JButton();
        BuscarCliente1 = new javax.swing.JButton();
        datFechaL1 = new com.toedter.calendar.JDateChooser();
        datFechaS1 = new com.toedter.calendar.JDateChooser();
        cmbEstado1 = new javax.swing.JComboBox<>();
        btnNuevo1 = new javax.swing.JButton();
        btnRegistrar1 = new javax.swing.JButton();
        txtidreserva1 = new javax.swing.JTextField();
        txtidcliente1 = new javax.swing.JTextField();
        txtidhabitacion1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHospedaje1 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtfiltrar1 = new javax.swing.JTextField();
        btnSeleccionar1 = new javax.swing.JButton();
        btnConsumos1 = new javax.swing.JButton();
        btnCerrar1 = new javax.swing.JButton();
        btnPago1 = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 246, 178));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Hospedaje"));

        jLabel1.setText("Habitación:");

        jLabel2.setText("Fecha Salida:");

        jLabel3.setText("Cliente:");

        jLabel4.setText("Fecha Llegada:");

        jLabel5.setText("Número de Noches:");

        jLabel6.setText("Estado:");

        buscarHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupita.png"))); // NOI18N
        buscarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarHabitacionActionPerformed(evt);
            }
        });

        BuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupita.png"))); // NOI18N
        BuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarClienteActionPerformed(evt);
            }
        });

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hospedaje" }));

        btnNuevo.setBackground(new java.awt.Color(244, 245, 244));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/guardar.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorderPainted(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(244, 245, 244));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/guardar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(39, 39, 39)
                        .addComponent(datFechaL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnumero)
                                    .addComponent(txtcliente))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buscarHabitacion, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(txtnoches))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(datFechaS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnNuevo)
                        .addGap(27, 27, 27)
                        .addComponent(btnRegistrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarHabitacion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(datFechaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(datFechaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtnoches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnRegistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(165, 229, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Hospedajes"));

        tablaHospedaje.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaHospedaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaHospedajeMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaHospedaje);

        jLabel7.setText("Filtrar:");

        txtfiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfiltrarKeyReleased(evt);
            }
        });

        btnSeleccionar.setBackground(new java.awt.Color(244, 245, 244));
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/seleccione.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setBorderPainted(false);
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnConsumos.setBackground(new java.awt.Color(244, 245, 244));
        btnConsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/consumismo.png"))); // NOI18N
        btnConsumos.setText("Consumos");
        btnConsumos.setBorderPainted(false);
        btnConsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsumosActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(244, 245, 244));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setBorderPainted(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnPago.setBackground(new java.awt.Color(244, 245, 244));
        btnPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pago.png"))); // NOI18N
        btnPago.setText("Realizar Pago");
        btnPago.setBorderPainted(false);
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(244, 245, 244));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorderPainted(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnConsumos)
                .addGap(29, 29, 29)
                .addComponent(btnPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(btnSeleccionar)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addGap(17, 17, 17))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtfiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsumos)
                    .addComponent(btnPago)
                    .addComponent(btnSeleccionar)
                    .addComponent(btnModificar))
                .addContainerGap())
        );

        jInternalFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 246, 178));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Hospedaje"));

        jLabel8.setText("Habitación:");

        jLabel9.setText("Fecha Salida:");

        jLabel10.setText("Cliente:");

        jLabel11.setText("Fecha Llegada:");

        jLabel12.setText("Número de Noches:");

        jLabel13.setText("Estado:");

        buscarHabitacion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupita.png"))); // NOI18N
        buscarHabitacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarHabitacion1ActionPerformed(evt);
            }
        });

        BuscarCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupita.png"))); // NOI18N
        BuscarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarCliente1ActionPerformed(evt);
            }
        });

        cmbEstado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hospedaje" }));

        btnNuevo1.setBackground(new java.awt.Color(244, 245, 244));
        btnNuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N
        btnNuevo1.setText("Nuevo");
        btnNuevo1.setBorderPainted(false);
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });

        btnRegistrar1.setBackground(new java.awt.Color(244, 245, 244));
        btnRegistrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/guardar.png"))); // NOI18N
        btnRegistrar1.setText("Registrar");
        btnRegistrar1.setBorderPainted(false);
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(39, 39, 39)
                        .addComponent(datFechaL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnumero1)
                                    .addComponent(txtcliente1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buscarHabitacion1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BuscarCliente1, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(cmbEstado1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(txtnoches1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(datFechaS1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(35, 35, 35))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnNuevo1)
                        .addGap(27, 27, 27)
                        .addComponent(btnRegistrar1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(txtidreserva1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(txtidcliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txtidhabitacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarHabitacion1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtnumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BuscarCliente1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtcliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(datFechaL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(datFechaS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtnoches1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo1)
                    .addComponent(btnRegistrar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidcliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidreserva1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidhabitacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(165, 229, 248));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Hospedajes"));

        tablaHospedaje1.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaHospedaje1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaHospedaje1MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablaHospedaje1);

        jLabel14.setText("Filtrar:");

        txtfiltrar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfiltrar1KeyReleased(evt);
            }
        });

        btnSeleccionar1.setBackground(new java.awt.Color(244, 245, 244));
        btnSeleccionar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/seleccione.png"))); // NOI18N
        btnSeleccionar1.setText("Seleccionar");
        btnSeleccionar1.setBorderPainted(false);
        btnSeleccionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionar1ActionPerformed(evt);
            }
        });

        btnConsumos1.setBackground(new java.awt.Color(244, 245, 244));
        btnConsumos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/consumismo.png"))); // NOI18N
        btnConsumos1.setText("Consumos");
        btnConsumos1.setBorderPainted(false);
        btnConsumos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsumos1ActionPerformed(evt);
            }
        });

        btnCerrar1.setBackground(new java.awt.Color(244, 245, 244));
        btnCerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar.png"))); // NOI18N
        btnCerrar1.setText("Cerrar");
        btnCerrar1.setBorderPainted(false);
        btnCerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar1ActionPerformed(evt);
            }
        });

        btnPago1.setBackground(new java.awt.Color(244, 245, 244));
        btnPago1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pago.png"))); // NOI18N
        btnPago1.setText("Realizar Pago");
        btnPago1.setBorderPainted(false);
        btnPago1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPago1ActionPerformed(evt);
            }
        });

        btnModificar1.setBackground(new java.awt.Color(244, 245, 244));
        btnModificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editar.png"))); // NOI18N
        btnModificar1.setText("Modificar");
        btnModificar1.setBorderPainted(false);
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnConsumos1)
                .addGap(29, 29, 29)
                .addComponent(btnPago1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(btnSeleccionar1)
                .addGap(18, 18, 18)
                .addComponent(btnModificar1)
                .addGap(17, 17, 17))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfiltrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar1)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtfiltrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsumos1)
                    .addComponent(btnPago1)
                    .addComponent(btnSeleccionar1)
                    .addComponent(btnModificar1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setFechaLlegada(){
        Date fechaActual= new Date();
        datFechaL.setDate(fechaActual);
        datFechaL.setEnabled(false);
    }
    
    public void RecuperarDesdeBD() {
        LH = DAO.cargarHospedajesDirectos();
        DTM = new DefaultTableModel(null, Cabecera);
        for (Reserva R : LH) {
            DTM.addRow(R.Convertir());
        }
        tablaHospedaje.setModel(DTM);
        Filtro = new TableRowSorter(DTM);
        tablaHospedaje.setRowSorter(Filtro);

        Configuracion();
    }

    public void Configuracion() {
        //esconder la columna ID
        tablaHospedaje.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaHospedaje.getColumnModel().getColumn(0).setMinWidth(0);
        tablaHospedaje.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablaHospedaje.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaHospedaje.getColumnModel().getColumn(1).setMinWidth(0);
        tablaHospedaje.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablaHospedaje.getColumnModel().getColumn(2).setMaxWidth(0);
        tablaHospedaje.getColumnModel().getColumn(2).setMinWidth(0);
        tablaHospedaje.getColumnModel().getColumn(2).setPreferredWidth(0);
    }

    private void inhabilitar() {
        txtidcliente.setVisible(false);
        txtidhabitacion.setVisible(false);
        txtidreserva.setVisible(false);
        txtnumero.setEnabled(false);
        txtcliente.setEnabled(false);
        
        
    }

    private void buscarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarHabitacionActionPerformed
        // TODO add your handling code here:
        frmVistaHabitacionH form = new frmVistaHabitacionH();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_buscarHabitacionActionPerformed


    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        LimpiarControles();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private boolean Validar() {
        if (txtidhabitacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione una habitación");
            txtidhabitacion.requestFocus();
            return false;
        }
        if (txtidcliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente");
            txtidcliente.requestFocus();
            return false;
        }
        if (datFechaL.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Seleccione una fecha de llegada");
            datFechaL.requestFocus();
            return false;
        }
        if (datFechaS.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Seleccione una fecha de salida");
            datFechaS.requestFocus();
            return false;
        }
        if (txtnoches.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escriba la cantidad de noches");
            txtnoches.requestFocus();
            return false;
        }
        if (cmbEstado.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un estado");
            cmbEstado.requestFocus();
            return false;
        }
        return true;
    }

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        if (Validar() == false) {
            JOptionPane.showMessageDialog(null, "Falta ingresar datos");
            return;
        }

        if (JOptionPane.showConfirmDialog(rootPane, "¿Realmente desea continuar?", "Agregar Reserva", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }

        int idHabitacion = Integer.parseInt(txtidhabitacion.getText());
        int idCliente = Integer.parseInt(txtidcliente.getText());
        LocalDate fechaLlegada = datFechaL.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaSalida = datFechaS.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int numeroNoches = Integer.parseInt(txtnoches.getText());
        String estado = cmbEstado.getSelectedItem().toString();

        Reserva reserva = new Reserva(0, idHabitacion, idCliente, fechaLlegada, fechaSalida, numeroNoches, estado);
        DAO.Guardar(reserva);

        DAOHabitacion daoHabitacion = new DAOHabitacion();
        daoHabitacion.actualizarEstadoHabitacion(idHabitacion, "Ocupada");

        JOptionPane.showMessageDialog(null, "Hospedaje registrado y habitación actualizada a ocupada.");

        LimpiarControles();
        RecuperarDesdeBD();

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tablaHospedaje.getSelectedRow();

        int columnaId = 0;

        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila", "Resultado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idReserva = Integer.parseInt(tablaHospedaje.getValueAt(filaSeleccionada, columnaId).toString());
        Reserva reserva = DAO.Leer(idReserva);

        if (reserva != null) {
            txtidreserva.setText(String.valueOf(reserva.getIdReserva()));
            txtidhabitacion.setText(String.valueOf(reserva.getIdHabitacion()));
            txtidcliente.setText(String.valueOf(reserva.getIdCliente()));
            Date fechaLlegada = Date.from(reserva.getFechaLlegada().atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date fechaSalida = Date.from(reserva.getFechaSalida().atStartOfDay(ZoneId.systemDefault()).toInstant());
            datFechaL.setDate(fechaLlegada);
            datFechaS.setDate(fechaSalida);
            txtnoches.setText(String.valueOf(reserva.getNumeroNoches()));
            cmbEstado.setSelectedItem(reserva.getEstadoR());
        }


    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnConsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsumosActionPerformed
        // TODO add your handling code here:
        int fila = tablaHospedaje.getSelectedRow();

        frmConsumo.idreserva = tablaHospedaje.getValueAt(fila, 0).toString();
        frmConsumo.cliente = tablaHospedaje.getValueAt(fila, 2).toString();

        frmConsumo form = new frmConsumo();
        frmMain.escritorio.add(form);
        form.toFront();
        form.setVisible(true);

    }//GEN-LAST:event_btnConsumosActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed
        // TODO add your handling code here:
        int fila = tablaHospedaje.getSelectedRow();
        int columnaId = 0;

        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila", "Resultado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idReserva = Integer.parseInt(tablaHospedaje.getValueAt(fila, columnaId).toString());
        Reserva reserva = DAO.Leer(idReserva);

        if (reserva != null) {
            txtidreserva.setText(String.valueOf(reserva.getIdReserva()));
        }

        idReserva = Integer.parseInt(txtidreserva.getText());

        BigDecimal costoTotal = DAO.calcularCostoTotalReserva(idReserva);
        String nombreCliente = DAO.obtenerNombreCliente(idReserva);
        BigDecimal totalConsumos = DAO.calcularTotalConsumos(idReserva);

        // Calcular subtotal, IGV y total a pagar
        BigDecimal subtotal = costoTotal.add(totalConsumos);
        BigDecimal igv = subtotal.multiply(BigDecimal.valueOf(0.18));
        BigDecimal totalPagar = subtotal.add(igv);

        DecimalFormat df = new DecimalFormat("#.00");
        
        // Abrir el formulario de pago y establecer los valores
        frmPago inst = new frmPago();
        frmMain.escritorio.add(inst);
        inst.toFront();
        inst.setVisible(true);

        inst.lblCostoTotal.setText(df.format(costoTotal));
        inst.txtidreserva.setText(String.valueOf(idReserva));
        inst.txtcliente.setText(nombreCliente);
        inst.lblTotalConsumos.setText(df.format(totalConsumos));
        inst.txtigv.setText(df.format(igv));
        inst.txtTotalPago.setText(df.format(totalPagar));
        
    }//GEN-LAST:event_btnPagoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (Validar() == false) {
            JOptionPane.showMessageDialog(null, "Falta ingresar datos");
            return;
        }

        int ID_Recuperado = Integer.parseInt(txtidreserva.getText());

        int idReserva = ID_Recuperado;
        int idHabitacion = Integer.parseInt(txtidhabitacion.getText());
        int idCliente = Integer.parseInt(txtidcliente.getText());
        LocalDate fechaLlegada = datFechaL.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaSalida = datFechaS.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int numeroNoches = Integer.parseInt(txtnoches.getText());
        String estado = cmbEstado.getSelectedItem().toString();

        Reserva reserva = new Reserva(idReserva, idCliente, idHabitacion, fechaLlegada, fechaSalida, numeroNoches, estado);
        DAO.Actualizar(reserva);

        JOptionPane.showMessageDialog(null, "Reserva Actualizada Correctamente");

        LimpiarControles();
        RecuperarDesdeBD();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtfiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltrarKeyReleased
        // TODO add your handling code here:
        Filtrar();
    }//GEN-LAST:event_txtfiltrarKeyReleased

    private void BuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarClienteActionPerformed
        // TODO add your handling code here:
        frmVistaClienteH form = new frmVistaClienteH();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_BuscarClienteActionPerformed

    private void tablaHospedajeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaHospedajeMousePressed
        // TODO add your handling code here:
        tablaHospedaje.setDefaultEditor(Object.class, null);
        if (evt.getClickCount() == 2) { // Detecta doble clic
            int filaSeleccionada = tablaHospedaje.getSelectedRow();
            if (filaSeleccionada != -1) {
                String cod = tablaHospedaje.getValueAt(filaSeleccionada, 0).toString();
                System.out.println("ID de reserva seleccionado: " + cod);
                frmHospedaje.txtidreserva.setText(cod);

                try {
                    int idReserva = Integer.parseInt(cod);

                    frmVistaHospedaje inst = new frmVistaHospedaje();

                    DAO.mostrarHospedajeConDetalle(idReserva, inst);

                    escritorio.add(inst);
                    inst.toFront();
                    inst.setVisible(true);

                } catch (NumberFormatException e) {
                    System.err.println("Error al convertir ID de reserva a entero: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_tablaHospedajeMousePressed

    private void buscarHabitacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarHabitacion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarHabitacion1ActionPerformed

    private void BuscarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarCliente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarCliente1ActionPerformed

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevo1ActionPerformed

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrar1ActionPerformed

    private void tablaHospedaje1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaHospedaje1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaHospedaje1MousePressed

    private void txtfiltrar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltrar1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfiltrar1KeyReleased

    private void btnSeleccionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionar1ActionPerformed

    private void btnConsumos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsumos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsumos1ActionPerformed

    private void btnCerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrar1ActionPerformed

    private void btnPago1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPago1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPago1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void LimpiarControles() {
        txtidhabitacion.setText("");
        txtidcliente.setText("");
        datFechaL.setDate(null);
        datFechaS.setDate(null);
        txtnoches.setText("");
        cmbEstado.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(frmHospedaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHospedaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHospedaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHospedaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHospedaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarCliente;
    private javax.swing.JButton BuscarCliente1;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCerrar1;
    private javax.swing.JButton btnConsumos;
    private javax.swing.JButton btnConsumos1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnPago;
    private javax.swing.JButton btnPago1;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnSeleccionar1;
    private javax.swing.JButton buscarHabitacion;
    private javax.swing.JButton buscarHabitacion1;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbEstado1;
    private com.toedter.calendar.JDateChooser datFechaL;
    private com.toedter.calendar.JDateChooser datFechaL1;
    private com.toedter.calendar.JDateChooser datFechaS;
    private com.toedter.calendar.JDateChooser datFechaS1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaHospedaje;
    private javax.swing.JTable tablaHospedaje1;
    public static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtcliente1;
    private javax.swing.JTextField txtfiltrar;
    private javax.swing.JTextField txtfiltrar1;
    public static javax.swing.JTextField txtidcliente;
    public static javax.swing.JTextField txtidcliente1;
    public static javax.swing.JTextField txtidhabitacion;
    public static javax.swing.JTextField txtidhabitacion1;
    public static javax.swing.JTextField txtidreserva;
    public static javax.swing.JTextField txtidreserva1;
    private javax.swing.JTextField txtnoches;
    private javax.swing.JTextField txtnoches1;
    public static javax.swing.JTextField txtnumero;
    public static javax.swing.JTextField txtnumero1;
    // End of variables declaration//GEN-END:variables
}
