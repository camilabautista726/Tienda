package co.edu.uniquindio.poo.model;

public class Cliente {
    private final String documentoIdentidad;
    private final String nombreCompleto;
    private String correo;
    private String telefono;
    private String ciudadResidencia;

    public Cliente(String documentoIdentidad, String nombreCompleto, String correo, String telefono, String ciudadResidencia) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }
    @Override
    public String toString() {
        return "Cliente{documento=" + documentoIdentidad + ", nombre=" + nombreCompleto +
                ", correo=" + correo + ", teléfono=" + telefono + ", ciudad=" + ciudadResidencia + "}";
    }
    // Búsqueda base
    public Optional<Cliente> buscarCliente(String documento) {
        return listaClientes.stream()
                .filter(c -> c.getDocumentoIdentidad().equals(documento))
                .findFirst();
    }

    // Create
    public String registrarCliente() {
        String documento = leer("Ingrese el documento del cliente");
        return buscarCliente(documento)
                .map(c -> "Cliente ya existe")
                .orElseGet(() -> {
                    String nombre   = leer("Ingrese el nombre completo");
                    String correo   = leer("Ingrese el correo");
                    String telefono = leer("Ingrese el teléfono");
                    String ciudad   = leer("Ingrese la ciudad de residencia");
                    listaClientes.add(new Cliente(documento, nombre, correo, telefono, ciudad));
                    return "Cliente registrado";
                });
    }

    // Read (uno)
    public String mostrarCliente() {
        String documento = leer("Ingrese el documento del cliente");
        return buscarCliente(documento)
                .map(Cliente::toString)
                .orElse("El cliente no existe");
    }

    // Read (todos)
    public void mostrarListaClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            listaClientes.forEach(System.out::println);
        }
    }

    // Update (solo teléfono o correo)
    public String actualizarCliente() {
        String documento = leer("Ingrese el documento del cliente");
        return buscarCliente(documento)
                .map(c -> {
                    String opcion = leer("Dato a actualizar: 1. Teléfono  2. Correo");
                    switch (opcion) {
                        case "1" -> c.setTelefono(leer("Ingrese el nuevo teléfono"));
                        case "2" -> c.setCorreo(leer("Ingrese el nuevo correo"));
                        default -> { return "Opción no válida"; }
                    }
                    return "Los datos del cliente fueron actualizados correctamente";
                })
                .orElse("El cliente no existe");
    }

// Delete no se permite eliminar clientes
}
