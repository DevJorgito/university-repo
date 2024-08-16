/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Jorge
 */

import java.time.LocalDate;

public class Cliente extends Persona{
    private int idCliente;
    private LocalDate fechaNacimiento;
    private String paisOrigen;

   
    public Cliente(int idCliente, LocalDate fechaNacimiento, String paisOrigen, int idPersona, String nombres, String apellidos, String tipoDocumento, String numeroDocumento, String direccion, String telefono, String correo) {
        super(idPersona, nombres, apellidos, tipoDocumento, numeroDocumento, direccion, telefono, correo);
        this.idCliente = idCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.paisOrigen = paisOrigen;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public Object[] Convertir() {
    Object[] Fila = {
        getIdPersona(),    
        getNombres(),      
        getApellidos(),    
        getTipoDocumento(), 
        getNumeroDocumento(), 
        getDireccion(),   
        getTelefono(),     
        getCorreo(),       
        getIdCliente(),    
        getFechaNacimiento(), 
        getPaisOrigen()    
    };
    return Fila;
}

    
}
