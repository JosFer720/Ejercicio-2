/**
 * Esta clase representa una reserva en el hotel.
 */
public class Reserva {
    private Cliente cliente;      // Cliente asociado a la reserva
    private int cantidadOcu;      // Cantidad de personas que se hospedaran
    private String tipo;          // Tipo de la reserva (Estandar, Deluxe, Suite, etc.)
    private Habitacion habitacion; // Habitacion reservada

    /**
     * Constructor para crear un objeto Reserva.
     *
     * @param cliente El cliente asociado a la reserva.
     * @param cantidadOcu La cantidad de personas que se hospedaran.
     * @param tipo El tipo de la reserva (Estandar, Deluxe, Suite, etc.).
     * @param habitacion La habitacion reservada.
     */
    public Reserva(Cliente cliente, int cantidadOcu, String tipo, Habitacion habitacion) {
        this.cliente = cliente;
        this.cantidadOcu = cantidadOcu;
        this.tipo = tipo;
        this.habitacion = habitacion;
    }

    /**
     * Obtiene el cliente asociado a la reserva.
     *
     * @return El cliente asociado a la reserva.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Obtiene la cantidad de personas que se hospedaran.
     *
     * @return La cantidad de personas que se hospedaran.
     */
    public int getCantidadOcu() {
        return cantidadOcu;
    }

    /**
     * Obtiene el tipo de la reserva.
     *
     * @return El tipo de la reserva.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene la habitacion reservada.
     *
     * @return La habitacion reservada.
     */
    public Habitacion getHabitacion() {
        return habitacion;
    }
}