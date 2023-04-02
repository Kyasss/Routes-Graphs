package Logic;

/**
 * La clase Route representa una ruta que va desde una ubicación de inicio hasta
 * una ubicación de fin. Cada ruta tiene una distancia y un tiempo estimado que
 * se calculan automáticamente al crear una nueva ruta.
 *
 * @author Numar Vargas Martín.
 * @version 1.0
 */
public class Route {

    private Location startLocation;
    private Location endLocation;
    private double distance;
    private double time;

    /**
     * Crea una nueva ruta con una ubicación de inicio y una ubicación de fin.
     * La distancia y el tiempo estimado se calculan automáticamente.
     *
     * @param startLocation la ubicación de inicio de la ruta
     * @param endLocation   la ubicación de fin de la ruta
     */
    public Route(Location startLocation, Location endLocation) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = calculateDistance();
        this.time = calculateTime();
    }

    /**
     * Devuelve la ubicación de inicio de la ruta.
     *
     * @return la ubicación de inicio de la ruta
     */
    public Location getStartLocation() {
        return startLocation;
    }

    /**
     * Establece la ubicación de inicio de la ruta.
     *
     * @param startLocation la nueva ubicación de inicio de la ruta
     */
    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * Devuelve la ubicación de fin de la ruta.
     *
     * @return la ubicación de fin de la ruta
     */
    public Location getEndLocation() {
        return endLocation;
    }

    /**
     * Establece la ubicación de fin de la ruta.
     *
     * @param endLocation la nueva ubicación de fin de la ruta
     */
    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * Devuelve la distancia entre las dos ubicaciones de la ruta.
     *
     * @return la distancia en km entre las dos ubicaciones
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Establece la distancia entre las dos ubicaciones de la ruta.
     *
     * @param distance la nueva distancia en km entre las dos ubicaciones
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Devuelve el tiempo estimado para recorrer la distancia de la ruta.
     *
     * @return el tiempo estimado en horas para recorrer la distancia de la ruta
     */
    public double getTime() {
        return time;
    }

    /**
     * Establece el tiempo estimado para recorrer la distancia de la ruta.
     *
     * @param time el nuevo tiempo estimado en horas para recorrer la distancia
     *             de la ruta
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Calcula la distancia en km entre las dos ubicaciones de la ruta
     * utilizando la fórmula del haversine.
     *
     * @return la distancia en km entre las dos ubicaciones
     */
    private double calculateDistance() {
        double dLat = Math.toRadians(endLocation.getLatitude() - startLocation.getLatitude());
        double dLon = Math.toRadians(endLocation.getLength() - startLocation.getLength());
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(startLocation.getLatitude())) * Math.cos(Math.toRadians(endLocation.getLatitude()))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return 6371 * c;
    }

    /**
     * Calcula el tiempo estimado para recorrer la ruta, basado en una velocidad
     * promedio de 50 km/h.
     *
     * @return El tiempo estimado para recorrer la ruta.
     */
    private double calculateTime() {
        double speed = 50; // km/h
        return distance / speed;
    }

}
