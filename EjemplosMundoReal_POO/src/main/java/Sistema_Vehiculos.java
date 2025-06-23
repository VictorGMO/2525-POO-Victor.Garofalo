
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author victo
 */
public class Sistema_Vehiculos {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(":::: Registro de Vehículos :::::");
        System.out.print("Ingrese el tipo de vehículo (1 = Auto, 2 = Moto, 3 = Camión): ");
        int tipo = sc.nextInt();

        sc.nextLine(); //limpia

        System.out.print("Marca del vehículo: ");
        String marca = sc.nextLine();

        System.out.print("modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Año: ");
        int anio = sc.nextInt();

        Vehiculo vehiculo;

        switch (tipo) {
            case 1:
                vehiculo = new Auto(marca, modelo, anio);
                break;
            case 2:
                vehiculo = new Moto(marca, modelo, anio);
                break;
            case 3:
                vehiculo = new Camion(marca, modelo, anio);
                break;
            default:
                System.out.println("Tipo inválido. Se asignará Auto por defecto.");
                vehiculo = new Auto(marca, modelo, anio);
        }

        System.out.println("\n--- Información del Vehículo ---");
        vehiculo.mostrarDatos();
        System.out.println("Impuesto estimado: $" + vehiculo.calcularImpuesto());
    }
}


abstract class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;

    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void mostrarDatos() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anio);
    }

    //metodo para cada subclase
    public abstract double calcularImpuesto();
}

//subclase auto
class Auto extends Vehiculo {
    public Auto(String marca, String modelo, int anio) {
        super(marca, modelo, anio);
    }

    @Override
    public double calcularImpuesto() {
        return 300.0;
    }
}

//subclase moto
class Moto extends Vehiculo {
    public Moto(String marca, String modelo, int anio) {
        super(marca, modelo, anio);
    }

    @Override
    public double calcularImpuesto() {
        return 100.0;
    }
}

//subclase cmion
class Camion extends Vehiculo {
    public Camion(String marca, String modelo, int anio) {
        super(marca, modelo, anio);
    }

    @Override
    public double calcularImpuesto() {
        return 500.0;
    }
}
