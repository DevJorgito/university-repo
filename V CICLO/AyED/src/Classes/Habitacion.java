/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.List;

/**
 *
 * @author Jorge
 */
public class Habitacion {
    private int idHabitacion;
    private int numeroHabitacion;
    private String tipoHabitacion;
    private double precioBase;
    private String estado;
    private int capacidad;

    public Habitacion(int idHabitacion, int numeroHabitacion, String tipoHabitacion, double precioBase, String estado, int capacidad) {
        this.idHabitacion = idHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precioBase = precioBase;
        this.estado = estado;
        this.capacidad = capacidad;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    // Método Convertir
    public Object[] Convertir() {
        Object[] Fila = {
            getIdHabitacion(),
            getNumeroHabitacion(),
            getTipoHabitacion(),
            getPrecioBase(),
            getEstado(),
            getCapacidad()
        };
        return Fila;
    }
    
   
}
