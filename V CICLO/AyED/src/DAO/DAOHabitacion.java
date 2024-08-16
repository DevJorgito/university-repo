/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Habitacion;
import Classes.Conexion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DAOHabitacion {

    public List<Habitacion> ListarHabitaciones() {
    List<Habitacion> listaHabitaciones = new LinkedList<>();
    try {
        Conexion cn = new Conexion();
        CallableStatement proc = cn.getConnection().prepareCall("{CALL ListarHabitacionesDisponibles()}");
        ResultSet rs = proc.executeQuery();
        while (rs.next()) {
            Habitacion habitacion = new Habitacion(
                    rs.getInt("idHabitacion"),
                    rs.getInt("numeroHabitacion"),
                    rs.getString("tipoHabitacion"),
                    rs.getDouble("precioBase"),
                    rs.getString("estado"),
                    rs.getInt("capacidad")
            );
            listaHabitaciones.add(habitacion);
        }
        rs.close();
        proc.close();
        cn.getConnection().close();
    } catch (Exception e) {
        System.err.println("Error al listar las habitaciones: " + e.getMessage());
    }
    return listaHabitaciones;
}
    
    
    
    public Habitacion ObtenerHabitacionPorId(int idHabitacion) {
        Habitacion habitacion = null;
        try {
            Conexion cn = new Conexion();
            PreparedStatement pst = cn.getConnection().prepareStatement("SELECT * FROM habitacion WHERE idHabitacion = ?");
            pst.setInt(1, idHabitacion);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                habitacion = new Habitacion(
                        rs.getInt("idHabitacion"),
                        rs.getInt("numeroHabitacion"),
                        rs.getString("tipoHabitacion"),
                        rs.getDouble("precioBase"),
                        rs.getString("estado"),
                        rs.getInt("capacidad")
                );
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error al obtener la habitación: " + e.getMessage());
        }
        return habitacion;
    }
    
    public void actualizarEstadoHabitacion(int idHabitacion, String estado) {
        try {
            Conexion cn = new Conexion();
            String query = "UPDATE habitacion SET estado = ? WHERE idHabitacion = ?";
            PreparedStatement ps = cn.getConnection().prepareStatement(query);
            ps.setString(1, estado);
            ps.setInt(2, idHabitacion);
            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Estado de la habitación actualizado correctamente.");
            } else {
                System.out.println("No se encontró la habitación para actualizar.");
            }

            ps.close();
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error al actualizar el estado de la habitación: " + e.getMessage());
        }
    }
}
