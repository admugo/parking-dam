package ies.puerto;

import java.util.Scanner;

/**
 * Clase principal del programa PARKING DAM-PRO.
 * Gestiona el registro de vehiculos, calculo de tarifas y resumen de sesion.
 *
 * @author admugo
 * @version 1.0.0
 */
public class Parking {
    static Scanner teclado = new Scanner(System.in);
    static float tarifaHora = 1.50f;
    static int totalVehiculos = 0;
    static int totalHorasRegistradas = 0;
    static int totalCalculosTarifa = 0;
    static float importeTotalCalculado = 0f;

    /**
     * Coordina la ejecucion del programa de aparcamiento.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("          PARKING DAM-PRO          ");
        System.out.println("===================================");
        System.out.println(" ");

        System.out.print("Nombre de usuario: ");
        String nombre = teclado.nextLine();
        System.out.println(" ");

        mostrarMenu();

        teclado.close();
    }

    /**
     * Muestra las opciones disponibles del menu.
     */
    static void mostrarMenu(){
        int opcion = 0;
        boolean salir = false;

        do {
            System.out.println("1. Registrar vehículos");
            System.out.println("2. Calcular tarifa de estacionamiento");
            System.out.println("3. Mostrar resumen del día");
            System.out.println("4. Salir");
            System.out.println(" ");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();

            String mensaje = "";

            switch (opcion) {
                case 1:
                    int cantidad = leerEnteroPositivo(teclado, "Cuantos vehiculos quieres registrar? ");
                    int horasOperacion = registrarVehiculos(teclado, cantidad);
                    totalVehiculos += cantidad;
                    totalHorasRegistradas += horasOperacion;
                    break;
                case 2:
                    // Calcular tarifa de estacionamiento
                    break;
                case 3:
                    // Mostrar resumen del día
                    break;
                case 4:
                    System.out.println("Gracias por utilizar PARKING DAM-PRO");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (!salir);

        teclado.close();
    }

    /**
     * Funcion que pide y valida un entero positivo
     *
     * @param teclado Scanner para obtener datos del usuario
     * @param mensaje String que se muestra al solicitar el dato
     * @return numero entero positivo validado
     */
    public static int leerEnteroPositivo(Scanner teclado, String mensaje){
        int numero = 0;
        do {
            System.out.print(mensaje);
            numero = teclado.nextInt();
            if (numero <= 0) {
                System.out.println("Debe de ser un entero positivo.");
            }
        } while (numero <= 0);
        teclado.nextLine();
        return numero;
    }

    /**
     * Registra una cantidad conocida de vehiculos pidiendo su matricula y horas estacionadas.
     *
     * @param teclado Scanner para obtener datos del usuario
     * @param cantidad int vehiculos a registrar
     * @return total de horas registradas en esta operacion
     */
    public static int registrarVehiculos(Scanner teclado, int cantidad) {
        int horasTotalesOperacion = 0;

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("Vehiculo " + i);

            System.out.print("Matricula: ");
            String matricula = teclado.nextLine();

            int horas = leerEnteroPositivo(teclado, "Horas estacionadas: ");
            System.out.println(" ");

            horasTotalesOperacion += horas;
        }

        System.out.println("Vehiculos registrados en esta operacion: " + cantidad);
        return horasTotalesOperacion;
    }

}
