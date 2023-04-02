package Logic;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * La clase Control maneja la lógica del programa, en la cual se inicializan las
 * ciudades y las rutas entre ellas, se crea el grafo que representa la red de
 * carreteras, se utiliza el algoritmo de Dijkstra para encontrar la rutamás
 * corta entre dos ciudades y se lanza la interfaz gráfica del programa.
 *
 * @author Numar Vargas Martín.
 * @version 1.0
 */
public class Control {

    private List<Location> cities;
    private List<Route> routes;
    private Graph<Location, DefaultWeightedEdge> graph;
    private DijkstraShortestPath<Location, DefaultWeightedEdge> dijkstra;
    private GraphPath<Location, DefaultWeightedEdge> shortestPath;

    /**
     * Constructor de la clase Control, inicializa las ciudades y las rutas
     * entre ellas, y crea el grafo que representa la red de carreteras.
     */
    public Control() {
        this.cities = new ArrayList<>(Arrays.asList(
                new Location("Bogotá", 4.710989, -74.072092),
                new Location("Medellín", 6.244203, -75.581211),
                new Location("Cali", 3.451646, -76.531983),
                new Location("Barranquilla", 10.963889, -74.796389),
                new Location("Cartagena", 10.391049, -75.479426),
                new Location("Bucaramanga", 7.129056, -73.125361),
                new Location("Cúcuta", 7.893907, -72.50782),
                new Location("Santa Marta", 11.240355, -74.211052),
                new Location("Pereira", 4.814278, -75.696146),
                new Location("Villavicencio", 4.142002, -73.626637)
        ));

        this.routes = new ArrayList<>(Arrays.asList(
                new Route(cities.get(0), cities.get(1)),
                new Route(cities.get(0), cities.get(2)),
                new Route(cities.get(1), cities.get(2)),
                new Route(cities.get(1), cities.get(3)),
                new Route(cities.get(2), cities.get(3)),
                new Route(cities.get(0), cities.get(3)),
                new Route(cities.get(0), cities.get(4)),
                new Route(cities.get(1), cities.get(6)),
                new Route(cities.get(3), cities.get(7)),
                new Route(cities.get(4), cities.get(7)),
                new Route(cities.get(0), cities.get(9))
        ));

        graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        for (Location city : cities) {
            graph.addVertex(city);
        }

        for (Route route : routes) {
            graph.addEdge(route.getStartLocation(), route.getEndLocation());
            graph.setEdgeWeight(graph.getEdge(route.getStartLocation(), route.getEndLocation()), route.getDistance());
        }
    }

    /**
     * Método para encontrar la ruta más corta entre dos ciudades utilizando el
     * algoritmo de Dijkstra.
     *
     * @param origin  índice de la ciudad de origen en la lista de ciudades.
     * @param destiny índice de la ciudad de destino en la lista de ciudades.
     * @return una cadena de caracteres que indica la ruta más corta y su
     * distancia total, o un mensaje de que no se encontró una ruta entre las
     * ciudades especificadas.
     */
    public String showRoute(int origin, int destiny) {
        this.dijkstra = new DijkstraShortestPath<>(graph);
        this.shortestPath = dijkstra.getPath(cities.get(origin), cities.get(destiny));
        String out = "";

        if (shortestPath != null) {
            out += "La ruta más corta es: " + "\n";
            List<Location> shortestRoute = shortestPath.getVertexList();
            double shortestDistance = shortestPath.getWeight();
            for (int i = 0; i < shortestRoute.size() - 1; i++) {
                out += shortestRoute.get(i).getName() + " -> ";
            }
            out += shortestRoute.get(shortestRoute.size() - 1).getName();
            out += "\nLa distancia total de la ruta es: " + shortestDistance;
        } else {
            out += "\nNo se encontró una ruta entre las ciudades especificadas.";
        }
        return out;
    }

    /**
     * Método para lanzar la ventana de la interfaz gráfica.
     */
    public void launchWindow() {
        new Window().setVisible(true);
    }
}
