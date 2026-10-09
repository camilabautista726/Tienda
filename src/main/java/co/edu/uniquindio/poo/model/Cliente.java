package co.edu.uniquindio.poo.model;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cliente {
    Scanner sc = new Scanner(System.in);
    private final String documentoIdentidad;
    private final String nombreCompleto;
    private String correo;
    private String telefono;
    private String ciudadResidencia;
    private final List<Factura> listaFacturas;

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

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    @Override
    public String toString() {
        return "Cliente{documento=" + documentoIdentidad + ", nombre=" + nombreCompleto +
                ", correo=" + correo + ", teléfono=" + telefono + ", ciudad=" + ciudadResidencia + "}";
    }
    //1. CRUD ____________________________________________________________________________________________
    // Crear cliente


}
