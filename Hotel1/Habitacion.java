/**
 * Esta clase representa una habitacion en el hotel.
 */
public class Habitacion {
    private int numero;            // Numero de la habitacion
    private int capacidadMax;      // Capacidad maxima de personas
    private double precioNoche;    // Precio por noche
    private String tipo;           // Tipo de la habitacion (Estandar, Deluxe, Suite, etc.)
    private boolean ocupada;       // Estado de ocupacion de la habitacion

    /**
     * Constructor para crear un objeto Habitacion.
     *
     * @param numero El numero de la habitacion.
     * @param capacidadMax La capacidad maxima de personas.
     * @param precioNoche El precio por noche de la habitacion.
     * @param tipo El tipo de la habitacion (Estandar, Deluxe, Suite, etc.).
     */
    public Habitacion(int numero, int capacidadMax, double precioNoche, String tipo) {
        this.numero = numero;
        this.capacidadMax = capacidadMax;
        this.precioNoche = precioNoche;
        this.tipo = tipo;
        this.ocupada = false;
    }

    /**
     * Obtiene el numero de la habitacion.
     *
     * @return El numero de la habitacion.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Obtiene la capacidad maxima de personas.
     *
     * @return La capacidad maxima de personas.
     */
    public int getCapacidadMax() {
        return capacidadMax;
    }

    /**
     * Obtiene el precio por noche de la habitacion.
     *
     * @return El precio por noche de la habitacion.
     */
    public double getPrecioNoche() {
        return precioNoche;
    }

    /**
     * Obtiene el tipo de la habitacion.
     *
     * @return El tipo de la habitacion.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Verifica si la habitacion esta disponible.
     *
     * @return `true` si la habitacion esta disponible, `false` en caso contrario.
     */
    public boolean disponible() {
        return !ocupada;
    }

    /**
     * Asigna la habitacion a un cliente si es posible.
     *
     * @param cliente El cliente al que se asignara la habitacion.
     * @param cantidadOcu La cantidad de personas que se hospedaran.
     * @return `true` si la habitacion se asigno con exito, `false` si no se pudo asignar.
     */
    public boolean asignar(Cliente cliente, int cantidadOcu) {
        if (!ocupada && capacidadMax >= cantidadOcu && cliente.clasificacionValida(this)) {
            this.ocupada = true;
            cliente.setCantidadOcu(cantidadOcu);
            return true;
        }
        return false;
    }

    /**
     * Verifica si la clasificacion del cliente es valida para la habitacion.
     *
     * @param cliente El cliente cuya clasificacion se verificara.
     * @return `true` si la clasificacion es valida, `false` en caso contrario.
     */
    public boolean clasificacionValidaCliente(Cliente cliente) {
        if (cliente.getClasificacion().equals("VIP") && (tipo.equals("Suite") || tipo.equals("Deluxe") || tipo.equals("Estandar"))) {
            return true;
        } else if (cliente.getClasificacion().equals("Frecuente") && (tipo.equals("Deluxe") || tipo.equals("Estandar"))) {
            return true;
        } else if (cliente.getClasificacion().equals("Regular") && tipo.equals("Estandar")) {
            return true;
        }
        return false;
    }
}