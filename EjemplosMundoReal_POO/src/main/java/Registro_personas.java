/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.util.Scanner;

/**
 *
 * @author victo
 */
public class Registro_personas {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("+++ Registro de Empleados +++");
        System.out.print("Nombre del empleado: ");
        String nombre = sc.nextLine();

        System.out.print("Tipo de empleado (1 = Gerente, 2 = Programador): ");
        int tipo = sc.nextInt();

        Empleado empleado;

        if (tipo == 1) {
            System.out.print("Ingrese el bono del gerente: ");
            double bono = sc.nextDouble();
            empleado = new Gerente(nombre, bono);
        } else {
            System.out.print("Ingrese las horas trabajadas: ");
            int horas = sc.nextInt();
            System.out.print("Ingrese el pago por hora: ");
            double pagoHora = sc.nextDouble();
            empleado = new Programador(nombre, horas, pagoHora);
        }

        System.out.println("\n--- Detalles del Empleado ---");
        System.out.println("Nombre: " + empleado.getNombre());
        System.out.println("Salario calculado: $" + empleado.calcularSalario());
    }
}

//clase abstracta base
abstract class Empleado {
    private String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    //metodo abstracto q se implementa diferente según el tipo de empleado
    public abstract double calcularSalario();
}

//sbclase gerente
class Gerente extends Empleado {
    private double bono;

    public Gerente(String nombre, double bono) {
        super(nombre);
        this.bono = bono;
    }

    @Override
    public double calcularSalario() {
        return 1500 + bono; //salario base fijo + bono
    }
}

//subclase programador
class Programador extends Empleado {
    private int horasTrabajadas;
    private double pagoPorHora;

    public Programador(String nombre, int horasTrabajadas, double pagoPorHora) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.pagoPorHora = pagoPorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * pagoPorHora;
    }
}