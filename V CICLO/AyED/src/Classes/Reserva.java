/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jorge
 */
public class Reserva {

    private int idReserva;
    private int idHabitacion;
    private int idCliente;
    private LocalDate fechaLlegada;
    private LocalDate fechaSalida;
    private int numeroNoches;
    private String estadoR;

    public Reserva(int idReserva, int idHabitacion, int idCliente, LocalDate fechaLlegada, LocalDate fechaSalida, int numeroNoches, String estadoR) {
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.idCliente = idCliente;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.numeroNoches = numeroNoches;
        this.estadoR = estadoR;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNumeroNoches() {
        return numeroNoches;
    }

    public void setNumeroNoches(int numeroNoches) {
        this.numeroNoches = numeroNoches;
    }

    public String getEstadoR() {
        return estadoR;
    }

    public void setEstadoR(String estadoR) {
        this.estadoR = estadoR;
    }

    public Object[] Convertir() {
        Object[] Fila = {
            getIdReserva(),
            getIdHabitacion(),
            getIdCliente(),
            getFechaLlegada(),
            getFechaSalida(),
            getNumeroNoches(),
            getEstadoR()
        };
        return Fila;

    }

    public String toCSVString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return idReserva + ","
                + idCliente + ","
                + idHabitacion + ","
                + fechaLlegada.format(formatter) + ","
                + fechaSalida.format(formatter) + ","
                + numeroNoches + ","
                + estadoR;
    }

}
