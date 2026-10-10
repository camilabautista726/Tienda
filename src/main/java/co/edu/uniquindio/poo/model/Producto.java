package co.edu.uniquindio.poo.model;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;

public class Producto {
    Scanner sc = new Scanner(System.in);
    private String codigo;
    private String nombre;
    private String descripcion;
    private float precio;
    private int cantidadDisponible;
    private final List<Factura> listaProductos;
    private Tienda ownedByTienda;


    public Producto(String codigo, String nombre, String descripcion, float precio, int cantidadDisponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.listaProductos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Producto{" +
                "sc=" + sc +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", cantidadDisponible=" + cantidadDisponible +
                ", listaProductos=" + listaProductos +
                ", ownedByTienda=" + ownedByTienda +
                '}';
    }

}
