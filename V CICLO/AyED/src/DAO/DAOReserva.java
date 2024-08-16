package DAO;

import Classes.Reserva;
import Classes.Conexion;
import Forms.frmVistaHospedaje;
import Forms.frmVistaReserva;
import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.sql.Types;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DAOReserva {

    public List<Reserva> ListarReservas() {
        List<Reserva> listaReservas = new LinkedList<>();
        try {
            Conexion cn = new Conexion();
            CallableStatement proc = cn.getConnection().prepareCall("{call pr_ListarReservas()}");
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                Reserva reserva = new Reserva(
                        rs.getInt("idReserva"),
                        rs.getInt("idCliente"),
                        rs.getInt("idHabitacion"),
                        rs.getDate("fechaLlegada").toLocalDate(),
                        rs.getDate("fechaSalida").toLocalDate(),
                        rs.getInt("numeroNoches"),
                        rs.getString("estadoR")
                );
                listaReservas.add(reserva);
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return listaReservas;
    }

    public void Guardar(Reserva reserva) {
        try {
            Conexion cn = new Conexion();
            String query = "INSERT INTO reserva (idCliente, idHabitacion, fechaLlegada, fechaSalida, numeroNoches, estadoR) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cn.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, reserva.getIdCliente());
            ps.setInt(2, reserva.getIdHabitacion());
            ps.setDate(3, Date.valueOf(reserva.getFechaLlegada()));
            ps.setDate(4, Date.valueOf(reserva.getFechaSalida()));
            ps.setInt(5, reserva.getNumeroNoches());
            ps.setString(6, reserva.getEstadoR());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idReserva = generatedKeys.getInt(1);
                reserva.setIdReserva(idReserva);
            }

            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public void Actualizar(Reserva reserva) {
        try {
            Conexion cn = new Conexion();
            String query = "UPDATE reserva SET idCliente = ?, idHabitacion = ?, fechaLlegada = ?, fechaSalida = ?, numeroNoches = ?, estadoR = ? WHERE idReserva = ?";
            PreparedStatement ps = cn.getConnection().prepareStatement(query);
            ps.setInt(1, reserva.getIdCliente());
            ps.setInt(2, reserva.getIdHabitacion());
            ps.setDate(3, Date.valueOf(reserva.getFechaLlegada()));
            ps.setDate(4, Date.valueOf(reserva.getFechaSalida()));
            ps.setInt(5, reserva.getNumeroNoches());
            ps.setString(6, reserva.getEstadoR());
            ps.setInt(7, reserva.getIdReserva());

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Reserva actualizada correctamente.");
            } else {
                System.out.println("No se encontró reserva para actualizar.");
            }

            ps.close();
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error al actualizar reserva: " + e.getMessage());
        }
    }

    public Reserva Leer(int idReserva) {
        Reserva reserva = null;
        try {
            Conexion cn = new Conexion();
            CallableStatement proc = cn.getConnection().prepareCall("{call pr_LeerReserva(?)}");
            proc.setInt(1, idReserva);
            ResultSet rs = proc.executeQuery();
            if (rs.next()) {
                reserva = new Reserva(
                        rs.getInt("idReserva"),
                        rs.getInt("idCliente"),
                        rs.getInt("idHabitacion"),
                        rs.getDate("fechaLlegada").toLocalDate(),
                        rs.getDate("fechaSalida").toLocalDate(),
                        rs.getInt("numeroNoches"),
                        rs.getString("estadoR")
                );
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return reserva;
    }

    public void Eliminar(int idReserva) {
        try {
            Conexion cn = new Conexion();
            CallableStatement proc = cn.getConnection().prepareCall("{call pr_EliminarReserva(?)}");
            proc.setInt(1, idReserva);
            proc.execute();
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public void mostrarReservaConDetalle(int idReserva, frmVistaReserva form) {
        try {
            Conexion cn = new Conexion();
            CallableStatement proc = cn.getConnection().prepareCall("{call pr_ListarReservaConDetallePorId(?)}");
            proc.setInt(1, idReserva);
            ResultSet rs = proc.executeQuery();

            if (rs.next()) {
                form.lblIdReserva.setText(String.valueOf(rs.getInt("idReserva")));
                form.lblNombreCliente.setText(rs.getString("nombreCliente"));
                form.lblNumeroHabitacion.setText(rs.getString("numeroHabitacion"));
                form.lblTipoHabitacion.setText(rs.getString("tipoHabitacion"));
                form.lblPrecioBaseHabitacion.setText(String.valueOf(rs.getBigDecimal("precioBaseHabitacion")));
                form.lblFechaLlegada.setText(rs.getDate("fechaLlegada").toString());
                form.lblFechaSalida.setText(rs.getDate("fechaSalida").toString());
                form.lblNumeroNoches.setText(String.valueOf(rs.getInt("numeroNoches")));
                form.lblEstadoReserva.setText(rs.getString("estadoR"));

                System.out.println("ID Reserva: " + rs.getInt("idReserva"));
                System.out.println("Cliente: " + rs.getString("nombreCliente"));
                // Agrega más salidas para verificar otros campos si es necesario
            } else {
                System.err.println("No se encontró la reserva con ID: " + idReserva);
            }

            // Cerrar recursos
            rs.close();
            proc.close();
            cn.getConnection().close();

        } catch (Exception e) {
            System.err.println("Error al listar reserva con detalle: " + e.getMessage());
        }
    }

    public void mostrarHospedajeConDetalle(int idReserva, frmVistaHospedaje form) {
        try {
            Conexion cn = new Conexion();
            CallableStatement proc = cn.getConnection().prepareCall("{call pr_ListarReservaConDetallePorId(?)}");
            proc.setInt(1, idReserva);
            ResultSet rs = proc.executeQuery();

            if (rs.next()) {
                form.lblIdReserva.setText(String.valueOf(rs.getInt("idReserva")));
                form.lblNombreCliente.setText(rs.getString("nombreCliente"));
                form.lblNumeroHabitacion.setText(rs.getString("numeroHabitacion"));
                form.lblTipoHabitacion.setText(rs.getString("tipoHabitacion"));
                form.lblPrecioBaseHabitacion.setText(String.valueOf(rs.getBigDecimal("precioBaseHabitacion")));
                form.lblFechaLlegada.setText(rs.getDate("fechaLlegada").toString());
                form.lblFechaSalida.setText(rs.getDate("fechaSalida").toString());
                form.lblNumeroNoches.setText(String.valueOf(rs.getInt("numeroNoches")));
                form.lblEstadoReserva.setText(rs.getString("estadoR"));

                System.out.println("ID Reserva: " + rs.getInt("idReserva"));
                System.out.println("Cliente: " + rs.getString("nombreCliente"));
            } else {
                System.err.println("No se encontró la reserva con ID: " + idReserva);
            }

            // Cerrar recursos
            rs.close();
            proc.close();
            cn.getConnection().close();

        } catch (Exception e) {
            System.err.println("Error al listar reserva con detalle: " + e.getMessage());
        }
    }

    public List<Reserva> cargarHospedajesDirectos() {
        List<Reserva> listaHospedajesDirectos = new LinkedList<>();
        try {
            Conexion cn = new Conexion();
            String query = "SELECT idReserva, idCliente, idHabitacion, fechaLlegada, fechaSalida, numeroNoches, estadoR "
                    + "FROM reserva "
                    + "WHERE estadoR IN ('Hospedaje', 'Hospedaje-Pagado') "
                    + "AND fechaSalida >= CURDATE()";
            PreparedStatement ps = cn.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva(
                        rs.getInt("idReserva"),
                        rs.getInt("idCliente"),
                        rs.getInt("idHabitacion"),
                        rs.getDate("fechaLlegada").toLocalDate(),
                        rs.getDate("fechaSalida").toLocalDate(),
                        rs.getInt("numeroNoches"),
                        rs.getString("estadoR")
                );
                listaHospedajesDirectos.add(reserva);
            }

            rs.close();
            ps.close();
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error al cargar hospedajes directos: " + e.getMessage());
        }
        return listaHospedajesDirectos;
    }

    public BigDecimal calcularCostoTotalReserva(int idReserva) {
        BigDecimal costoTotal = BigDecimal.ZERO;
        try {
            Conexion cn = new Conexion();
            String sql = "SELECT r.numeroNoches, h.precioBase FROM reserva r INNER JOIN habitacion h ON r.idHabitacion = h.idHabitacion WHERE r.idReserva = ?";
            PreparedStatement pst = cn.getConnection().prepareStatement(sql);
            pst.setInt(1, idReserva);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int numeroNoches = rs.getInt("numeroNoches");
                BigDecimal precioBase = rs.getBigDecimal("precioBase");
                costoTotal = precioBase.multiply(BigDecimal.valueOf(numeroNoches));
            }

            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return costoTotal;
    }

    public String obtenerNombreCliente(int idReserva) {
        String nombreCliente = null;
        try {
            Conexion cn = new Conexion();
            String query = "SELECT p.nombres, p.apellidos "
                    + "FROM reserva r "
                    + "JOIN cliente c ON r.idCliente = c.idCliente "
                    + "JOIN persona p ON c.idPersona = p.idPersona "
                    + "WHERE r.idReserva = ?";
            PreparedStatement ps = cn.getConnection().prepareStatement(query);
            ps.setInt(1, idReserva);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                nombreCliente = nombres + " " + apellidos;
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return nombreCliente;
    }

    public BigDecimal calcularTotalConsumos(int idReserva) {
        BigDecimal totalConsumos = BigDecimal.ZERO;

        try {
            Conexion cn = new Conexion();
            Connection conn = cn.getConnection();
            CallableStatement proc = conn.prepareCall("{CALL pr_CalcularTotalConsumos(?, ?)}");
            proc.setInt(1, idReserva);
            proc.registerOutParameter(2, Types.DECIMAL);

            proc.execute();
            totalConsumos = proc.getBigDecimal(2);

            conn.close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        return totalConsumos;
    }

    public void actualizarEstado(int idReserva, String nuevoEstado) {
        Conexion cn = new Conexion();

        try (Connection conn = cn.getConnection(); CallableStatement proc = conn.prepareCall("{CALL pr_ActualizarEstadoReserva(?, ?)}")) {

            proc.setInt(1, idReserva);
            proc.setString(2, nuevoEstado);

            proc.executeUpdate();

            System.out.println("Estado de la reserva actualizado correctamente a " + nuevoEstado);
        } catch (Exception e) {
            System.err.println("Error al actualizar el estado de la reserva: " + e.getMessage());
        } finally {
            try {
                if (cn != null && cn.getConnection() != null) {
                    cn.getConnection().close(); // Cerrar la conexión
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public Reserva obtenerReservaPorId(int idReserva) throws SQLException {
        Reserva reserva = null;
        Conexion cn = new Conexion();

        try (Connection conn = cn.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT idReserva, idCliente, idHabitacion, fechaLlegada, fechaSalida, numeroNoches, estadoR "
                + "FROM reserva "
                + "WHERE idReserva = ?")) {
            stmt.setInt(1, idReserva);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    reserva = new Reserva(
                            rs.getInt("idReserva"),
                            rs.getInt("idCliente"),
                            rs.getInt("idHabitacion"),
                            rs.getDate("fechaLlegada").toLocalDate(),
                            rs.getDate("fechaSalida").toLocalDate(),
                            rs.getInt("numeroNoches"),
                            rs.getString("estadoR")
                    );
                }
            }
        } catch (Exception e) {
            System.err.println("Error al obtener la reserva: " + e.getMessage());
        } finally {
            cn.getConnection().close(); // Cerrar la conexión
        }

        return reserva;
    }

    public String obtenerEstadoReserva(int idReserva) throws SQLException {
        String estado = "";
        Conexion cn = new Conexion();

        try (Connection conn = cn.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT estadoR FROM reserva WHERE idReserva = ?")) {

            stmt.setInt(1, idReserva);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                estado = rs.getString("estadoR");
            } else {
                throw new SQLException("No se encontró la reserva con ID: " + idReserva);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el estado de la reserva: " + e.getMessage());
            throw e;
        } finally {
            cn.getConnection().close(); // Cerrar la conexión
        }

        return estado;
    }

    public List<Reserva> ListarReservasPorClienteYEstado(int idCliente, String estado) {
        List<Reserva> reservas = new ArrayList<>();
        Conexion cn = new Conexion();

        try (Connection conn = cn.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reserva WHERE idCliente = ? AND estadoR = ?")) {

            stmt.setInt(1, idCliente);
            stmt.setString(2, estado);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int idReserva = rs.getInt("idReserva");
                    int idHabitacion = rs.getInt("idHabitacion");
                    LocalDate fechaLlegada = rs.getDate("fechaLlegada").toLocalDate();
                    LocalDate fechaSalida = rs.getDate("fechaSalida").toLocalDate();
                    int numeroNoches = rs.getInt("numeroNoches");
                    String estadoR = rs.getString("estadoR");

                    Reserva reserva = new Reserva(idReserva, idHabitacion, idCliente, fechaLlegada, fechaSalida, numeroNoches, estadoR);
                    reservas.add(reserva);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar reservas por cliente y estado: " + e.getMessage());
        }

        return reservas;
    }

    public List<Reserva> listarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        Conexion cn = new Conexion(); // Usa la misma clase de conexión que en tu otro método

        String sql = "SELECT * FROM reserva"; // Consulta para obtener todas las reservas

        try (Connection conn = cn.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idReserva = rs.getInt("idReserva");
                int idCliente = rs.getInt("idCliente");
                int idHabitacion = rs.getInt("idHabitacion");
                LocalDate fechaLlegada = rs.getDate("fechaLlegada").toLocalDate();
                LocalDate fechaSalida = rs.getDate("fechaSalida").toLocalDate();
                int numeroNoches = rs.getInt("numeroNoches");
                String estadoR = rs.getString("estadoR");

                Reserva reserva = new Reserva(idReserva, idCliente, idHabitacion, fechaLlegada, fechaSalida, numeroNoches, estadoR);
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar todas las reservas: " + e.getMessage());
        }

        return reservas;
    }

}
