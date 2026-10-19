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
    static String nombre = "";

    /**
     * Funcion que coordina la ejecucion del programa de aparcamiento.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("          PARKING DAM-PRO          ");
        System.out.println("===================================");
        System.out.println(" ");

        System.out.print("Nombre de usuario: ");
        nombre = teclado.nextLine();
        System.out.println(" ");

        mostrarMenu();

        teclado.close();
    }

    /**
     * Funcion que muestra las opciones disponibles del menu.
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
                    int cantidad = leerEnteroPositivo(teclado, "¿Cuantos vehiculos quieres registrar? ");
                    int horasOperacion = registrarVehiculos(teclado, cantidad);
                    totalVehiculos += cantidad;
                    totalHorasRegistradas += horasOperacion;
                    break;
                case 2:
                    int horasTarifa = leerEnteroPositivo(teclado, "Horas para calcular la tarifa: ");
                    float importe = calcularTarifa(horasTarifa, tarifaHora);
                    totalCalculosTarifa++;
                    importeTotalCalculado += importe;
                    System.out.println("Importe: " + importe + " euros");
                    System.out.println(" ");
                    break;
                case 3:
                    mostrarResumen(nombre, totalVehiculos, totalHorasRegistradas, totalCalculosTarifa, importeTotalCalculado);
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
     * Funcion que pide y valida un entero positivo.
     *
     * @param teclado Scanner para obtener datos del usuario
     * @param mensaje String que se muestra al solicitar el dato
     * @return int numero entero positivo validado
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
     * Funcion que registra una cantidad conocida de vehiculos pidiendo su matricula y horas estacionadas.
     *
     * @param teclado Scanner para obtener datos del usuario
     * @param cantidad int vehiculos a registrar
     * @return int total de horas registradas en esta operacion
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

    /**
     * Funcion que calcula el importe total de un estacionamiento.
     *
     * @param horas int de estacionamiento
     * @param tarifaHora float precio por cada hora de estacionamiento
     * @return float importe total calculado
     */
    public static float calcularTarifa(int horas, float tarifaHora) {
        return horas * tarifaHora;
    }

    /**
     * Funcion que muestra el resumen de la sesion con los datos acumulados.
     *
     * @param nombre String nombre del usuario del parking
     * @param totalVehiculos int total de vehiculos registrados
     * @param totalHorasRegistradas int total de horas registradas
     * @param totalCalculosTarifa int cantidad de calculos de tarifa realizados
     * @param importeTotalCalculado float importe total acumulado
     */
    public static void mostrarResumen(String nombre, int totalVehiculos, int totalHorasRegistradas, int totalCalculosTarifa, float importeTotalCalculado) {
        System.out.println("=== RESUMEN ===");
        System.out.println("Usuario: " + nombre);
        System.out.println("Vehiculos registrados: " + totalVehiculos);
        System.out.println("Horas registradas: " + totalHorasRegistradas);
        System.out.println("Calculos de tarifas: " + totalCalculosTarifa);
        System.out.println("Importe total calculado: " + importeTotalCalculado + " euros");
        System.out.println("");
    }
}
