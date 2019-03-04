/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresaVehiculo;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class EmpresaAlquilerVehiculo {

// Atributos de la empresa
    private String cif;
    private String nombre;
    private String paginaWeb;
    /* Atributos para controlar el total de clientes que tiene la
empresa y array de almacenamiento para los objetos Cliente */
    private int totalClientes;
    private ArrayList<Cliente> clientes;
    /* Atributos para controlar el total de vehiculos disponibles en
alquiler que tiene la empresa y array de almacenamiento para los objetos
Vehiculo */
    private int totalVehiculos;
    private ArrayList<Vehiculo> vehiculos;
    /* Atributos para controlar el histórico de alquileres: total de
alquileres realizados y array de almacenamiento para los objetos8
VehiculoAlquilado */
    private int totalAlquileres;
    private ArrayList<VehiculoAlquilado> alquileres;

    // se omiten los métodos ‘get’ y ‘set’ de la clase
/* Constructor parametrizado donde se establece que el total de clientes
será 50, igual que el total de vehiculos disponibles. El histórico de
vehiculos puede contener hasta 100 elementos */
    EmpresaAlquilerVehiculo(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
// Incialmente no hay clientes creados en la empresa
        this.totalClientes = 0;
        this.clientes = new ArrayList<>(25); // apuntan a null
// Incialmente no hay vehiculos creados en la empresa
        this.totalVehiculos = 0;
        this.vehiculos = new ArrayList<>(25);// apuntan a null
// Incialmente no hay histórico de alquileres en la empresa
        this.totalAlquileres = 0;
        this.alquileres = new ArrayList<>(); // apuntan a null
    }

    public void registrarCliente(Cliente nuevo) {

        this.clientes.add(nuevo);
        this.totalClientes++;
    }

    public void registrarVehiculo(Vehiculo nuevo) {
        this.vehiculos.add(nuevo);
        this.totalVehiculos++;
    }

    public void imprimirClientes() {
        System.out.println("NIF cliente\tNombre\n");
        for (int i = 0; i < 25; i++) {
            System.out.println(clientes.get(i).toString());
        }
    }

    public void imprimirVehiculos() {
        System.out.println("Matricula\tModelo\tColor\tImporte\tDisponible\n");
        for (int i = 0; i < 25; i++) {
            System.out.println(vehiculos.get(i).toString());
        }
    }

    private Cliente getCliente(String nif) {
        for (int i = 0; i < this.getTotalClientes(); i++) {
            if (this.clientes.get(i).getNif().equals(nif)) {
                return this.clientes.get(i);
            }
        }
        return null;
    }

    private Vehiculo getVehiculo(String matricula) {
        for (int i = 0; i < this.totalVehiculos; i++) {
            if (this.vehiculos.get(i).getMatricula().equals(matricula)) {
                return this.vehiculos.get(i);
            }
        }
        return null;
    }

    public void recibirVehiculo(String matricula) {
// busca el vehículo con la matrícula dada en el
// array vehiculos y modifica su disponibilidad
// para que se pueda alquilar de nuevo
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo != null) {
            vehiculo.setDisponible(true);
        }

    }

    public void alquilarVehiculo(String matricula, String nif, int dias) {
        Cliente cliente = getCliente(nif);
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo.isDisponible()) {
            vehiculo.setDisponible(false);
            this.alquileres.add(new VehiculoAlquilado(cliente, vehiculo, diaHoy(), mesHoy(), añoHoy(), dias));
        }
    }

    public static int diaHoy() {
        return LocalDate.now().getDayOfMonth();
    }

    public static Month mesHoy() {
        return LocalDate.now().getMonth();
    }

    public static int añoHoy() {
        return LocalDate.now().getYear();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getTotalClientes() {
        return totalClientes;
    }

    public void setTotalClientes(int totalClientes) {
        this.totalClientes = totalClientes;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public int getTotalAlquileres() {
        return totalAlquileres;
    }

    public void setTotalAlquileres(int totalAlquileres) {
        this.totalAlquileres = totalAlquileres;
    }

    //Método que ordena el arraList de vehiculos por matricula con el método de la burbuja
    public void ordenarCatalogoVehiculos() {

        Vehiculo tmp;
        for (int i = 0; i < vehiculos.size() - 1; i++) {
            for (int j = i + 1; j < vehiculos.size(); j++) {
                if (vehiculos.get(i).getMatricula().compareTo(vehiculos.get(j).getMatricula()) > 0) {
                    tmp = vehiculos.get(i);
                    vehiculos.set(i, vehiculos.get(j));
                    vehiculos.set(j, tmp);
                }
            }
        }

    }

    //Método de la burbuja que ordena el ArrayList de clientes mediante el nif
    public void ordenarCarteraClientes() {

        Cliente tmp;
        for (int i = 0; i < clientes.size() - 1; i++) {
            for (int j = i + 1; j < clientes.size(); j++) {
                if (clientes.get(i).getNif().compareTo(clientes.get(j).getNif()) > 0) {
                    tmp = clientes.get(i);
                    clientes.set(i, clientes.get(j));
                    clientes.set(j, tmp);
                }
            }
        }
    }

    //Realiza una busqueda mediante el método de la busqueda binaria de los clientes, recibiendo como parametro para la busqueda el nif del cliente
    public int busquedaCliente(String buscado) {

        int mitad = 0;
        int izquierda = 0;
        int derecha = clientes.size() - 1;
        boolean encontrado = false;
        while ((izquierda <= derecha) && (!encontrado)) {
            mitad = (izquierda + derecha) / 2;
            if (clientes.get(mitad).getNif().equals(buscado)) {
                encontrado = true;
            } else if (clientes.get(mitad).getNif().compareTo(buscado) > 0) {
                derecha = mitad - 1; //buscar en el trozo izquierdo
            } else {
                izquierda = mitad + 1; // buscar en el trozo derecho
            }
        }
        if (encontrado) {
            return mitad;
        } else {
            return -1;
        }

    }

    //Realiza una busqueda mediante el método de la busqueda binaria de los vehiculos, recibiendo como parametro para la busqueda la matricula dle vehiculo.
    public int busquedaVehiculo(String matricula) {

        int mitad = 0;
        int izquierda = 0;
        int derecha = vehiculos.size() - 1;
        boolean encontrado = false;
        while ((izquierda <= derecha) && (!encontrado)) {
            mitad = (izquierda + derecha) / 2;
            if (vehiculos.get(mitad).getMatricula().equals(matricula)) {
                encontrado = true;
            } else if (vehiculos.get(mitad).getMatricula().compareTo(matricula) > 0) {
                derecha = mitad - 1; //buscar en el trozo izquierdo
            } else {
                izquierda = mitad + 1; // buscar en el trozo derecho
            }
        }
        if (encontrado) {
            return mitad;
        } else {
            return -1;
        }

    }
    
       public void rellenarCLientes() {
        for (int i = 0; i < 25; i++) {
            clientes.add(Cliente.clienteAleatorio());
        }
    }

    public void rellenarVehiculos() {
        for (int i = 0; i < 25; i++) {
           vehiculos.add(Vehiculo.vehiculoAleatorio());
        }
    }

}
