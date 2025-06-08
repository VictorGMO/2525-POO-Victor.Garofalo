/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana_2;

/**
 *
 * @author victo
 */


public class Semana_2 {

    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero("Panchito", 20, 10, 5, 100, 8);  //decl obj
        Mago mago = new Mago("Megumin", 5, 15, 3, 100, 6);

        guerrero.mostrarAtributos();  //llam metodo
        mago.mostrarAtributos();

        System.out.println("\n--- ¡Comienza la batalla! ---");
        while (guerrero.estaVivo() && mago.estaVivo()) {
            guerrero.atacar(mago);
            if (mago.estaVivo()) {
                mago.atacar(guerrero);
            }
            System.out.println("------------------");
        }

        if (guerrero.estaVivo()) {
            System.out.println("Panchito ha ganado");
        } else if (mago.estaVivo()) {
            System.out.println("Megumin ha ganado");
        } else {
            System.out.println("¡Empate!");
        }
    }
}

// Clase base que representa abtraccion (solo muestra lo esencial del personaje)
class Personaje {
    // ENCAPSULACIÓN: los atributos están protegidos (con protected o private)
    protected String nombre;
    protected int fuerza, inteligencia, defensa, vida;


    public Personaje(String nombre, int fuerza, int inteligencia, int defensa, int vida) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.defensa = defensa;
        this.vida = vida;
    }

    public void mostrarAtributos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Inteligencia: " + inteligencia);
        System.out.println("Defensa: " + defensa);
        System.out.println("Vida: " + vida);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void recibirDaño(int dano) {
        vida -= dano;
        if (vida <= 0) {
            vida = 0;
            System.out.println(nombre + " ha muerto");
        } else {
            System.out.println(nombre + " tiene " + vida + " de vida restante");
        }
    }

    // POLIMORFISMO: este método será sobreescrito por las subclases
    public int calcularDaño(Personaje enemigo) {
        return fuerza - enemigo.defensa;
    }

    public void atacar(Personaje enemigo) {
        int dano = calcularDaño(enemigo);
        System.out.println(nombre + " ataca a " + enemigo.nombre + " causando " + dano + " de dano");
        enemigo.recibirDaño(dano);
    }
}

// HERENCIA: Guerrero hereda de Personaje
class Guerrero extends Personaje {
    private int espada;

    public Guerrero(String nombre, int fuerza, int inteligencia, int defensa, int vida, int espada) {
        super(nombre, fuerza, inteligencia, defensa, vida);
        this.espada = espada;
    }

    // POLIMORFISMO:se sobrescribe el método calcularDaño
    @Override
    public int calcularDaño(Personaje enemigo) {
        return (espada * 2) + super.calcularDaño(enemigo);
    }
}

// HERENCIA: Mago hereda de Personaje
class Mago extends Personaje {
    private int libroMagico;

    public Mago(String nombre, int fuerza, int inteligencia, int defensa, int vida, int libroMagico) {
        super(nombre, fuerza, inteligencia, defensa, vida);
        this.libroMagico = libroMagico;
    }

    // POLIMORFISMO: se sobrescribe el método calcularDaño
    @Override
    public int calcularDaño(Personaje enemigo) {
        return (libroMagico * 3) + super.calcularDaño(enemigo);
    }
}
