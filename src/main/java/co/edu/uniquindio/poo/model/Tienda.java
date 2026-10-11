package co.edu.uniquindio.poo.model;
import java.util.*;
import java.time.LocalDate;

///
public class Tienda {
    Scanner sc = new Scanner(System.in);
    private final String nombre;
    private final String nit;
    private String telefono;

    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final List<Factura> listaFacturas = new LinkedList<>();
    private Map<String, Producto> listaProductos = new HashMap<>();

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
    public Optional<Cliente> buscarCliente(String documentoIdentidad) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumentoIdentidad().equals(documentoIdentidad)) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

    //2. Registrar el cliente
    public String crearCliente(String documentoIdentidad, String nombreCompleto, String correo, String telefono, String ciudadResidencia) {
        String resultado = "";
        Optional<Cliente> clienteEncontrado = buscarCliente(documentoIdentidad);
        if (clienteEncontrado.isPresent()) {
            resultado += "El cliente ya se encuentra registrado en el sistema";
        }
        if (clienteEncontrado.isEmpty()) {
            Cliente nuevoCliente = new Cliente(documentoIdentidad, nombreCompleto, correo, telefono, ciudadResidencia);
            listaClientes.add(nuevoCliente);
            resultado += "El cliente fue registrado en el sistema";
        }
        return resultado;
    }

    //3. Mostrar lista de clientes
    public String mostrarListaClientes() {
        String datosCliente = "";
        for (Cliente cliente : listaClientes) {
            datosCliente = "Cliente\n" +
                    "Documento de identidad: " + cliente.getDocumentoIdentidad() + "\n" +
                    "Nombre: " + cliente.getNombreCompleto() + "\n" +
                    "Correo: " + cliente.getCorreo() + "\n" +
                    "Telefono: " + cliente.getTelefono() + "\n" +
                    "Ciudad: " + cliente.getCiudadResidencia() + "\n" +
                    "______________";
        }
        return datosCliente;
    }

    //4. Actualizar datos de cliente (Solo los que se puedan)
    public String actualizarCliente(String documento, byte opcion, String datoActualizar) {
        Optional<Cliente> clienteEncontrado = buscarCliente(documento);
        if (clienteEncontrado.isEmpty()) {
            return "El cliente no se encuentra registrado";
        }
        Cliente cliente = clienteEncontrado.get();
        switch (opcion) {
            case 1:
                cliente.setTelefono(datoActualizar);
                break;
            case 2:
                cliente.setCorreo(datoActualizar);
                break;
            case 3:
                cliente.setCiudadResidencia(datoActualizar);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        return "Los datos fueron actualizados correctamente";
    }

    //Productos__________________________________________________________
    //1. Buscar producto
    public Optional<Producto> buscarProducto(String codigo) {
        for (Producto producto : listaProductos.values()) {
            if (producto.getCodigo().equals(codigo)) {
                return Optional.of(producto);
            }
        }
        return Optional.empty();
    }

    //2. Crear producto
    public String registrarProducto(String codigo, String nombre, String descripcion, float precio, int cantidad, Categoria categoria) {
        String resultado = "";
        Optional<Producto> productoEncontrado = buscarProducto(nombre);
        if (productoEncontrado.isPresent()) {
            resultado += "El producto ya está registrado en el sistema";
        }
        if (productoEncontrado.isEmpty()) {
            Producto nuevoProducto = new Producto(codigo, nombre, descripcion, precio, cantidad, categoria);
            listaProductos.put(codigo, nuevoProducto);
            resultado += "El producto se ha registrado en el sistema";
        }
        return resultado;
    }

    //3. Mostrar lista de productos
    public String mostrarListaProductos() {
        String datosProducto = "";
        for (Producto producto : listaProductos.values()) {
            datosProducto = "Código del producto:" + producto.getCodigo() + "\n"
                    + "Nombre del producto:" + producto.getNombre() + "\n"
                    + "Descripcion del producto:" + producto.getDescripcion() + "\n"
                    + "Precio del producto:" + producto.getPrecio() + "\n"
                    + "Cantidad actual del producto" + producto.getCantidadDisponible();
        }
        return datosProducto;
    }

    //4. Actualizar productos
    public String actualizarProducto(String codigo, int opcion, float datoActualizar) {
        Optional<Producto> productoEncontrado = buscarProducto(codigo);
        if (productoEncontrado.isEmpty()) {
            return "El producto no se encuentra registrado";
        }
        Producto producto = productoEncontrado.get();
        switch (opcion) {
            case 1:
                producto.setPrecio(datoActualizar);
                break;
            case 2:
                producto.setCantidadDisponible((int) datoActualizar);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        return "Los datos fueron actualizados correctamente";
    }

    //5. Eliminar un producto
    public String eliminarProducto(String codigo) {
        if (listaProductos.containsKey(codigo)) {
            listaProductos.remove(codigo);
            return "El producto se ha eliminado en el sistema";
        } else {
            return "El producto no se encuentra registrado";
        }
    }

    //Facturas______________________________________________________-
    public String mostrarListaFacturas() {
        String datosFacturas = "";
        for (Factura facturas : listaFacturas) {
            datosFacturas = facturas.toString();
        }
        return datosFacturas;
    }

    //Submenú 4
    //Métodos practica__________________________________________________________________
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
    //2. Cantidad >10 <50
    public ArrayList<Producto> cantidadMayorDiezMenorCincuenta() {
        ArrayList<Producto> codigosFiltrados = new ArrayList<>();
        for(Producto buscador: listaProductos.values()){
            if (buscador.getCantidadDisponible() < 50 && buscador.getCantidadDisponible() >= 10) {
                codigosFiltrados.add(buscador);
                System.out.println("\n");
            }
        }
        return codigosFiltrados;
    }
    //3. Clientes fecha específica
    public ArrayList<Cliente> obtenerClientesFechaEspecifica(){
        LocalDate fechaEspecifica= LocalDate.of(2026, 10, 7);
        ArrayList<Cliente> encontradas = new ArrayList<>();
        for (Factura buscadorFacturas: listaFacturas){
            if(Factura.fecha().isEqual(fechaEspecifica)){
                encontradas.add(buscadorFacturas.cliente());
            }
        }
        return encontradas;
    }
    //4. Obtener facturas donde el nombre del cliente empiece con R
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
    public ArrayList<Factura>obtenerFacturasConiPhone(){
        System.out.println("Facturas con iPhone 16 Pro Max");
        String detalleFactura = "iPhone 16 Pro Max";
        ArrayList<Factura> resultado = new ArrayList<>();
        for(Factura buscador: listaFacturas){
            for (DetalleFactura detalle : buscador.listaDetallesFactura()) {
                if (detalle.getProducto().getNombre().equals(detalleFactura)){
                    resultado.add(buscador);
                    break;
                }
            }
        }
        return resultado;
    }
    //6. Obtener las facturas que tenga un cliente donde su nombre sea juan y haya comprado un celular de marca iPhone 16 pro max
    public ArrayList<Factura>obtenerFacturasJuaniPhone(){
        System.out.println("Facturas de Juan con iPhone 16 Pro Max");
        String nombreFactura = "Juan";
        String detalleFactura = "iPhone 16 Pro Max";
        ArrayList<Factura> resultado = new ArrayList<>();
        for(Factura buscador: listaFacturas) {
            if (buscador.cliente().getNombreCompleto().equals(nombreFactura)) {
                for (DetalleFactura detalle : buscador.listaDetallesFactura()) {
                    if (detalle.getProducto().getNombre().equals(detalleFactura)) {
                        resultado.add(buscador);
                        break;
                    }
                }
            }
        }
        return resultado;
    }
    //7. Implementar un metodo que reciba una categoría y retorne todos los productos registrados que pertenezcan a ella.
    public String productosCategoria(String categoria){
        String resultado = "";
        for (Producto producto : listaProductos.values()) {
            if(producto.getCategoria().equals(categoria)) {
                resultado=producto.getNombre();
                resultado+="\n";
            }
        }
        return resultado;
    }
    //8. Implementar un metodo que reciba un precio mínimo y un precio máximo, y retorne los productos cuyo precio se encuentre dentro de ese rango, incluyendo ambos límites.
    public ArrayList<Producto> precioMinMax(float precioMin, float precioMax) {
        System.out.println("Productos dentro del rango de precios ("+precioMin+","+precioMax+")");
        ArrayList<Producto> rango = new ArrayList<>();
        for (Producto producto : listaProductos.values()) {
            if(producto.getPrecio() >= precioMin && producto.getPrecio() <= precioMax) {
                rango.add(producto);
            }
        }
        return rango;
    }
    //9. Implementar un metodo que retorne todos los productos registrados en la tienda, ordenados de menor a mayor según su precio.
    public String retornarProductos() {
        ArrayList<Producto> resultado = new ArrayList<>();
        String datosProducto = "";
        for(int i = 0; i < listaProductos.size()-1; i++){
            for(int j = 0; j < listaProductos.size()-1-i; j++){
                if(resultado.get(j).getPrecio() > resultado.get(j+1).getPrecio()){
                    Producto espacio= resultado.get(j);
                    resultado.set(j, resultado.get(j+1));
                    resultado.set(j+1, espacio);
                }
            }
        }
        for (Producto producto : resultado) {
            datosProducto = "Código del producto:" + producto.getCodigo() + "\n"
                    + "Nombre del producto:" + producto.getNombre() + "\n"
                    + "Descripcion del producto:" + producto.getDescripcion() + "\n"
                    + "Precio del producto:" + producto.getPrecio() + "\n"
                    + "Cantidad actual del producto" + producto.getCantidadDisponible()+
            "\n"+"__________________________________________"+"\n";
        }
        return datosProducto;
    }
    //10. Implementar un metodo que identifique el producto con el precio más alto de la tienda. Si no existen productos registrados, el metodo debe retornar un Optional vacío.
    public Optional<Producto> precioMasAlto() {
        if(listaProductos.isEmpty()){
            return Optional.empty();
        }
        Producto resultado = listaProductos.get(0);
        for(Producto producto: listaProductos.values()){
            if(producto.getPrecio() > resultado.getPrecio()){
                resultado = producto;
            }
        }
        return Optional.of(resultado);
    }
}
