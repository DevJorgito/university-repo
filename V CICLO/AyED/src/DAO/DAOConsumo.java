/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Consumo;
import Classes.Conexion;
import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DAOConsumo {

    public double totalconsumo;

    public List<Consumo> listarConsumosPorReserva(String idReserva) {
        List<Consumo> listaConsumos = new ArrayList<>();
        String sql = "SELECT c.idconsumo, c.idreserva, c.idproducto, p.nombre AS nombre_producto, "
                + "c.cantidad, c.precio_venta AS precio_venta, c.estado "
                + "FROM consumo c INNER JOIN producto p ON c.idproducto = p.idproducto "
                + "WHERE c.idreserva = ? ORDER BY c.idconsumo DESC";

        try {
            Conexion cn = new Conexion();
            PreparedStatement ps = cn.getConnection().prepareStatement(sql);
            ps.setString(1, idReserva);
            ResultSet rs = ps.executeQuery();

            totalconsumo = 0.0;
            while (rs.next()) {
                Consumo consumo = new Consumo(
                        rs.getInt("idconsumo"),
                        rs.getInt("idreserva"),
                        rs.getInt("idproducto"),
                        rs.getBigDecimal("cantidad"),
                        rs.getBigDecimal("precio_venta"),
                        rs.getString("estado")
                );
                totalconsumo += rs.getDouble("cantidad") * rs.getDouble("precio_venta");

                listaConsumos.add(consumo);
            }

            cn.getConnection().close();

        } catch (Exception e) {
            System.err.println("Error al listar consumos por reserva: " + e.getMessage());
        }

        return listaConsumos;
    }

    public boolean Guardar(Consumo consumo) {
        boolean exito = false;
        String sql = "INSERT INTO consumo (idreserva, idproducto, cantidad, precio_venta, estado) VALUES (?, ?, ?, ?, ?)";

        try {
            Conexion cn = new Conexion();
            PreparedStatement ps = cn.getConnection().prepareStatement(sql);

            ps.setInt(1, consumo.getIdReserva());
            ps.setInt(2, consumo.getIdProducto());
            ps.setBigDecimal(3, consumo.getCantidad());
            ps.setBigDecimal(4, consumo.getPrecioVenta());
            ps.setString(5, consumo.getEstado());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                exito = true;
            }

            ps.close();
            cn.getConnection().close();

        } catch (Exception e) {
            System.err.println("Error al guardar el consumo: " + e.getMessage());
        }

        return exito;
    }

    public void Actualizar(Consumo consumo) {
        try {
            Conexion cn = new Conexion();
            String query = "UPDATE consumo SET idReserva = ?, idProducto = ?, cantidad = ?, precio_venta = ?, estado = ? WHERE idConsumo = ?";
            PreparedStatement ps = cn.getConnection().prepareStatement(query);

            ps.setInt(1, consumo.getIdReserva());
            ps.setInt(2, consumo.getIdProducto());
            ps.setBigDecimal(3, consumo.getCantidad());
            ps.setBigDecimal(4, consumo.getPrecioVenta());
            ps.setString(5, consumo.getEstado());
            ps.setInt(6, consumo.getIdConsumo());

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Consumo actualizado correctamente.");
            } else {
                System.out.println("No se encontró consumo para actualizar.");
            }

            ps.close();
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error al actualizar consumo: " + e.getMessage());
        }
    }

    public Consumo Leer(int idConsumo) {
        Consumo consumo = null;
        try {
            Conexion cn = new Conexion();
            CallableStatement proc = cn.getConnection().prepareCall("{call pr_LeerConsumo(?)}");
            proc.setInt(1, idConsumo);
            ResultSet rs = proc.executeQuery();
            if (rs.next()) {
                consumo = new Consumo(
                        rs.getInt("idConsumo"),
                        rs.getInt("idReserva"),
                        rs.getInt("idProducto"),
                        rs.getBigDecimal("cantidad"),
                        rs.getBigDecimal("precio_venta"),
                        rs.getString("estado")
                );
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return consumo;
    }

    public boolean Eliminar(int idConsumo) {
        try {
            Conexion cn = new Conexion();
            String sql = "DELETE FROM consumo WHERE idconsumo = ?";
            PreparedStatement ps = cn.getConnection().prepareStatement(sql);
            ps.setInt(1, idConsumo);

            int rowsDeleted = ps.executeUpdate();

            ps.close();
            cn.getConnection().close();

            return rowsDeleted > 0;

        } catch (Exception e) {
            System.err.println("Error al eliminar el consumo: " + e.getMessage());
            return false;
        }
    }

    public List<Consumo> listarConsumosPendientesPorReserva(int idReserva) {
        List<Consumo> consumos = new ArrayList<>();
        Conexion cn = new Conexion();

        try (Connection conn = cn.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM consumo WHERE idReserva = ? AND estado = 'Pendiente'")) {

            stmt.setInt(1, idReserva);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int idConsumo = rs.getInt("idConsumo");
                    int idProducto = rs.getInt("idProducto");
                    BigDecimal cantidad = rs.getBigDecimal("cantidad");
                    BigDecimal precioVenta = rs.getBigDecimal("precio_venta");
                    String estado = rs.getString("estado");

                    Consumo consumo = new Consumo(idConsumo, idReserva, idProducto, cantidad, precioVenta, estado);
                    consumos.add(consumo);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar consumos pendientes por reserva: " + e.getMessage());
        }

        return consumos;
    }

}
