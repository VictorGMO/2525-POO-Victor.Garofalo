/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana_6;
//mi programa simula un sistema de transporte urbano aplicando herencia,encapsulación y polimorfismo en Java.

/**
 *
 * @author victo
 */
public class SEMANA_6 {

    public static void main(String[] args) {
        //objetos de cada tipo de vehículo
        Bus bus = new Bus(50, 40, "Carlos");
        Taxi taxi = new Taxi(60, 4, "Maria");
        Bicicleta bici = new Bicicleta(20, 1, "Luis");

        //polimorfismo yy otros metodos
        bus.moverse();
        bus.recogerPasajeros();
        bus.detenerse();
        System.out.println();

        taxi.moverse();
        taxi.cobrarPasaje();
        taxi.detenerse();
        System.out.println();

        bici.moverse();
        bici.tocarTimbre();
        bici.detenerse();
    }
}

class Vehiculo {
    //encapsulación
    private int velocidad;
    private int capacidad;
    private String conductor;


    public Vehiculo(int velocidad, int capacidad, String conductor) {
        this.velocidad = velocidad;
        this.capacidad = capacidad;
        this.conductor = conductor;
    }

    //metodos get y set
    public int getVelo() {
        return velocidad;
    }
    public void setVelo(int velocidad) {
        this.velocidad = velocidad;
    }
    public int getCapac() {
        return capacidad;
    }
    public void setCapac(int capacidad) {
        this.capacidad = capacidad;
    }
    public String getConduc() {
        return conductor;
    }
    public void setConduc(String conductor) {
        this.conductor = conductor;
    }

    //polimorfis
    public void moverse() {
        System.out.println("El vehiculo se esta moviendo...");
    }

    public void detenerse() {
        System.out.println("El vehiculo se ha detenido.");
    }
}


class Bus extends Vehiculo {
    public Bus(int velocidad, int capacidad, String conductor) {
        super(velocidad, capacidad, conductor);
    }

    @Override
    public void moverse() {
        System.out.println("El bus manejado por " + getConduc() + " se mueve por la ruta urbana");
    }

    public void recogerPasajeros() {
        System.out.println("El bus esta recogiendo pasajeros. Capacidad: " + getCapac());
    }
}


class Taxi extends Vehiculo {
    public Taxi(int velocidad, int capacidad, String conductor) {
        super(velocidad, capacidad, conductor);
    }

    @Override
    public void moverse() {
        System.out.println("El taxi conducido por " + getConduc() + " esta llevando a un pasajero");
    }

    public void cobrarPasaje() {
        System.out.println("El taxi ha cobrado el pasaje");
    }
}


class Bicicleta extends Vehiculo {
    public Bicicleta(int velocidad, int capacidad, String conductor) {
        super(velocidad, capacidad, conductor);
    }

    @Override
    public void moverse() {
        System.out.println("La bicicleta de " + getConduc() + " avanza por el carril bici");
    }

    public void tocarTimbre() {
        System.out.println("¡rin riin! La bicicleta ha tocado el timbre");
    
    }
}
