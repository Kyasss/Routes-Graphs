package Logic;

/**
 * La clase Location representa una ubicación geográfica con un nombre, una
 * latitud y una longitud.
 *
 * @author Numar Vargas Martín.
 * @version 1.0
 */
public class Location {

    private String name;
    private double latitude;
    private double length;

    /**
     * Crea una nueva ubicación con el nombre, la latitud y la longitud
     * especificados.
     *
     * @param name     El nombre de la ubicación.
     * @param latitude La latitud de la ubicación.
     * @param length   La longitud de la ubicación.
     */
    public Location(String name, double latitude, double length) {
        this.name = name;
        this.latitude = latitude;
        this.length = length;
    }

    /**
     * Devuelve el nombre de la ubicación.
     *
     * @return El nombre de la ubicación.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre de la ubicación.
     *
     * @param name El nuevo nombre de la ubicación.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve la latitud de la ubicación.
     *
     * @return La latitud de la ubicación.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Establece la latitud de la ubicación.
     *
     * @param latitude La nueva latitud de la ubicación.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Devuelve la longitud de la ubicación.
     *
     * @return La longitud de la ubicación.
     */
    public double getLength() {
        return length;
    }

    /**
     * Establece la longitud de la ubicación.
     *
     * @param length La nueva longitud de la ubicación.
     */
    public void setLength(double length) {
        this.length = length;
    }
}
