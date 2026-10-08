package co.edu.uniquindio.poo.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;

public class Producto {
    Scanner sc= new Scanner(System.in);
    private String codigo;
    private String nombre;
    private String descripcion;
    private float precio;
    private int cantidadDisponible;
    private final List<Factura> listaProductos;
    private final Tienda ownedByTienda;


    public Producto(String codigo, String nombre, String descripcion, float precio, int cantidadDisponible, List<Factura> listaProductos, Tienda ownedByTienda) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.listaProductos = listaProductos;
        this.ownedByTienda = ownedByTienda;
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
    public Optional<Producto> buscarProducto(String codigo) {
        return Optional.ofNullable(listaProductos.get(codigo));
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

    // Create
    public String registrarProducto() {
        String codigo = ("Ingrese el código del producto");
        return buscarProducto(codigo)
                .map(p -> "El producto ya existe")
                .orElseGet(() -> {
                    System.out.println("Ingrese el nombre");
                    String nombre = sc.next();
                    System.out.println("Ingrese la descripción");
                    String descripcion = sc.next();
                    System.out.println("Ingrese el precio");
                    float precio = sc.nextFloat();
                    System.out.println("Ingrese la cantidad disponible");
                    int cantidad = sc.nextInt();
                    listaProductos.add(codigo, new Producto(codigo, nombre, descripcion, precio, cantidad));
                    return "Producto registrado";
                });
    }

    // Read (uno)
    public String mostrarProducto() {
        System.out.println("Ingrese el código del producto");
        String codigo = sc.next();
        return buscarProducto(codigo)
                .map(Producto::toString)
                .orElse("El producto no existe");
    }

    // Read (todos)
    public void mostrarListaProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados");
        } else {
            listaProductos.values().forEach(System.out::println);
        }
    }

    // Update (precio o cantidad)
    public String actualizarProducto() {
        System.out.println("Ingrese el código del producto");
        String codigo = sc.next();
        return buscarProducto(codigo)
                .map(p -> {
                    System.out.println("Dato a actualizar: 1. Precio  2. Cantidad disponible");
                    int opcion = sc.nextInt();
                    switch (opcion) {
                        case "1" -> p.setPrecio((System.out.println("Ingrese el nuevo precio"));
                        case "2" -> p.setCantidadDisponible((System.out.println("Ingrese la nueva cantidad"));
                        default -> { return "Opción no válida"; }
                    }
                    return "Producto actualizado correctamente";
                })
                .orElse("El producto no existe");
    }

    // Delete
    public String eliminarProducto() {
        System.out.println("Ingrese el código del producto a eliminar");
        String codigo= sc.nextLine();
        return Optional.ofNullable(listaProductos.remove(codigo))
                .map(p -> "Producto eliminado")
                .orElse("El producto no existe");
    }
    //Lista de productos mayores o igual a 10
    public List<Producto> obtenerProductosCantidadMayorA10() {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : listaProductos.values()) {
            if (producto.getCantidadDisponible() >= 10) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }
}
