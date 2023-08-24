/**
 * Esta clase representa un hotel que administra habitaciones y clientes.
 * Tuve que añadir clases y muchas otras cosas más que no incluí en mi análisis original, porque no logré hacer que el sistema de reservaciones funcionara sin lo que agregué. 
 * Además, tuve que crear una nueva clase para las reservaciones, ya que la idea que tenía para insertarlas generaba conflictos en el código.
 */

import java.util.Scanner;

public class Hotel {
    private Habitacion[] habitaciones;
    private Cliente[] clientes;
    private int numClientes;

    /**
     * Constructor para crear un objeto Hotel.
     *
     * @param habitaciones Arreglo de habitaciones disponibles en el hotel.
     */
    public Hotel(Habitacion[] habitaciones) {
        this.habitaciones = habitaciones;
        this.clientes = new Cliente[10];
        this.numClientes = 0;
    }

    /**
     * Busca una habitacion disponible que cumpla con los requisitos del cliente.
     *
     * @param cantidadOcu Cantidad de personas que se hospedaran.
     * @param cliente Cliente que busca la habitacion.
     * @return La habitacion disponible que cumple con los requisitos, o null si no hay ninguna.
     */
    public Habitacion buscarHab(int cantidadOcu, Cliente cliente) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.disponible() && habitacion.getCapacidadMax() >= cantidadOcu && cliente.clasificacionValida(habitacion)) {
                return habitacion;
            }
        }
        return null;
    }

    /**
     * Agrega un nuevo cliente al hotel.
     *
     * @param nombre Nombre del cliente.
     * @param visitas Cantidad de veces que ha visitado el hotel.
     * @param cantidadOcu Cantidad de personas que se hospedarán.
     */
    public void agregarCliente(String nombre, int visitas, int cantidadOcu) {
        if (numClientes < clientes.length) {
            clientes[numClientes] = new Cliente(nombre, visitas, cantidadOcu);
            numClientes++;
        } else {
            System.out.println("La lista de clientes está llena.");
        }
    }

    /**
     * Busca una habitacion por su número.
     *
     * @param numeroHabitacion Número de la habitación a buscar.
     * @param habitaciones Arreglo de habitaciones disponibles en el hotel.
     * @return La habitación con el número especificado, o null si no se encuentra.
     */
    private static Habitacion buscarHabitacionPorNumero(int numeroHabitacion, Habitacion[] habitaciones) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numeroHabitacion) {
                return habitacion;
            }
        }
        return null;
    }

    /**
     * Clase principal que ejecuta el programa de gestión de un hotel.
     */
    public static void main(String[] args) {
        Habitacion[] habitaciones = {
            new Habitacion(1, 2, 100.0, "Estandar"),
            new Habitacion(2, 4, 150.0, "Deluxe"),
            new Habitacion(3, 6, 200.0, "Suite"),
            new Habitacion(4, 2, 110.0, "Estandar"),
            new Habitacion(5, 2, 110.0, "Deluxe"),
            new Habitacion(6, 2, 110.0, "Estandar"),
            new Habitacion(7, 2, 110.0, "Deluxe"),
            new Habitacion(8, 2, 110.0, "Estandar"),
            new Habitacion(9, 4, 160.0, "Deluxe"),
            new Habitacion(10, 4, 160.0, "Estandar"),
            new Habitacion(11, 4, 160.0, "Deluxe"),
            new Habitacion(12, 4, 160.0, "Estandar"),
            new Habitacion(13, 4, 160.0, "Deluxe"),
            new Habitacion(14, 6, 220.0, "Estandar"),
            new Habitacion(15, 6, 220.0, "Deluxe"),
            new Habitacion(16, 6, 220.0, "Suite"),
            new Habitacion(17, 6, 220.0, "Deluxe"),
            new Habitacion(18, 6, 220.0, "Estandar")
        };

        // Inicializar el hotel con las habitaciones
        Hotel hotel = new Hotel(habitaciones);
        Scanner scanner = new Scanner(System.in);

        Cliente clienteActual = null;

        while (true) {
            System.out.println("Bienvenido al hotel. Seleccione una opción:");
            System.out.println("1. Realizar reserva");
            System.out.println("2. Asignar habitaciones");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();

            if (opcion == 1) {
                // Realizar reserva
                System.out.println("Ingrese su nombre:");
                String nombre = scanner.next();

                System.out.println("Ingrese la cantidad de veces que ha visitado el hotel:");
                int visitas = scanner.nextInt();

                System.out.println("Ingrese la cantidad de personas que se hospedarán:");
                int cantidadOcu = scanner.nextInt();

                // Agregar cliente al sistema
                hotel.agregarCliente(nombre, visitas, cantidadOcu);
                clienteActual = hotel.clientes[hotel.numClientes - 1];
                System.out.println("Cliente registrado con éxito.");
            }

            if (opcion == 2) {
                // Asignar habitaciones
                if (clienteActual != null) {
                    // Obtener información del cliente actual
                    System.out.println("Ingrese su nombre:");
                    String nombreCliente = scanner.next();

                    // Buscar cliente en la lista
                    Cliente clienteBuscado = null;
                    for (Cliente cliente : hotel.clientes) {
                        if (cliente != null && cliente.getNombre().equals(nombreCliente)) {
                            clienteBuscado = cliente;
                            break;
                        }
                    }

                    if (clienteBuscado == null) {
                        System.out.println("Cliente no encontrado.");
                    } else {
                        // Mostrar información del cliente
                        System.out.println("Información del cliente:");
                        System.out.println("Nombre: " + clienteBuscado.getNombre());
                        System.out.println("Visitas: " + clienteBuscado.getVisitas());
                        System.out.println("Cantidad de personas: " + clienteBuscado.getCantidadOcu());
                        System.out.println("Clasificación: " + clienteBuscado.getClasificacion());

                        // Mostrar habitaciones disponibles para el cliente
                        System.out.println("Habitaciones disponibles para el cliente:");
                        for (Habitacion habitacion : habitaciones) {
                            if (clienteBuscado.clasificacionValida(habitacion)) {
                                System.out.println("Número de Habitación: " + habitacion.getNumero());
                                System.out.println("Capacidad máxima: " + habitacion.getCapacidadMax());
                                System.out.println("Tipo de habitación: " + habitacion.getTipo());
                                System.out.println("Precio por noche: " + habitacion.getPrecioNoche());
                                System.out.println(); // Espacio en blanco para separar las habitaciones
                            }
                        }

                        // Solicitar número de habitación para asignación
                        System.out.println("Ingrese el numero de Habitacion:");
                        int numeroHabitacion = scanner.nextInt();

                        // Buscar habitación por número
                        Habitacion habitacionSeleccionada = buscarHabitacionPorNumero(numeroHabitacion, habitaciones);

                        // Verificar si la habitación es válida para la reserva
                        if (habitacionSeleccionada != null && habitacionSeleccionada.disponible() && habitacionSeleccionada.getCapacidadMax() >= clienteBuscado.getCantidadOcu()) {
                            boolean asignado = habitacionSeleccionada.asignar(clienteBuscado, clienteBuscado.getCantidadOcu());
                            if (asignado) {
                                System.out.println("Habitación asignada.");
                            } else {
                                System.out.println("No se pudo asignar la habitacion en este momento.");
                            }
                        } else {
                            System.out.println("Habitacion no valida para realzar la reserva.");
                        }
                    }
                } else {
                    System.out.println("No se ha registrado ningun cliente aun.");
                }
            }

            if (opcion == 3) {
                System.out.println("Gracias por usar el programa.");
                break;
            } else {
                System.out.println("Opcian no valida.");
            }
        }
    }
}