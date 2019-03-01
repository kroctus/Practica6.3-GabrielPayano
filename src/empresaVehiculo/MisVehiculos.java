/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresaVehiculo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class MisVehiculos {

    public static void main(String[] args) {

//        // la instancia easydrive de la clase EmpresaAlquilerVehiculos
//        EmpresaAlquilerVehiculo easydrive = new EmpresaAlquilerVehiculo("A-28-187189", "easy drive", "www.easydrive.com");
//// registro de los clientes de la empresa
//        easydrive.registrarCliente(new Cliente("X5618927C", "Juan", "González López"));
//
//        easydrive.registrarCliente(new Cliente("Z7568991Y", "Luis", "Fernández Gómez"));
//
//// registro de los vehículos de la empresa
//        easydrive.registrarVehiculo(new Vehiculo("4060 TUR", "Skoda", "Fabia", "Blanco", 90.0, false));
//
//        easydrive.registrarVehiculo(new Vehiculo("4070 DEP", "Ford", "Mustang", "Rojo", 150.0, true));
//
//        easydrive.registrarVehiculo(new Vehiculo("4080 TUR", "VW", "GTI", "Azul", 110.0, false));
//
//        easydrive.registrarVehiculo(new Vehiculo("4090 TUR", "SEAT", "Ibiza", "Blanco", 90.0, false));
//
//        easydrive.registrarVehiculo(new Vehiculo("4100 FUR", "Fiat", "Ducato", "Azul", 80.0, true));
//
//        // imprime la relación de clientes de easydrive
//        easydrive.imprimirClientes();
//// imprime el catálogo de vehículos de easydrive
//        easydrive.imprimirVehiculos();
//        
        //Creamos una empresa de alquiler de vehiculos
        EmpresaAlquilerVehiculo nuevaEmpresa = new EmpresaAlquilerVehiculo("B-85-19657425", "empresa", "www.tuEmprersaDevehiculos.com");

        //Utilizamos un bucle y los respecivos metodos para rellenar los arrays de vehiculos y clientes con 25 veces.
        int contador = 1;
        do {
            Cliente aux = Cliente.clienteAleatorio();
            nuevaEmpresa.registrarCliente(aux);
            contador++;
        } while (contador < 26);

        contador = 1;
        do {

            Vehiculo aux = Vehiculo.vehiculoAleatorio();
            nuevaEmpresa.registrarVehiculo(aux);
            contador++;
        } while (contador < 26);

    }

}
