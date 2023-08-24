/**
 * La clase Cliente representa a un cliente del hotel con sus atributos y métodos asociados.
 */
public class Cliente {
    private String nombre;
    private int visitas;
    private int cantidadOcu;
    private String clasificacion;
    private Reserva[] reservas; // Arreglo para almacenar las reservas

    /**
     * Constructor para inicializar un objeto Cliente.
     *
     * @param nombre Nombre del cliente.
     * @param visitas Cantidad de veces que el cliente ha visitado el hotel.
     * @param cantidadOcu Cantidad de personas que se hospedarán.
     */
    public Cliente(String nombre, int visitas, int cantidadOcu) {
        this.nombre = nombre;
        this.visitas = visitas;
        this.cantidadOcu = cantidadOcu;
        this.clasificacion = clasificacion();
        this.reservas = new Reserva[10]; // Crear un arreglo para almacenar hasta 10 reservas
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la cantidad de visitas del cliente al hotel.
     *
     * @return La cantidad de visitas del cliente.
     */
    public int getVisitas() {
        return visitas;
    }

    /**
     * Obtiene la cantidad de personas que se hospedarán.
     *
     * @return La cantidad de personas que se hospedarán.
     */
    public int getCantidadOcu() {
        return cantidadOcu;
    }

    /**
     * Obtiene la clasificación del cliente según su historial de visitas.
     *
     * @return La clasificación del cliente (VIP, Frecuente o Regular).
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * Establece la cantidad de personas que se hospedarán.
     *
     * @param cantidadOcu La cantidad de personas que se hospedarán.
     */
    public void setCantidadOcu(int cantidadOcu) {
        this.cantidadOcu = cantidadOcu;
    }

    /**
     * Determina la clasificación del cliente según la cantidad de visitas.
     *
     * @return La clasificación del cliente (VIP, Frecuente o Regular).
     */
    private String clasificacion() {
        if (visitas >= 10) {
            return "VIP";
        } else if (visitas >= 5) {
            return "Frecuente";
        } else {
            return "Regular";
        }
    }

    /**
     * Verifica si la clasificación del cliente permite acceder a una habitación específica.
     *
     * @param habitacion La habitación a verificar.
     * @return true si la clasificación del cliente es válida para la habitación, false en caso contrario.
     */
    public boolean clasificacionValida(Habitacion habitacion) {
        return habitacion.clasificacionValidaCliente(this);
    }

    /**
     * Agrega una reserva a la lista de reservas del cliente.
     *
     * @param reserva La reserva a agregar.
     */
    public void agregarReserva(Reserva reserva) {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] == null) {
                reservas[i] = reserva;
                break;
            }
        }
    }

    /**
     * Obtiene la reserva correspondiente al número de reservación proporcionado.
     *
     * @param numeroReservacion El número de reservación.
     * @return La reserva correspondiente, o null si no existe.
     */
    public Reserva getReserva(int numeroReservacion) {
        if (numeroReservacion >= 0 && numeroReservacion < reservas.length) {
            return reservas[numeroReservacion];
        }
        return null;
    }
}