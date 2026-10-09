package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Tienda;

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
            byte opcion= sc.nextInt();
            switch(opcion){
                case 1: System.out.println("Ingrese el nuevo teléfono del cliente:");
                datoActualizar= sc.nextLine();
                case 2: System.out.println("Ingrese el nuevo correo del cliente:");
                datoActualizar= sc.nextLine();
                case 3: System.out.println("Ingrese la nueva ciudad de residencia del cliente:");
                datoActualizar= sc.nextLine();
            }
            String resultado= tienda.actualizarCliente(documento, opcion, datoActualizar);
        }
    }

    // Submenú 2: Productos
    private static void menuProductos(Tienda tienda) {
        int opcion;
        do {
            System.out.println("\nMenú de Productos\n" +
                    "1. Registrar producto\n" +
                    "2. Mostrar lista de productos\n" +
                    "3. Buscar producto\n" +
                    "4. Actualizar producto\n" +
                    "5. Eliminar producto\n" +
                    "0. Volver");
            opcion = leerOpcion();

            switch (opcion) {
                case 1 -> System.out.println(tienda.registrarProducto());
                case 2 -> tienda.mostrarListaProductos();
                case 3 -> System.out.println(tienda.mostrarProducto());
                case 4 -> System.out.println(tienda.actualizarProducto());
                case 5 -> System.out.println(tienda.eliminarProducto());
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    // Submenú 3: Facturas
    private static void menuFacturas(Tienda tienda) {
        int opcion;
        do {
            System.out.println("\nMenú de Facturas\n" +
                    "1. Buscar factura\n" +
                    "2. Cancelar factura\n" +
                    "0. Volver");
            opcion = leerOpcion();

            switch (opcion) {
                case 1 -> System.out.println(tienda.mostrarFactura());
                case 2 -> System.out.println(tienda.cancelarFactura());
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    // Submenú 4: Reportes (pendiente de definir)
    private static void menuReportes(Tienda tienda) {
        int opcion;
        do {
            System.out.println("\nMenú de Reportes\n" +
                    "0. Volver");
            opcion = leerOpcion();

            switch (opcion) {
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

}