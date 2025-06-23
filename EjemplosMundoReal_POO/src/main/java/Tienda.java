
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author victo
 */
public class Tienda {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //productos disponibles en la tienda
        Producto[] productosDisponibles = {
            new Producto("Laptop", 1200, 10),
            new Producto("Teléfono", 800, 15),
            new Producto("Mouse", 25, 50)
        };

        //carrito con capacidad para 5 productos diferentes
        CarritoDeCompras carrito = new CarritoDeCompras(5);

        System.out.println("=== Bienvenido a la Tienda ===");

        int opcion;
        do {
            //los productos disponibles
            System.out.println("\nProductos disponibles:");
            for (int i = 0; i < productosDisponibles.length; i++) {
                System.out.println((i + 1) + ". " + productosDisponibles[i]);
            }
            System.out.println("0. Finalizar compra");

            //elegir
            System.out.print("Elige un producto (1-3) o 0 para salir: ");
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= productosDisponibles.length) {
                Producto elegido = productosDisponibles[opcion - 1];

                
                System.out.print("¿Cuántos deseas comprar?: ");
                int cantidad = sc.nextInt();

                //agregar cosas
                carrito.agregarProducto(elegido, cantidad);
            } else if (opcion != 0) {
                System.out.println("Opción inválida.");
            }

        } while (opcion != 0); //repetira

        //contenido final
        carrito.mostrarCarrito();
        System.out.println("Total a pagar: $" + carrito.calcularTotal());

        //como quedó el stock
        System.out.println("\n=== Stock actualizado ===");
        for (Producto p : productosDisponibles) {
            System.out.println(p);
        }
    }
}

//representa un producto en la tienda
class Producto {
    private String nombre;
    private double precio;
    private int cantidadEnStock;

 
    public Producto(String nombre, double precio, int cantidadEnStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }

    //encapsulamiento?
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    //reduce el stock si hay suficiente
    public void reducirStock(int cantidad) {
        if (cantidad <= cantidadEnStock) {
            cantidadEnStock -= cantidad;
        } else {
            System.out.println("No hay suficiente stock para " + nombre);
        }
    }

 
    public String toString() {
        return nombre + " - Precio: $" + precio + " - Stock: " + cantidadEnStock;
    }
}

//guarda los productos que el usuario compra
class CarritoDeCompras {
    private Producto[] productos;
    private int[] cantidades;
    private int cantidadActual;

    //constructor con tamaño max
    public CarritoDeCompras(int tamañoMaximo) {
        productos = new Producto[tamañoMaximo];
        cantidades = new int[tamañoMaximo];
        cantidadActual = 0;
    }

    //agrega si hay espacio y stock
    public void agregarProducto(Producto producto, int cantidad) {
        if (cantidadActual >= productos.length) {
            System.out.println("El carrito está lleno. No se pueden agregar más productos distintos.");
            return;
        }

        if (cantidad > 0 && cantidad <= producto.getCantidadEnStock()) {
            productos[cantidadActual] = producto;
            cantidades[cantidadActual] = cantidad;
            cantidadActual++;
            producto.reducirStock(cantidad);
            System.out.println("Agregado: " + cantidad + " x " + producto.getNombre());
        } else {
            System.out.println("Stock insuficiente para " + producto.getNombre());
        }
    }

    //muestra los productos dentro del carrito
    public void mostrarCarrito() {
        System.out.println("\n=== Contenido del Carrito ===");
        for (int i = 0; i < cantidadActual; i++) {
            Producto p = productos[i];
            int cant = cantidades[i];
            System.out.println(p.getNombre() + " - Cantidad: " + cant + " - Subtotal: $" + (p.getPrecio() * cant));
        }
    }

    //calcula el total
    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < cantidadActual; i++) {
            total += productos[i].getPrecio() * cantidades[i];
        }
        return total;
    }
}