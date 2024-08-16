/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Pago;
import Classes.Conexion;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DAOPago {

    public List<Pago> ListarPagos() {
        List<Pago> listaPagos = new LinkedList<>();
        try {
            Conexion cn = new Conexion();
            CallableStatement proc = cn.getConnection().prepareCall("{call pr_ListarPagos()}");
            ResultSet rs = proc.executeQuery();
            while (rs.next()) {
                Pago pago = new Pago(
                        rs.getInt("idPago"),
                        rs.getInt("idReserva"),
                        rs.getString("tipo_comprobante"),
                        rs.getString("num_comprobante"),
                        rs.getBigDecimal("igv"),
                        rs.getBigDecimal("total_pago"),
                        rs.getDate("fecha_emision"),
                        rs.getDate("fecha_pago")
                );
                listaPagos.add(pago);
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return listaPagos;
    }

    public void Guardar(Pago pago) {
        try {
            Conexion cn = new Conexion();
            String query = "INSERT INTO pago (idReserva, tipo_comprobante, num_comprobante, igv, total_pago, fecha_emision, fecha_pago) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cn.getConnection().prepareStatement(query);
            ps.setInt(1, pago.getIdReserva());
            ps.setString(2, pago.getTipoComprobante());
            ps.setString(3, pago.getNumComprobante());
            ps.setBigDecimal(4, pago.getIgv());
            ps.setBigDecimal(5, pago.getTotalPago());
            ps.setDate(6, new java.sql.Date(pago.getFechaEmision().getTime()));
            ps.setDate(7, new java.sql.Date(pago.getFechaPago().getTime()));
            ps.executeUpdate();

            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public void Actualizar(int idPago, Pago pago) {
        try {
            Conexion cn = new Conexion();
            String query = "UPDATE pago SET idReserva = ?, tipo_comprobante = ?, num_comprobante = ?, igv = ?, total_pago = ?, fecha_emision = ?, fecha_pago = ? WHERE idPago = ?";
            PreparedStatement ps = cn.getConnection().prepareStatement(query);
            ps.setInt(1, pago.getIdReserva());
            ps.setString(2, pago.getTipoComprobante());
            ps.setString(3, pago.getNumComprobante());
            ps.setBigDecimal(4, pago.getIgv());
            ps.setBigDecimal(5, pago.getTotalPago());
            ps.setDate(6, new java.sql.Date(pago.getFechaEmision().getTime()));
            ps.setDate(7, new java.sql.Date(pago.getFechaPago().getTime()));
            ps.setInt(8, idPago);
            ps.executeUpdate();

            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public Pago Leer(int idPago) {
        Pago pago = null;
        try {
            Conexion cn = new Conexion();
            CallableStatement proc = cn.getConnection().prepareCall("{call pr_LeerPago(?)}");
            proc.setInt(1, idPago);
            ResultSet rs = proc.executeQuery();
            if (rs.next()) {
                pago = new Pago(
                        rs.getInt("idPago"),
                        rs.getInt("idReserva"),
                        rs.getString("tipo_comprobante"),
                        rs.getString("num_comprobante"),
                        rs.getBigDecimal("igv"),
                        rs.getBigDecimal("total_pago"),
                        rs.getDate("fecha_emision"),
                        rs.getDate("fecha_pago")
                );
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return pago;
    }

    public void Eliminar(int idPago) {
        try {
            Conexion cn = new Conexion();
            CallableStatement proc = cn.getConnection().prepareCall("{call pr_EliminarPago(?)}");
            proc.setInt(1, idPago);
            proc.execute();
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
    
    
    
}
