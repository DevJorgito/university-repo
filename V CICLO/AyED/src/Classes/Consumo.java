/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.math.BigDecimal;

/**
 *
 * @author Jorge
 */
public class Consumo {
    private int idConsumo;
    private int idReserva;
    private int idProducto;
    private BigDecimal cantidad;
    private BigDecimal precioVenta;
    private String estado;

    public Consumo(int idConsumo, int idReserva, int idProducto, BigDecimal cantidad, BigDecimal precioVenta, String estado) {
        this.idConsumo = idConsumo;
        this.idReserva = idReserva;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.estado = estado;
    }

    public int getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Object[] Convertir() {
    Object[] Fila = {
        getIdConsumo(),
        getIdReserva(),
        getIdProducto(),
        getCantidad(),
        getPrecioVenta(),
        getEstado()
    };
    return Fila;
}

    
}
