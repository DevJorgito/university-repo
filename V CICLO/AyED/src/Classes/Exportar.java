/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Exportar {

    public static boolean exportarReservas(List<Reserva> reservas, String rutaArchivo) {
        boolean exito = false;
        try (FileWriter fw = new FileWriter(rutaArchivo); PrintWriter pw = new PrintWriter(fw)) {

            // Escribir el encabezado del CSV
            pw.println("idReserva,idCliente,idHabitacion,fechaLlegada,fechaSalida,numeroNoches,estadoR");

            // Escribir los datos de cada reserva
            for (Reserva reserva : reservas) {
                pw.println(reserva.toCSVString());
            }

            exito = true;
        } catch (IOException e) {
            System.err.println("Error al exportar reservas: " + e.getMessage());
        }
        return exito;
    }
}
