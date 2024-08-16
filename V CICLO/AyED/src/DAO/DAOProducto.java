/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Producto;
import Classes.Conexion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class DAOProducto {

    public List<Producto> ListarProducto() {
        List<Producto> ListarP = new LinkedList<>();
        try {
            Conexion cn = new Conexion();
            CallableStatement proc = cn.getConnection().prepareCall("{call pr_ListarProductos()}");
            ResultSet Registros = proc.executeQuery();
            while (Registros.next()) {
                Producto P = new Producto(
                        Registros.getInt("idProducto"),
                        Registros.getString("nombre"),
                        Registros.getString("descripcion"),
                        Registros.getBigDecimal("precio_venta")
                );
                ListarP.add(P);
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return ListarP;
    }

    public void Guardar(Producto P) {
        try {
            Conexion cn = new Conexion();
            String query = "INSERT INTO producto (nombre, descripcion, precio_venta) VALUES (?, ?, ?)";
            PreparedStatement ps = cn.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, P.getNombre());
            ps.setString(2, P.getDescripcion());
            ps.setBigDecimal(3, P.getPrecioVenta());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idProducto = generatedKeys.getInt(1);
                P.setIdProducto(idProducto);
            }

            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public void Actualizar(Producto producto) {
        try {
            Conexion cn = new Conexion();
            String sql = "UPDATE producto SET nombre = ?, descripcion = ?, precio_venta = ? WHERE idProducto = ?";
            PreparedStatement pst = cn.getConnection().prepareStatement(sql);

            pst.setString(1, producto.getNombre());
            pst.setString(2, producto.getDescripcion());
            pst.setBigDecimal(3, producto.getPrecioVenta());
            pst.setInt(4, producto.getIdProducto());

            int filasActualizadas = pst.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Producto actualizado correctamente.");
            } else {
                System.out.println("No se encontró producto para actualizar.");
            }

            pst.close();
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error al actualizar producto: " + e.getMessage());
        }
    }

    public Producto Leer(int idProducto) {
        Producto producto = null;
        try {
            Conexion cn = new Conexion();
            String sql = "SELECT nombre, descripcion, precio_venta FROM producto WHERE idProducto = ?";
            PreparedStatement pst = cn.getConnection().prepareStatement(sql);
            pst.setInt(1, idProducto);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                producto = new Producto(
                        idProducto,
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getBigDecimal("precio_venta")
                );
            }

            rs.close();
            pst.close();
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
        return producto;
    }

    public void Eliminar(int idProducto) {
        try {
            Conexion cn = new Conexion();
            CallableStatement proc = cn.getConnection().prepareCall("{call pr_EliminarProducto(?)}");
            proc.setInt(1, idProducto);
            proc.execute();
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}
