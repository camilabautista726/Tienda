package co.edu.uniquindio.poo.model;
import java.util.*;

public class Tienda {
    Scanner sc =  new Scanner(System.in);
    private final String nombre;
    private final String nit;
    private String telefono;

    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final List<Factura> listaFacturas = new LinkedList<>();
    private Map<String,Producto> listaProductos = new HashMap<>();

    public Tienda(String nombre, String nit, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public Map<String, Producto> getListaProductos() {
        return listaProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setListaProductos(Map<String, Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    private String leer(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }
}
