package co.edu.uniquindio.poo.model;

public class DetalleFactura {
    private final int cantidadComprada;
    private final float subtotal;

    public DetalleFactura(int cantidadComprada, float subtotal) {
        this.cantidadComprada = cantidadComprada;
        this.subtotal = subtotal;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public float getSubtotal() {
        return subtotal;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "DetalleFactura{" +
                "cantidadComprada=" + cantidadComprada +
                ", subtotal=" + subtotal +
                '}';
    }

}
