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
    //CRUD________________________________________________________________
    //Clientes____________________________________________________________
    //1. Create
    //1. Buscar cliente
    public Optional<Cliente> buscarCliente(String documentoIdentidad){
        for(Cliente cliente: listaClientes){
            if(cliente.getDocumentoIdentidad().equals(documentoIdentidad)){
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

    //2. Registrar el cliente
    public String crearCliente(String documentoIdentidad, String nombreCompleto, String correo, String telefono, String ciudadResidencia) {
        String resultado = "";
        Optional <Cliente> clienteEncontrado= buscarCliente(documentoIdentidad);
        if(clienteEncontrado.isPresent()){
            resultado+="El cliente ya se encuentra registrado en el sistema";
        }if (clienteEncontrado.isEmpty()){
            Cliente nuevoCliente= new Cliente(documentoIdentidad,nombreCompleto, correo, telefono, ciudadResidencia);
            listaClientes.add(nuevoCliente);
            resultado+="El cliente fue registrado en el sistema";
        }
        return resultado;
    }

    //3. Mostrar lista de clientes
    public String mostrarListaClientes() {
        String datosCliente = "";
        for (Cliente cliente : listaClientes) {
           datosCliente="Cliente\n"+
           "Documento de identidad: " + cliente.getDocumentoIdentidad()+"\n"+
           "Nombre: " + cliente.getNombreCompleto()+"\n"+
           "Correo: " + cliente.getCorreo()+"\n"+
           "Telefono: " + cliente.getTelefono()+"\n"+
           "Ciudad: " + cliente.getCiudadResidencia()+"\n"+
           "______________";
        }
        return datosCliente;
    }

    //4. Actualizar datos de cliente (Solo los que se puedan)
    public String actualizarCliente(String documento, byte opcion, String datoActualizar){
        Optional<Cliente> clienteEncontrado = buscarCliente(documento);
        if (clienteEncontrado.isEmpty()) {
            return "El cliente no se encuentra registrado";
        }
        Cliente cliente = clienteEncontrado.get();
        switch (opcion) {
            case 1: cliente.setTelefono(datoActualizar);
            break;
            case 2: cliente.setCorreo(datoActualizar);
            break;
            case 3: cliente.setCiudadResidencia(datoActualizar);
            break;
            default: System.out.println("Opción no válida");
            break;
        }
        return "Los datos fueron actualizados correctamente";
    }
    //Productos__________________________________________________________
    //1. Buscar producto
    public Optional<Producto> buscarProducto(String codigo){
        for(Producto producto: listaProductos.values()) {
            if (producto.getCodigo().equals(codigo)) {
                return Optional.of(producto);
            }
        }
        return Optional.empty();
    }
    //2. Crear producto
    public String registrarProducto(String codigo,String nombre, String descripcion, float precio, int cantidad) {
        String resultado = "";
        Optional <Producto> productoEncontrado= buscarProducto(nombre);
        if(productoEncontrado.isPresent()){
            resultado+="El producto ya está registrado en el sistema";
        }if (productoEncontrado.isEmpty()){
            Producto nuevoProducto= new Producto(codigo,nombre,descripcion,precio,cantidad);
            listaProductos.put(codigo,nuevoProducto);
            resultado+="El producto se ha registrado en el sistema";
        }
        return resultado;
    }
    //3. Mostrar lista de productos
    public String mostrarListaProductos() {
        String datosProducto = "";
        for (Producto producto : listaProductos.values()) {
            datosProducto="Código del producto:"+producto.getCodigo()+"\n"
            +"Nombre del producto:"+producto.getNombre()+"\n"
            +"Descripcion del producto:"+producto.getDescripcion()+"\n"
            +"Precio del producto:"+producto.getPrecio()+"\n"
            +"Cantidad actual del producto"+producto.getCantidadDisponible();
        }
        return datosProducto;
    }
    //4. Actualizar productos
    public String actualizarProducto(String codigo, int opcion, float datoActualizar) {
        Optional<Producto> productoEncontrado= buscarProducto(codigo);
        if (productoEncontrado.isEmpty()) {
            return "El producto no se encuentra registrado";
        }
        Producto producto = productoEncontrado.get();
        switch (opcion) {
            case 1: producto.setPrecio(datoActualizar);
            break;
            case 2: producto.setCantidadDisponible((int) datoActualizar);
            break;
            default: System.out.println("Opción no válida");
            break;
        }
        return "Los datos fueron actualizados correctamente";
    }
    //5. Eliminar un producto
    public String eliminarProducto(String codigo){
        if(listaProductos.containsKey(codigo)){
            listaProductos.remove(codigo);
            return "El producto se ha eliminado en el sistema";
        }else{
            return "El producto no se encuentra registrado";
        }
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

   //5. Obtener las facturas que tengan un cliente donde haya comprado un celular de marca iPhone 16 pro max
   public ArrayList<Factura>otenerFacturassConiPhone(){
       ArrayList<Factura> resultado = new ArrayList<>();
       for(Factura buscador: listaFacturas){
           for(DetalleFactura buscadorDos: )
       }
       return resultado;
   }
}
