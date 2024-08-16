package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Recepcionista extends Persona {
    private int idRecepcionista;
    private String turno;
    private String usuario;
    private String contrasena;

    public Recepcionista(int idPersona, String nombres, String apellidos, String tipoDocumento, String numeroDocumento, String direccion, String telefono, String correo, int idRecepcionista, String turno, String usuario, String contrasena) {
        super(idPersona, nombres, apellidos, tipoDocumento, numeroDocumento, direccion, telefono, correo);
        this.idRecepcionista = idRecepcionista;
        this.turno = turno;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Recepcionista(String usuario, String contrasena) {
        super(0, "", "", "", "", "", "", ""); 
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public int getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(int idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String autenticar() {
        Conexion cn = new Conexion();
        String SQL = "SELECT * FROM Recepcionista WHERE usuario=? AND contrasena=MD5(?)";
        String identificacion = "";

        try (Connection con = cn.getConnection(); 
             PreparedStatement pst = con.prepareStatement(SQL)) {
            pst.setString(1, this.usuario);
            pst.setString(2, this.contrasena);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                identificacion = rs.getInt("idRecepcionista") + '/' + rs.getString("usuario");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        return identificacion;
    }
}
