/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresaVehiculo;

import java.util.Random;

/**
 *
 * @author gabriel
 */
public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Vehiculo(String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = disponible;
    }

    public static Vehiculo vehiculoAleatorio() {

        String[] matricula = new String[8];

        matricula[0] = "1234BBB";
        matricula[1] = "346CFG";
        matricula[2] = "589UYH";
        matricula[3] = "358OPL";
        matricula[4] = "569KPL";
        matricula[5] = "381QEV";
        matricula[6] = "463CVK";
        matricula[7] = "306RTX";

        String[] marca = new String[8];

        marca[0] = "SEAT";
        marca[1] = "CITROEN";
        marca[2] = "JAGUAR";
        marca[3] = "MITSUBISHI";
        marca[4] = "FERRARI";
        marca[5] = "PORSHE";
        marca[6] = "CADILAC";
        marca[5] = "NISSAN";
        marca[7] = "RENAULT";

        String[] modelo = new String[8];

        modelo[0] = "ULTIMATE";
        modelo[1] = "SPACE";
        modelo[2] = "MEGANE";
        modelo[3] = "MONTERO";
        modelo[4] = "AA3-4";
        modelo[5] = "THUNDERBOLT";
        modelo[6] = "LANDCRUISER";
        modelo[7] = "LAGUNA";

        String[] color = new String[8];

        color[0] = "amarillo";
        color[1] = "AZUL";
        color[2] = "BLANCO";
        color[3] = "PURPURA";
        color[4] = "NARANJA";
        color[5] = "ROJO";
        color[6] = "VERDE";
        color[7] = "SALMÓN";

        double[] tarifa = new double[8];

        tarifa[0] = 100000.02;
        tarifa[0] = 40.0000;
        tarifa[0] = 450.000;
        tarifa[0] = 7.000;
        tarifa[0] = 965.000;
        tarifa[0] = 100.00;
        tarifa[0] = 187.000;
        tarifa[0] = 1.0;

        boolean[] disponible = new boolean[8];

        disponible[0] = true;
        disponible[1] = false;
        disponible[2] = true;
        disponible[3] = false;
        disponible[4] = true;
        disponible[5] = false;
        disponible[6] = true;
        disponible[7] = false;

        Random aleo = new Random();

        int numero = aleo.nextInt(8);
        //Generamos matricula
        String matriculaAux = matricula[numero];
        //generamos marca
        numero = aleo.nextInt(8);
        String marcaAux = marca[numero];

        //generamos modelo
        numero = aleo.nextInt(8);
        String modeloAux = modelo[numero];

        //generamos color
        numero = aleo.nextInt(8);
        String colorAux = color[numero];

        //generamos tarifa
        double tarifaAux = tarifa[numero];

        //generamos disponibilidad
        boolean disponibleAux = disponible[numero];

        //Inicializamos el objeto con los valores generados
        Vehiculo aux = new Vehiculo(matriculaAux, marcaAux, modeloAux, colorAux, tarifaAux, disponibleAux);

        return aux;

    }

    @Override
    public String toString() {
        return matricula + "" + marca + "" + modelo + "" + color + "" + tarifa + "" + disponible;
    }

}
