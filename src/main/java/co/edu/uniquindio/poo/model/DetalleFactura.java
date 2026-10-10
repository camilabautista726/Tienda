package co.edu.uniquindio.poo.model;

public class DetalleFactura {
    private final Producto producto;
    private final int cantidadComprada;
    private final float subtotal;

    public DetalleFactura(Producto producto,int cantidadComprada, float subtotal) {
        this.producto = producto;
        this.cantidadComprada = cantidadComprada;
        this.subtotal = subtotal;
    }
    public Producto getProducto() {
        return producto;
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
