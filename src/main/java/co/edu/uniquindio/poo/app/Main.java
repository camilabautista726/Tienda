package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Tienda;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Tienda tienda = new Tienda("TechStore", "1094890034", "3006783456");

        int opcion;
        do {
            System.out.println("\nBienvenido al sistema de TechStore\n" +
                    "-----Menú-----\n" +
                    "1. Gestión de clientes\n" +
                    "2. Gestión de productos\n" +
                    "3. Gestión de facturas\n" +
                    "4. Gestión de reportes\n" +
                    "0. Salir");
            opcion = leerOpcion();

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
        int opcion;
        do {
            System.out.println("\nMenú de Clientes\n" +
                    "1. Registrar cliente\n" +
                    "2. Mostrar lista de clientes\n" +
                    "3. Buscar cliente\n" +
                    "4. Actualizar cliente\n" +
                    "0. Volver");
            opcion = leerOpcion();

            switch (opcion) {
                case 1 -> System.out.println(tienda.registrarCliente());
                case 2 -> tienda.mostrarListaClientes();
                case 3 -> System.out.println(tienda.mostrarCliente());
                case 4 -> System.out.println(tienda.actualizarCliente());
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
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