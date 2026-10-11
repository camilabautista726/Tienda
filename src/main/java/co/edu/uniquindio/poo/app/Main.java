package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Categoria;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Producto;
import co.edu.uniquindio.poo.model.Tienda;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Tienda tienda = new Tienda("TechStore", "1094890034", "3006783456");

        int opcion=0;
        do {
            System.out.println("\nBienvenido al sistema de TechStore\n" +
                    "-----Menú-----\n" +
                    "1. Gestión de clientes\n" +
                    "2. Gestión de productos\n" +
                    "3. Gestión de facturas\n" +
                    "4. Gestión de reportes\n" +
                    "0. Salir");

            switch (opcion) {
                case 1 -> menuClientes(tienda);
                case 2 -> menuProductos(tienda);
                case 3 -> menuFacturas(tienda);
                case 4 -> menuReportes(tienda);
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    // Submenú 1: Clientes
    private static void menuClientes(Tienda tienda) {
        int opcion = 0 ;
        do {
            System.out.println("\nMenú de Clientes\n" +
                    "1. Registrar cliente\n" +
                    "2. Mostrar lista de clientes\n" +
                    "3. Buscar cliente\n" +
                    "4. Actualizar cliente\n" +
                    "0. Volver");


            switch (opcion) {
                case 1: crearCliente(tienda);
                case 2: mostrarListaClientes(tienda);
                case 3: buscarCliente(tienda);
                case 4: actualizarCliente(tienda);
                case 0: System.out.println("Volviendo al menú principal...");

            }
        } while (opcion != 0);
    }
    //Métodos submenú 1
    //Opción 1
    public static void crearCliente(Tienda tienda) {
        System.out.println("Ingrese el documento del cliente");
        String documento= sc.nextLine();
        Optional<Cliente> clienteEncontrado= tienda.buscarCliente(documento);
        if(clienteEncontrado.isPresent()){
            return;
        }
        System.out.println("Ingrese el nombre completo del cliente:");
        String nombreCompleto = sc.nextLine();
        System.out.println("Ingrese el correo del cliente:");
        String correo = sc.nextLine();
        System.out.println("Ingrese el telefono del cliente:");
        String telefono = sc.nextLine();
        System.out.println("Ingrese la ciudad de residencia del cliente:");
        String ciudadResidencia = sc.nextLine();
        String resultado= tienda.crearCliente(documento, nombreCompleto, correo, telefono, ciudadResidencia);
        System.out.println(resultado);
    }
    //Opción 2
    public static void mostrarListaClientes(Tienda tienda) {
        System.out.println("Lista de clientes:");
        System.out.println(tienda.mostrarListaClientes());
    }

    //Opción 3
    public static void buscarCliente(Tienda tienda) {
        System.out.println("Ingrese el documento del cliente:");
        String documento= sc.nextLine();
        Optional<Cliente> clienteEncontrado= tienda.buscarCliente(documento);
        if(clienteEncontrado.isPresent()){
            return;
        }
    }
    //Opción 4
    public static void actualizarCliente(Tienda tienda) {
        System.out.println("Ingrese el documento del cliente:");
        String documento= sc.nextLine();
        Optional<Cliente> clienteEncontrado= tienda.buscarCliente(documento);
        if(clienteEncontrado.isPresent()){
            System.out.println("Ingrese el dato a actualizar (1. Teléfono 2. Correo 3.Ciudad Residencia)");
            String datoActualizar= "";
            byte opcion= (byte) sc.nextInt();
            switch(opcion){
                case 1: System.out.println("Ingrese el nuevo teléfono del cliente:");
                datoActualizar= sc.nextLine();
                case 2: System.out.println("Ingrese el nuevo correo del cliente:");
                datoActualizar= sc.nextLine();
                case 3: System.out.println("Ingrese la nueva ciudad de residencia del cliente:");
                datoActualizar= sc.nextLine();
                default: System.out.println("Volviendo al menú principal...");
            }
            String resultado= tienda.actualizarCliente(documento, opcion, datoActualizar);
        }
    }

    // Submenú 2: Productos
    private static void menuProductos(Tienda tienda) {
        int opcion=0;
        do {
            System.out.println("\nMenú de Productos\n" +
                    "1. Registrar producto\n" +
                    "2. Mostrar lista de productos\n" +
                    "3. Buscar producto\n" +
                    "4. Actualizar producto\n" +
                    "5. Eliminar producto\n" +
                    "0. Volver");

            switch (opcion) {
                case 1 -> registrarProducto(tienda);
                case 2 -> mostrarListaProductos(tienda);
                case 3 -> buscarProducto(tienda);
                case 4 -> actualizarProducto(tienda);
                case 5 -> eliminarProducto(tienda);
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
    //Métodos submenú 2
    //Opción 1
    private static void registrarProducto(Tienda tienda) {
        System.out.println("Ingrese el código del producto:");
        String codigo= sc.nextLine();
        Optional<Producto>productoEncontrado=tienda.buscarProducto(codigo);
        if(productoEncontrado.isPresent()){
            return;
        }
        System.out.println("Ingrese el nombre del producto:");
        String nombre= sc.nextLine();
        System.out.println("Ingrese la descripción del producto:");
        String descripcion= sc.nextLine();
        System.out.println("Ingrese el precio del producto:");
        float precio= (float) sc.nextDouble();
        System.out.println("Ingrese la cantidad del producto:");
        int cantidad= sc.nextInt();
        System.out.println("Ingrese la nueva cantidad del producto:");
        String categoria= sc.nextLine();
        String resultado= tienda.registrarProducto(codigo, nombre, descripcion,precio, cantidad, Categoria.valueOf(categoria));
        System.out.println(resultado);
    }
    //Opción 2
    private static void mostrarListaProductos(Tienda tienda) {
        System.out.println("Lista de productos:");
        System.out.println(tienda.mostrarListaProductos());
    }
    //Opción 3
    private static void buscarProducto(Tienda tienda) {
        System.out.println("Ingrese el código del producto:");
        String codigo= sc.nextLine();
        Optional<Producto> productoEncontrado= tienda.buscarProducto(codigo);
        if(productoEncontrado.isPresent()){
            return;
        }
    }
    //Opción 4
    private static void actualizarProducto(Tienda tienda) {
        System.out.println("Ingrese el código del producto:");
        String codigo= sc.nextLine();
        float datoActualizar= 0;
        byte opcion= (byte) sc.nextInt();
        Optional<Producto> productoEncontrado= tienda.buscarProducto(codigo);
        if(productoEncontrado.isPresent()){
            System.out.println("Ingrese el dato a actualizar (1.Precio 2.Cantidad disponible)");
            switch(opcion){
                case 1: System.out.println("Ingrese el nuevo precio del producto:");
                datoActualizar= Float.parseFloat(sc.nextLine());
                case 2: System.out.println("Ingrese la nueva cantidad del producto:");
                datoActualizar= Float.parseFloat(sc.nextLine());
                default:System.out.println("Opcion no valida");
            }
            String resultado= tienda.actualizarProducto (codigo,opcion, datoActualizar);
        }
    }
    //Opción 5
    private static void eliminarProducto(Tienda tienda) {
        System.out.println("Ingrese el código del producto:");
        String codigo= sc.nextLine();
        String resultado= tienda.eliminarProducto(codigo);
        System.out.println(resultado);
    }


    // Submenú 3: Facturas
    private static void menuFacturas(Tienda tienda) {
        int opcion=0;
        do {
            System.out.println("\nMenú de Facturas\n" +
                    "1. Buscar factura\n" +
                    "0. Volver");


            switch (opcion) {
                case 1 -> mostrarFactura(tienda);
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
    //Métodos submenú 3
    //Opción 1
    private static void mostrarFactura(Tienda tienda) {
        System.out.println("Lista de Facturas:");
        System.out.println(tienda.mostrarListaFacturas());
    }


    // Submenú 4: Reportes (pendiente de definir)
    private static void menuReportes(Tienda tienda) {
        int opcion=0;
        do {
            System.out.println("\nMenú de Reportes\n" +
                    "1. Lista de productos con cantidad igual o mayor a 10"+"\n"+
                    "2. Obtener la lista de codigos de los productos con una cantidad disponible mayor igual a 10 y menor que 50"+"\n"+
                    "3. Obtener la lista de clientes que hayan comprado el 07 de octubre de 2026"+"\n"+
                    "4. Obtener las facturas que tenga un cliente donde su nombre empiece por R\n"+
                    "5. Obtener las facturas donde se haya comprado un celular de marca Iphone 16 pro max\n"+
                    "6. Obtener las facturas que tenga un cliente\n"+
                    "7. Implementar un método que reciba una categoría\n"+
                    "8. Implementar un método que reciba un precio mínimo y un precio máximo, y retorne\n"+
                    "9. Implementar un método que retorne todos los productos\n"+
                    "10. Implementar un método que identifique el producto con el precio más alto de la tienda\n"+
                    "11. Implementar un método que reciba el nombre de una ciudad y retorne todos los clientes que residan en ella\n"+
                    "0. Volver");
            switch (opcion) {
                case 1: cantidadIgualMayorDiez(tienda);
                case 2: cantidadMayorDiezMenorCincuenta(tienda);
                case 3: clientesFechaEspecifica(tienda);
                case 4: facturasClienteR(tienda);
                case 5: facturasiPhone(tienda);
                case 6: facturasUnCliente(tienda);
                case 7: recibirCategoria(tienda);
                case 8: precioMinMax(tienda);
                case 9: retornarProductos(tienda);
                case 10: precioMasAlto(tienda);
                case 11: habitantesCiudad(tienda);
                case 0: System.out.println("Volviendo al menú principal...");
                default: System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
    //Métodos submenú 4
    //Opción 1
    private static void cantidadIgualMayorDiez(Tienda tienda) {
        System.out.println(tienda.obtenerProductosCantidadMayorA10());
    }
    //Opción 2
    private static void cantidadMayorDiezMenorCincuenta(Tienda tienda) {
        System.out.println("Código de productos con cantidad actual mayor que 10 y menor que 50:"+tienda.cantidadMayorDiezMenorCincuenta());
    }
    //Opción 3
    private static void clientesFechaEspecifica(Tienda tienda) {
        System.out.println(tienda.obtenerClientesFechaEspecifica());
    }
    //Opción 4
    private static void facturasClienteR(Tienda tienda) {
        System.out.println("Facturas con cliente de inicial R");
        System.out.println(tienda.obtenerClientesConR());
    }
    //Opción 5
    private static void facturasiPhone(Tienda tienda) {
        System.out.println("Facturas con iPhone 16 Pro Max");
        System.out.println(tienda.obtenerFacturasConiPhone());
    }
    //Opción 6
    private static void facturasUnCliente(Tienda tienda) {
        System.out.println("Facturas con clientes de nombre Juan");
        System.out.println(tienda.obtenerFacturasJuaniPhone());
    }
    //Opción 7
    private static void recibirCategoria(Tienda tienda) {
        System.out.println("Ingrese la categoria que quiere recibir. ( COMPUTADORES, CELULARES, ACCESORIOS, VIDEOJUEGOS, COMPONENTES)");
        String categoria= sc.nextLine();
        String resultado= tienda.productosCategoria(categoria);
        System.out.println("Productos de la categoría "+categoria+ ": "+resultado);
    }
    //Opción 8
    private static void precioMinMax(Tienda tienda) {
        System.out.println("Ingrese el precio mínimo que busca:");
        float precioMin= Float.parseFloat(sc.nextLine());
        System.out.println("Ingrese el precio maximo que busca:");
        float precioMax= Float.parseFloat(sc.nextLine());
        ArrayList<Producto> resultado= tienda.precioMinMax(precioMin, precioMax);
        if(resultado.isEmpty()){
            System.out.println("No hay productos en este rango de precios");
        }else{
            for (Producto producto : resultado) {
                System.out.println("\n");
                System.out.println(producto);
            }
        }
    }
    //Opción 9
    public static void retornarProductos(Tienda tienda) {
        System.out.println("Lista de productos ordenados de menor a mayor");
        System.out.println(tienda.retornarProductos());
    }
    //Opción 10
    public static void precioMasAlto(Tienda tienda) {
        Optional<Producto> resultado = tienda.precioMasAlto();
        if (resultado.isPresent()) {
            Producto p = resultado.get();
            System.out.println("Código del producto: " + p.getCodigo());
            System.out.println("Nombre del producto: " + p.getNombre());
            System.out.println("Descripción del producto: " + p.getDescripcion());
            System.out.println("Precio del producto: " + p.getPrecio());
            System.out.println("Cantidad actual del producto: " + p.getCantidadDisponible());
        }
    }
    //Opción 11
    public static void habitantesCiudad(Tienda tienda) {
        System.out.println("Ingrese la ciudad que desea buscar");
        String ciudad= sc.nextLine();
        ArrayList<Cliente> resultado= tienda.habitantesCiudad(ciudad);
        for(Cliente c : resultado){
            System.out.println("\n");
            System.out.println(c);
        }
    }

}