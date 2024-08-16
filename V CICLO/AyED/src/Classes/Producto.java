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
public class Producto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private BigDecimal precioVenta;

    public Producto(int idProducto, String nombre, String descripcion, BigDecimal precioVenta) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public Object[] Convertir() {
    Object[] Fila = {
        getIdProducto(),
        getNombre(),
        getDescripcion(),
        getPrecioVenta()
    };
    return Fila;
}

    
}
