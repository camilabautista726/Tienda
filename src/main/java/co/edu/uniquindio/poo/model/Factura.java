package co.edu.uniquindio.poo.model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {
    public record Factura(String codigo, LocalDate fecha, double total,
                          EstadoFactura estadoFactura, MetodoPago metodoPago, Cliente cliente,
                          ArrayList<DetalleFactura> listaDetallesFactura, Tienda ownedByTienda) {
    }
}
