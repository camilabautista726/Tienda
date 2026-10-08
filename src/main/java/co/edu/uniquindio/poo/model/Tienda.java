package co.edu.uniquindio.poo.model;
import java.util.*;
import java.time.LocalDate;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Tienda{" +
                "sc=" + sc +
                ", nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listaClientes=" + listaClientes +
                ", listaFacturas=" + listaFacturas +
                ", listaProductos=" + listaProductos +
                '}';
    }

    private String leer(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }
    //1. Lista de productos mayores o igual a 10
    public List<Producto> obtenerProductosCantidadMayorA10() {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : listaProductos.values()) {
            if (producto.getCantidadDisponible() >= 10) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }
    //2. Obtener los códigos de los productos con una cantidad disponible mayor o igual a 10 y menor que 50
    public ArrayList<Producto> obtenerProductosCantidadMayorA10Menor50() {
        ArrayList<Producto> codigosFiltrados = new ArrayList<>();
        for(Producto buscador: listaProductos.values()){
            if (buscador.getCantidadDisponible() < 50 && buscador.getCantidadDisponible() >= 10) {
                codigosFiltrados.add(buscador.getCodigo());
            }
        }
        return codigosFiltrados;
    }
    //2. Método usando HashMap
    public ArrayList<Producto> obtenerProductosCantidadMayorDiezYMenorCincuenta() {
        ArrayList<Producto> resultado = new ArrayList<>();
        for(String buscadorCodigo: hashMaplistaProductos.keySet()){
            Producto producto= hashMap.get(codigo);
            if(producto.getCantidadDisponible()>=10 && producto.getCantidadDisponible()<50) {
                resultado.add(codigo);
            }
        }
        return resultado;
    }

    //3. Obtener la lista de clientes que haya comprado el 07/10/2026
    public ArrayList<Cliente> obtenerClientesFechaEspecifica(){
        LocalDate fechaEspecifica= LocalDate.of(2026, 10, 7);
        ArrayList<Cliente> encontradas = new ArrayList<>();
        for (Cliente buscadorFacturas: listaFacturas()){
            if(fechaEspecifica.equals(buscadorFacturas.fecha)){
                encontradas.add( buscadorFacturas.getNombreCompleto());
            }
        }
        return encontradas;
    }
    //4. Obtener facturas donde el nombre empiece con R
    public ArrayList<Cliente>obtenerClientesConR(){
        //En caso de que el usuario quiera buscar otra letra
        System.out.println("Ingrese la letra a buscar");
        char letra = sc.next().charAt(0);
        ArrayList<Cliente> resultado = new ArrayList<>();
        for(Cliente buscador: listaClientes){
            char primeraLetra= buscador.getNombreCompleto().charAt(0);
            if(primeraLetra==letra){
                resultado.add(buscador);
            }
        }
        return resultado;
    }
}
