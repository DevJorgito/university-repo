/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Cliente;
import Classes.Conexion;

/**
 *
 * @author Jorge
 */
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class DAOCliente {

    public List<Cliente> ListarCliente() {
        List<Cliente> ListarC = new LinkedList<>();
        try {
            Conexion cn = new Conexion();
            CallableStatement proc = cn.getConnection().prepareCall("{call pr_ListarClientes()}");
            ResultSet Registros = proc.executeQuery();
            while (Registros.next()) {
                Cliente C = new Cliente(
                        Registros.getInt("idCliente"),
                        Registros.getDate("fechaNacimiento").toLocalDate(),
                        Registros.getString("paisOrigen"),
                        Registros.getInt("idPersona"),
                        Registros.getString("nombres"),
                        Registros.getString("apellidos"),
                        Registros.getString("tipoDocumento"),
                        Registros.getString("numeroDocumento"),
                        Registros.getString("direccion"),
                        Registros.getString("telefono"),
                        Registros.getString("correo")
                );
                ListarC.add(C);
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return ListarC;
    }

    public List<Cliente> Recuperar() {
        List<Cliente> ListarC = new LinkedList<>();
        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
        try {
            st = cn.getConnection().createStatement();
            rs = st.executeQuery("SELECT * FROM cliente INNER JOIN persona ON cliente.idPersona = persona.idPersona ORDER BY nombres");
            while (rs.next()) {
                Cliente C = new Cliente(
                        rs.getInt("idCliente"),
                        rs.getDate("fechaNacimiento").toLocalDate(),
                        rs.getString("paisOrigen"),
                        rs.getInt("idPersona"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("tipoDocumento"),
                        rs.getString("numeroDocumento"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("correo")
                );
                ListarC.add(C);
            }
            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return ListarC;
    }

    public void Guardar(Cliente C) {
        try {
            Conexion cn = new Conexion();
            String queryPersona = "INSERT INTO persona (nombres, apellidos, tipoDocumento, numeroDocumento, direccion, telefono, correo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement psPersona = cn.getConnection().prepareStatement(queryPersona, Statement.RETURN_GENERATED_KEYS);
            psPersona.setString(1, C.getNombres());
            psPersona.setString(2, C.getApellidos());
            psPersona.setString(3, C.getTipoDocumento());
            psPersona.setString(4, C.getNumeroDocumento());
            psPersona.setString(5, C.getDireccion());
            psPersona.setString(6, C.getTelefono());
            psPersona.setString(7, C.getCorreo());
            psPersona.executeUpdate();

            ResultSet generatedKeys = psPersona.getGeneratedKeys();
            int idPersona = 0;
            if (generatedKeys.next()) {
                idPersona = generatedKeys.getInt(1);
            }

            String queryCliente = "INSERT INTO cliente (idPersona, fechaNacimiento, paisOrigen) VALUES (?, ?, ?)";
            PreparedStatement psCliente = cn.getConnection().prepareStatement(queryCliente);
            psCliente.setInt(1, idPersona);
            psCliente.setDate(2, Date.valueOf(C.getFechaNacimiento()));
            psCliente.setString(3, C.getPaisOrigen());
            psCliente.executeUpdate();

            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public int Guardar_Proc(Cliente C) {
        int idGenerado = 0;
        try {
            Conexion cn = new Conexion();
            CallableStatement proc = cn.getConnection().prepareCall("{call pr_GuardarCliente(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            proc.setString(1, C.getNombres());
            proc.setString(2, C.getApellidos());
            proc.setString(3, C.getTipoDocumento());
            proc.setString(4, C.getNumeroDocumento());
            proc.setString(5, C.getDireccion());
            proc.setString(6, C.getTelefono());
            proc.setString(7, C.getCorreo());
            proc.setDate(8, Date.valueOf(C.getFechaNacimiento()));
            proc.setString(9, C.getPaisOrigen());

            proc.execute();

            cn.getConnection().close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return idGenerado;
    }

    public void Actualizar(Cliente cliente) {
    try {
        Conexion cn = new Conexion();
        String sql = "UPDATE cliente c "
                + "INNER JOIN persona p ON c.idPersona = p.idPersona "
                + "SET p.nombres = ?, p.apellidos = ?, p.tipoDocumento = ?, p.numeroDocumento = ?, "
                + "p.direccion = ?, p.telefono = ?, p.correo = ?, c.fechaNacimiento = ?, c.paisOrigen = ? "
                + "WHERE c.idCliente = ?";

        PreparedStatement pst = cn.getConnection().prepareStatement(sql);
        pst.setString(1, cliente.getNombres());
        pst.setString(2, cliente.getApellidos());
        pst.setString(3, cliente.getTipoDocumento());
        pst.setString(4, cliente.getNumeroDocumento());
        pst.setString(5, cliente.getDireccion());
        pst.setString(6, cliente.getTelefono());
        pst.setString(7, cliente.getCorreo());
        pst.setDate(8, Date.valueOf(cliente.getFechaNacimiento()));
        pst.setString(9, cliente.getPaisOrigen());
        pst.setInt(10, cliente.getIdCliente());

        int filasActualizadas = pst.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("Cliente actualizado correctamente.");
        } else {
            System.out.println("No se encontró cliente para actualizar.");
        }

        pst.close();
        cn.getConnection().close();
    } catch (Exception e) {
        System.err.println("Error al actualizar cliente: " + e.getMessage());
    }
}


   public Cliente Leer(int idCliente) {
    Cliente cliente = null;
    try {
        Conexion cn = new Conexion();
        String sql = "SELECT p.idPersona, p.nombres, p.apellidos, p.tipoDocumento, p.numeroDocumento, "
                + "p.direccion, p.telefono, p.correo, c.fechaNacimiento, c.paisOrigen "
                + "FROM cliente c "
                + "INNER JOIN persona p ON c.idPersona = p.idPersona "
                + "WHERE c.idCliente = ?";

        PreparedStatement pst = cn.getConnection().prepareStatement(sql);
        pst.setInt(1, idCliente);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            cliente = new Cliente(
                    idCliente,
                    rs.getDate("fechaNacimiento").toLocalDate(),
                    rs.getString("paisOrigen"),
                    rs.getInt("idPersona"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("tipoDocumento"),
                    rs.getString("numeroDocumento"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("correo")
            );
        }

        cn.getConnection().close();
    } catch (Exception e) {
        System.err.println("Error: " + e);
    }
    return cliente;
}

}
